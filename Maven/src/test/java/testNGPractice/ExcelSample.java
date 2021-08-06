package testNGPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelSample {

	@Test
	public void testdata() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Downloads\\LoginData.xlsx");
		XSSFWorkbook excelfile= new XSSFWorkbook(fis);
		XSSFSheet sheet = excelfile.getSheet("Sheet1");
		int rowCount  = sheet.getLastRowNum();
		int colCount= sheet.getRow(rowCount).getLastCellNum();
		
		
		for(int i=0; i<=rowCount; i++)
		{
			for(int j=0; j<colCount; j++)
			{
				XSSFRow Row =sheet.getRow(i);
				Cell  cell = Row.getCell(j);
				System.out.print(cell.getStringCellValue()+"  ");
			}
			System.out.println();
		}
		
	}
	// XSSFWorkbook

}
