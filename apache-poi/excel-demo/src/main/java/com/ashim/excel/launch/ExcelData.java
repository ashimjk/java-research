package com.ashim.excel.launch;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ashim.excel.common.ExcelConstant;
import com.ashim.excel.common.ExcelUtility;

public class ExcelData {

	public static void main(String[] args) {
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("ExcelEx");

		Cell cell1 = sheet.createRow(0).createCell(0);
		Cell cell2 = sheet.createRow(0).createCell(1);
		Cell cell3 = sheet.createRow(0).createCell(2);
		Cell cell4 = sheet.createRow(0).createCell(3);
		Cell cell5 = sheet.createRow(0).createCell(4);

		cell1.setCellValue("60");
		cell2.setCellValue("+");
		cell3.setCellValue("25");
		cell4.setCellValue("=");
		cell5.setCellFormula("A1+C1");

		ExcelUtility.generateExcel(workbook, ExcelConstant.EXCEL_DATA);
	}

}
