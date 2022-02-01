package Com.crm.Genericlibrary;

/**
 * @author Lokesh
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	/**
	 * This Method will read data from excel file and return the cell value
	 * @param Sheet
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDataFromExcel(String Sheet, int rowno, int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheet);
		Row RN = sh.getRow(rowno);
		Cell CN = RN.getCell(cellno);
		String Value = CN.getStringCellValue();
		return Value;
	}
	
	public int getRowCount(String Sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheet);
		wb.close();
		return sh.getLastRowNum();
		
	}
	public int getCellCount(String Sheet, int rownum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis); 
		Sheet sh=wb.getSheet(Sheet);
		int cellcount = sh.getRow(rownum).getLastCellNum();
		return cellcount;
		
	}
	public void enterDatatoExcel(String Sheet, int rowno, int cellno, Date data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(Sheet);
		Row RN = sh.getRow(rowno);
		Cell CN = RN.createCell(cellno);
		CN.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IpathConstants.Excelpath);
		wb.write(fos);
		wb.close();
		
	}

}

