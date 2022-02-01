package framework;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readexcelsheet 
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis =new FileInputStream("./Data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(lastrow);
		short lastcell = wb.getSheet("Sheet1").getRow(0).getLastCellNum();
		for(int i=0; i<=lastrow; i++)
		{
			for(int j=0;j<lastcell;j++)
			{
		String data1 = wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
		
		System.out.print("\t "+ data1);
		
	}
			System.out.println(" ");
		}

}
}
