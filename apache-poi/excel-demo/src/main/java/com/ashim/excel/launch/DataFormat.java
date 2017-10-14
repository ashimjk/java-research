package com.ashim.excel.launch;

import com.ashim.excel.common.ExcelConstant;
import com.ashim.excel.common.ExcelUtility;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.util.Calendar;
import java.util.Date;

public class DataFormat {

    public static void main(String[] args) {
        Workbook workbook = new HSSFWorkbook();
        //Workbook workbook = new XSSFWorkbook();
        CreationHelper createHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("new sheet");

        // Create a row and put some cells in it. Rows are 0 based.
        Row row = sheet.createRow(0);

        // Create a cell and put a date value in it.  The first cell is not styled
        // as a date.
        Cell cell = row.createCell(0);
        cell.setCellValue(new Date());

        // we style the second cell as a date (and time).  It is important to
        // create a new cell style from the workbook otherwise you can end up
        // modifying the built in style and effecting not only this cell but other cells.
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(
                createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        cell = row.createCell(1);
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);

        //you can also set date as java.util.Calendar
        cell = row.createCell(2);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cellStyle);

        ExcelUtility.generateExcel(workbook, ExcelConstant.DATA_FORMAT);
    }
}
