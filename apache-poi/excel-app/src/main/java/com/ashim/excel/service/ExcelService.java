package com.ashim.excel.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service Provider for {@code ExcelService}
 *
 * @author Ashim Jung Khadka <br>
 *         Created Date : Sep 24, 2017
 *
 */
@Service
public class ExcelService {

	private static final Logger logger = LoggerFactory.getLogger(ExcelService.class);

	private static final int LEVEL_STARTING_POS = 1;
	private static final int ROW_STARTING_POS = 0;
	private static final int COL_STARTING_POS = 0;
	private static final int COL_ENDING_POS = 0;

	@Autowired
	private RestTemplate template;

	/**
	 * Construct the parent-child relationship, row-column mapping and generates an
	 * excel
	 *
	 * @return - {@code Map} with {@code List} of {@link ExcelColumn}
	 */
	public Map<Integer, List<ExcelColumn>> generateExcel() {

		logger.info("ExcelService : generateExcel()");

		Map<Integer, List<ExcelColumn>> maps = this.getExcelColumnData();

		// construct the relationship
		this.constructParentChildRelation(maps, LEVEL_STARTING_POS);

		// construct the row-column for excel-column
		// only passing the first level because it already holds the parent child
		// relationship
		List<ExcelColumn> columns = maps.get(LEVEL_STARTING_POS);
		this.constructRowColumnUsingColumnChild(columns, ROW_STARTING_POS, maps.size() - 1, COL_STARTING_POS,
				COL_ENDING_POS);

		// generate excel
		this.createExcel(columns);

		return maps;
	}

	/**
	 * Get the excel-column data from the service (REST API)
	 *
	 * @return {@code Map} with {@code List} of {@link ExcelColumn}
	 */
	public Map<Integer, List<ExcelColumn>> getExcelColumnData() {

		logger.info("ExcelService : getExcelColumnData()");

		Map<Integer, List<ExcelColumn>> maps = null;
		try {
			URI uri = new URI("http://localhost:8081/columns");
			RequestEntity<Void> requestEntity = RequestEntity.get(uri).accept(MediaType.APPLICATION_JSON).build();

			ParameterizedTypeReference<Map<Integer, List<ExcelColumn>>> responseType = new ParameterizedTypeReference<Map<Integer, List<ExcelColumn>>>() {
			};

			ResponseEntity<Map<Integer, List<ExcelColumn>>> resp = this.template.exchange(requestEntity, responseType);

			maps = resp.getBody();

		} catch (URISyntaxException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		return maps;
	}

	/**
	 * Construct Parent Child Relationship for {@link ExcelColumn}
	 *
	 * @param columnMaps
	 *            - list of {@code ExcelColumn} in {@code Map}
	 * @param level
	 *            - starting position for recursive search
	 */
	public void constructParentChildRelation(Map<Integer, List<ExcelColumn>> columnMaps, Integer level) {

		logger.info("ExcelService : constructParentChildRelation()");
		logger.debug("colMaps : {}, level : {}", columnMaps, level);

		List<ExcelColumn> parentCols = columnMaps.get(level);

		// Note : Since List default size is 16 because of this level can be maintain
		// only upto 15 otherwise it will throw null pointer exception
		List<ExcelColumn> childCols = columnMaps.get(level + 1);

		// If no-child is present then no need to construct the relation
		if (childCols == null) {
			return;
		}

		// Recursively adding child for its parent
		for (ExcelColumn parent : parentCols) {
			for (ExcelColumn child : childCols) {

				if (parent.equals(child.getParent())) {
					parent.getChilds().add(child);
				}
			}
		}

		// Go for next level
		this.constructParentChildRelation(columnMaps, level + 1);

	}

	/**
	 * Construct Row and Column value by looking recursively in parent child
	 * relation
	 *
	 * @param columns
	 *            - list of column : assumes parent-child relationship are already
	 *            mapped
	 * @param rowStart
	 *            - initial position for excel row
	 * @param rowEnd
	 *            - ending position for excel row
	 * @param colStart
	 *            - intital position for excel column
	 * @param colEnd
	 *            - intital postion for excel column
	 *
	 * @return last position of child column
	 */
	public int constructRowColumnUsingColumnChild(List<ExcelColumn> columns, int rowStart, int rowEnd, int colStart,
			int colEnd) {

		logger.info("ExcelService : constructRowColumnUsingColumnChild()");
		logger.debug("columns : {}, rowStart : {}, rowEnd : {}, colStart : {}, colEnd : {}", columns, rowStart, rowEnd,
				colStart, colEnd);

		int count = 0;
		for (ExcelColumn column : columns) {

			count++;

			// Initial setup
			column.setRowStart(rowStart);
			column.setRowEnd(rowEnd);
			column.setColumnStart(colStart);
			column.setColumnEnd(colEnd);

			if (column.hasChild()) {
				// If child is present that no need to merge the row
				column.setRowEnd(rowStart);

				// Recursive for constructing row-column for childs-child
				colEnd = this.constructRowColumnUsingColumnChild(column.getChilds(), rowStart + 1, rowEnd, colStart,
						colEnd);

				// Upto which region, parent can merge the column
				column.setColumnEnd(colEnd);

				// For next column column end will be column start
				colStart = colEnd;
			}

			if (column.hasParent()) {
				// Notify parent that child has been added
				column.notifyParent();
			}

			// Handles for extra cell that might get added to last column
			if (columns.size() != count) {
				colStart++;
				colEnd++;
			}
		}

		return colEnd;
	}

	/**
	 * Create an excel name 'Column.xls'
	 *
	 * @param columns
	 *            - {@code List} of {@link ExcelColumn} : it assumes that row and
	 *            column are already mapped
	 */
	public void createExcel(List<ExcelColumn> columns) {

		logger.info("ExcelService : createExcel()");
		logger.debug("cols : {}", columns);

		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Column");

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		this.buildRowAndColumnForExcel(sheet, style, columns);

		try {
			FileOutputStream out = new FileOutputStream(new File("src/main/resources/Column.xls"));
			workbook.write(out);
			workbook.close();

		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Merge the region for row and column and set the column value for excel
	 *
	 * @param sheet
	 *            - {@link Sheet}
	 * @param style
	 *            - {@link CellStyle}
	 * @param columns
	 *            - {@code List} of {@link ExcelColumn} : it assumes that row and
	 */
	public void buildRowAndColumnForExcel(Sheet sheet, CellStyle style, List<ExcelColumn> columns) {

		logger.info("ExcelService : buildRowAndColumnForExcel()");
		logger.debug("cols : {}", columns);

		for (ExcelColumn column : columns) {

			Row row = sheet.getRow(column.getRowStart());
			row = row == null ? sheet.createRow(column.getRowStart()) : row;

			logger.debug("Name : {}, RowStart : {}, RowEnd : {}, ColumnStart : {}, ColumnEnd : {}", column.getName(),
					column.getRowStart(), column.getRowEnd(), column.getColumnStart(), column.getColumnEnd());

			try {
				sheet.addMergedRegion(new CellRangeAddress(column.getRowStart(), column.getRowEnd(),
						column.getColumnStart(), column.getColumnEnd()));
			} catch (Exception e) {
				// No need to handle exception
				// If merge region fails then its the last child at last row/column level
			}

			Cell cell = row.createCell(column.getColumnStart());
			cell.setCellValue(column.getName());

			// Making sure that all cell are centered
			cell.setCellStyle(style);

			if (column.hasChild()) {
				// Recursive
				this.buildRowAndColumnForExcel(sheet, style, column.getChilds());
			}
		}
	}
}
