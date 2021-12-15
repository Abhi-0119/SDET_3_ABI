package com.sdet2.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_Propfile {

	public static void main(String[] args) throws IOException 
	{
		String dirpath=System.getProperty("user.dir");
		String propfilepath=dirpath+"/commondata.properties";

		FileInputStream fis = new FileInputStream(propfilepath);

		Properties prop= new Properties();

		prop.load(fis);

		String value=prop.getProperty("url");

		System.out.println(value);
	}

}
