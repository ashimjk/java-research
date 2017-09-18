package com.ashim.excel.common;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;

public class ExcelUtility {

	public static boolean generateExcel(Workbook workbook, String fileName) {
		try {
			FileOutputStream output = new FileOutputStream(fileName);
			workbook.write(output);
			output.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
