package com.Vtiger.genericUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	/**
	 *Description : To get last active row number
	 * 
	 * @param sheetname
	 * @return Last Active Row Number
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRow(String sheetname) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IAutoConstants.excelpath);

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetname);

		return sheet.getLastRowNum();

	}
	/**
	 * Description 
	 * @param sheetname
	 * @param cell
	 * @param DDvalue
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String selectValueforDD(String sheetname,int cell, String DDvalue) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IAutoConstants.excelpath);

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetname);

		int lastrow=getLastRow(sheetname);
		String value="Null";


		for (int i = 0; i <= lastrow ; i++)
		{
			value=sheet.getRow(i).getCell(cell).getStringCellValue();
			if(value.equalsIgnoreCase(DDvalue))
			{
				break;
			}
		}
		return value;
	}

	public String readDataExcel(String sheet,int row, int cell ) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IAutoConstants.excelpath);

		String  value = WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		return value;
	}

}
