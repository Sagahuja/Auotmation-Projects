package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {
	private static Logger log = LogManager.getLogger(ExcelDataDriven.class.getName());

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(ExcelDataDriven.class.getName());
		ArrayList<String> testData = new ArrayList<String>();
		testData = getData("Login");
		System.out.println(testData);
		log.error("testerror");
		log.info("info");
		log.debug("debug");
		log.fatal("testfatal");

	}

	public static ArrayList<String> getData(String testCase) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\Learning\\Java\\Automation\\TestData.xlsx");
		ArrayList<String> testData = new ArrayList<String>();
		XSSFWorkbook excelFile = new XSSFWorkbook(fis);

		Iterator<Sheet> sheet = excelFile.sheetIterator();

		while (sheet.hasNext()) {
			Sheet sheetName = sheet.next();
			// System.out.println(sheetName);
			if (sheetName.getSheetName().equalsIgnoreCase("TestData")) {
				// System.out.println(sheetName.getSheetName());
				Iterator<Row> row = sheetName.iterator();
				Row firstRow = row.next();
				int k = 0;
				int columnno = 5;
				Iterator<Cell> cell = firstRow.cellIterator();
				while (cell.hasNext()) {
					Cell c = cell.next();

					if (c.getStringCellValue().equalsIgnoreCase("TestCase")) {
						columnno = k;
						// System.out.println(c.getStringCellValue());
					}
					k++;
				}

				// System.out.println(columnno);

				while (row.hasNext()) {
					Row r = row.next();

					// System.out.println(r.getCell(columnno).getStringCellValue());
					if (r.getCell(columnno).getStringCellValue().equalsIgnoreCase(testCase)) {

						Iterator<Cell> rc = r.cellIterator();
						while (rc.hasNext()) {
							Cell cc = rc.next();

							if (cc.getCellType() == CellType.STRING) {
								// System.out.println(cc.getStringCellValue());
								testData.add(cc.getStringCellValue());
							} else {

								// System.out.println( NumberToTextConverter.toText(cc.getNumericCellValue()));
								testData.add(NumberToTextConverter.toText(cc.getNumericCellValue()));
							}

						}

					}
				}

			}
		}
		return testData;

	}

}
