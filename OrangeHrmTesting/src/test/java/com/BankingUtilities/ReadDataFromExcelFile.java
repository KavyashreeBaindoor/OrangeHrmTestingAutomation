package com.BankingUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadDataFromExcelFile {

	public static FileInputStream fi;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	
	@DataProvider(name="getData")
	public String[][] readExcelData() throws IOException {
	File excelFile=new File(System.getProperty("user.dir")+"/src/test/java/com/bankingTestData/LoginData.xlsx");
	fi=new FileInputStream(excelFile);
	wb=new XSSFWorkbook(fi);
	ws =wb.getSheetAt(0);
	int TotalnoOfRows=ws.getPhysicalNumberOfRows();//0(header row) 1 2...
	int TotalNoOfColumns=ws.getRow(0).getLastCellNum();
	
	String[][] ExcelData=new String[TotalnoOfRows-1][TotalNoOfColumns];
//	exclude header of excel file=rows-1
	
	for(int i=0;i<TotalnoOfRows-1;i++) {
		//exclude header row
		for(int j=0;j<TotalNoOfColumns;j++) {
			DataFormatter d=new DataFormatter();
			//now any type of data in cell will will formatted to string format
			ExcelData[i][j]=d.formatCellValue(ws.getRow(i+1).getCell(j));
			//ws.getRow(i).getCell(j).getStringCellValue();
			
		}
	}
	
	wb.close();
	fi.close();
	
	return ExcelData;
	}
	
	

}
