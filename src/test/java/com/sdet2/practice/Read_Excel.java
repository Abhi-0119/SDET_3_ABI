package com.sdet2.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Read_Excel {

	@Test
	public void readData() throws EncryptedDocumentException, IOException {

//		String dirpath=System.getProperty("user.dir");
//		String Excelpath=dirpath+"/SDET2.xlsx";
//
//		FileInputStream fis = new FileInputStream(Excelpath);
//
//		Workbook workbook = WorkbookFactory.create(fis);
//
//		Sheet sheet = workbook.getSheet("Sheet1");
//
//		Row row = sheet.getRow(1);
//
//		String value = row.getCell(1).getStringCellValue();
//
//		int a=Integer.parseInt(value);
		
		int a =5;
		
		System.out.println("old ");
		
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(6, 5);
		
		System.out.println("New line");
		softassert.assertAll();
		
//		System.out.println(a);
	
	}
}
