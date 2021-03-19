package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream fis;
	XSSFWorkbook excelFile;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;

	

	public int getRowCount() throws IOException {
		fis = new FileInputStream("D:\\Downloads\\LoginData_1.xlsx");
		excelFile = new XSSFWorkbook(fis);
		sheet = excelFile.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		excelFile.close();
		fis.close();
		return rowCount;

	}

	public int getColumnCount() throws IOException {
		fis = new FileInputStream("D:\\Downloads\\LoginData_1.xlsx");
		excelFile = new XSSFWorkbook(fis);
		sheet = excelFile.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum();
		row = sheet.getRow(rowCount);

		int columnCount = row.getLastCellNum();

		excelFile.close();
		fis.close();
		return columnCount;

	}

	public String getCell(String path, String sheetName, int rows, int columns) throws IOException {
		fis = new FileInputStream(path);
		excelFile = new XSSFWorkbook(fis);
		sheet = excelFile.getSheet(sheetName);
		row = sheet.getRow(rows);
		cell = row.getCell(columns);
		
		return cell.getStringCellValue();
	}

}
