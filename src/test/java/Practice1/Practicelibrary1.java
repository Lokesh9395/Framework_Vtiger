package Practice1;

import java.io.IOException;

import Com.crm.Genericlibrary.ExcelUtility;
import Com.crm.Genericlibrary.FileUtility;
import Com.crm.Genericlibrary.Javautility;
import Com.crm.Genericlibrary.WebDriverUtility;

public class Practicelibrary1 
{
	public static void main(String[] args) throws IOException 
	{
		Javautility Jlib=new Javautility();
		System.out.println(Jlib.getRandomNumber());
		System.out.println(Jlib.getCurrentDate());
		System.out.println(Jlib.getFinalDate());
		
		FileUtility flib=new FileUtility();
		String URL = flib.getDataFromPropertyFile("url");
		flib.getDataFromPropertyFile("password");
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
	}

}
