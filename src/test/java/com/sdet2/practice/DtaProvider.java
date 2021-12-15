package com.sdet2.practice;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Vtiger.genericUtil.ExcelUtility;

public class DtaProvider {

	@Test(dataProvider = "getVAlue")
	public void Sample(String s1,String s2,String s3)
	{
		System.out.println(s1+" "+s2+" "+s3);

	}


	@DataProvider
	public Object[][] getVAlue() throws EncryptedDocumentException, FileNotFoundException, IOException 
	{

		ExcelUtility eu= new ExcelUtility();

		Object[][] arr =  new Object[2][2];

		for (int i = 0; i <= 2; i++) 
		{

			arr[i][0] = eu.readDataExcel("Sheet2", i, 0);
			arr[i][1]= eu.readDataExcel("Sheet2", i, 1);
			arr[i][2]=eu.readDataExcel("Sheet2", i, 2);

		}
		return arr;
	}
	
	public void s1() {
		System.out.println("this is s1");
		
	}
}