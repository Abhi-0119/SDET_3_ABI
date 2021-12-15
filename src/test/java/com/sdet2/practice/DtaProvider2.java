package com.sdet2.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DtaProvider2 {

	@Test(dataProvider = "getVAlue")
	public void Sample(String s1,String s2,String s3) {
		System.out.println(s1+" "+s2+" "+s3);
	}


	@DataProvider
	public Object[][] getVAlue() 
	{
		Object[][] arr =  new Object[5] [3];

		arr[0][0]="US1";
		arr[0][1]="pwd1";
		arr[0][2]="new3";
		
		arr[1][0]="US2";
		arr[1][1]="pwd2";
		arr[1][2]="new3";
		
		
		arr[2][0]="US3";
		arr[2][1]="pwd3";
		arr[2][2]="new3";
		
		arr[3][0]="US4";
		arr[3][1]="pwd4";
		arr[3][2]="new3";
		
		arr[4][0]="US5";
		arr[4][1]="pwd5";
		arr[4][2]="new3";
		
		return arr;

	}

}
