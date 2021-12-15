package com.sdet2.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewDataProvoder 
{
	@Test(dataProvider = "getValue")
	public void print(String value1, String value2)
	{
		System.out.println(value1 +" "+value2);
	}
	
	@DataProvider()
	public Object[][] getValue()
	{
		Object arr[][]= new Object[4][2];
		
		arr[0][0]="TYSS";
		arr[0][1]="HYD";
		
		arr[1][0]="QSp";
		arr[1][1]="Banglore";
		
		arr[2][0]="JSP";
		arr[2][1]="Chennai";
		
		arr[3][0]="PySpiders";
		arr[3][1]="Noida";
		
		return arr;
		
	}

}
