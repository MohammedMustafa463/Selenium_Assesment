package org.trident.servicenow.utils;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static String[][] readExcel(String excelFileName) throws IOException {
		
		XSSFWorkbook book = new XSSFWorkbook("./data/" + excelFileName + ".xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row Count: " + rowCount);
		int colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Column Count: " + colCount);
		String[][] data = new String[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = row.getCell(j);
				data[i - 1][j] = cell.getStringCellValue();
			}
		}
		book.close();
		return data;
	}

}
