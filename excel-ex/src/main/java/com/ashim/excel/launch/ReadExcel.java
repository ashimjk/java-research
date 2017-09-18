package com.ashim.excel.launch;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ashim.excel.common.ExcelConstant;

public class ReadExcel {

	public static void main(String... args) {

		try {
			Workbook workbook = new HSSFWorkbook(new FileInputStream(ExcelConstant.READ_EXCEL));
			Sheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				for (Cell cell : row) {
					cell.setCellType(CellType.STRING);
					System.out.print(cell.getStringCellValue() + "\t");
				}
				System.out.println();
			}

			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
