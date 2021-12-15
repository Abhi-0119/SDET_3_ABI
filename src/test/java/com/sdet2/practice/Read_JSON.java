package com.sdet2.practice;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Read_JSON {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException, ParseException {
		String dirpath=System.getProperty("user.dir");
		String jsonfilepath=dirpath+"/sdet3.json";

		FileReader fr = new FileReader(jsonfilepath);

		JSONParser jp = new JSONParser();

		Object data = jp.parse(fr);

		HashMap jobj = (HashMap) data;

		String value =jobj.get("un").toString();
		
		System.out.println(value);


	}

}
