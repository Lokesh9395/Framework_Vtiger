package Practice1;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Sample2 {
	
		public static void main(String[] args) throws EncryptedDocumentException, IOException
		{
	
	
	FileInputStream fis1=new FileInputStream("./Data/organiszationdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	String OrgName = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	System.out.println(OrgName);

}
}
