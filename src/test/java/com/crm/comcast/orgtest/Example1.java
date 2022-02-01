package com.crm.comcast.orgtest;

	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class Example1
	{
		public static void main(String[] args) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis=new FileInputStream("./data/Book1.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String OrgName = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
			System.out.println(OrgName);
			
		}


}
