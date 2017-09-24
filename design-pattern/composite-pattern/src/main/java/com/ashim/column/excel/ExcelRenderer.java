package com.ashim.column.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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

import com.ashim.column.dto.Column;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcelRenderer {

	public static void renderExcel(Map<Integer, List<Column>> maps, ObjectMapper mapper)
			throws JsonProcessingException {

		System.out.println("Excel Renderer Start");

		List<ExcelColumn> columns = convertToExcelColumn(maps.get(1));
		constructExcelColumn(columns, 0, maps.size() - 1, 0, 0);

		System.out.println(mapper.writeValueAsString(columns));
		createExcel(columns);
	}

	private static void createExcel(List<ExcelColumn> cols) {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Column");

		CellStyle style = workbook.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		style.setVerticalAlignment(VerticalAlignment.CENTER);

		buildRowAndColumn(sheet, cols, style);

		try {
			FileOutputStream out = new FileOutputStream(new File("Column.xls"));
			workbook.write(out);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void buildRowAndColumn(Sheet sheet, List<ExcelColumn> cols, CellStyle style) {

		for (ExcelColumn col : cols) {

			Row row = sheet.getRow(col.getRowStart());
			row = row == null ? sheet.createRow(col.getRowStart()) : row;

			String output = String.format("Name : %s, RowStart : %s, RowEnd : %s, ColumnStart : %s, ColumnEnd : %s",
					col.getName(), col.getRowStart(), col.getRowEnd(), col.getColumnStart(), col.getColumnEnd());
			System.out.println(output);

			try {
				sheet.addMergedRegion(new CellRangeAddress(col.getRowStart(), col.getRowEnd(), col.getColumnStart(),
						col.getColumnEnd()));
			} catch (Exception e) {
				// e.printStackTrace();
				// break;
			}

			Cell cell = row.createCell(col.getColumnStart());
			cell.setCellValue(col.getName());
			cell.setCellStyle(style);

			if (col.hasChild()) {
				buildRowAndColumn(sheet, col.getChilds(), style);
			}
		}
	}

	private static List<ExcelColumn> convertToExcelColumn(List<Column> cols) {
		List<ExcelColumn> ecols = new ArrayList<>();

		for (Column col : cols) {
			ExcelColumn ecol = new ExcelColumn(col.getName());

			if (col.hasParent()) {
				ExcelColumn parent = new ExcelColumn(col.getParent().getName());
				ecol.setParent(parent);
			}

			if (col.hasChild()) {
				ecol.getChilds().addAll(convertToExcelColumn(col.getChilds()));
			}

			ecols.add(ecol);
		}

		return ecols;
	}

	private static int constructExcelColumn(List<ExcelColumn> columns, int rowStart, int rowEnd, int colStart,
			int colEnd) {
		int count = 0;
		for (ExcelColumn column : columns) {

			count++;
			column.setRowStart(rowStart);
			column.setRowEnd(rowEnd);
			column.setColumnStart(colStart);
			column.setColumnEnd(colEnd);

			if (column.hasChild()) {
				column.setRowEnd(rowStart);
				colEnd = constructExcelColumn(column.getChilds(), rowStart + 1, rowEnd, colStart, colEnd);
				column.setColumnEnd(colEnd);
				colStart = colEnd;
			}

			if (column.hasParent()) {
				column.notifyParent();
			}

			if (columns.size() != count) {
				colStart++;
				colEnd++;
			}
		}

		return colEnd;
	}
}
