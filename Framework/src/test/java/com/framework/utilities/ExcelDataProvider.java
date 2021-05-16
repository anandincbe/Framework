/**
 * 
 */
package com.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author anandmule
 *
 */
public class ExcelDataProvider {
	public XSSFWorkbook wb;

	public ExcelDataProvider() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("./TestData/conn_TestData.xlsx");
			wb = new XSSFWorkbook(fis);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//reading excel using sheet index
	public String getStringData(int sheetIndex, int row, int col) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	//reading excel using sheet name
	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}

	
	//retrun numeric value
	public int getNumericData(String sheetName, int row, int col) {
		return (int) wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}

}
