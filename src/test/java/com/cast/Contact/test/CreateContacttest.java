package com.cast.Contact.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.crm.Genericlibrary.ExcelUtility;
import Com.crm.Genericlibrary.FileUtility;
import Com.crm.Genericlibrary.Javautility;
import Com.crm.Genericlibrary.WebDriverUtility;
import Com.crm.Objectrepositorylibrary.ContactInfoPage;
import Com.crm.Objectrepositorylibrary.ContactsPage;
import Com.crm.Objectrepositorylibrary.CreateContactsPage;
import Com.crm.Objectrepositorylibrary.HomePage;
import Com.crm.Objectrepositorylibrary.LoginPage;

public class CreateContacttest 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileUtility flib=new FileUtility();
		ExcelUtility elib=new ExcelUtility();
		Javautility jlib=new Javautility();
		WebDriverUtility wlib=new WebDriverUtility();
		/**
		 * Get random number
		 */
		int random = jlib.getRandomNumber();
		/**
		 * Get data from property file
		 * @author ELCOT
		 * @Username
		 * @password
		 * @Url
		 */
		
		String Browser = flib.getDataFromPropertyFile("browser");
		String Url = flib.getDataFromPropertyFile("url");
		String Username = flib.getDataFromPropertyFile("username");
		String Password= flib.getDataFromPropertyFile("password");
		/**
		 * Get data from ExcelFile
		 */
		String Orgname = elib.getDataFromExcel("Sheet1",5,0)+random;
		String ContName = elib.getDataFromExcel("Sheet1", 5, 1);
		
		WebDriver driver=null;
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser selected");
		}
		
		/**
		 * maximize window
		 */
		wlib.windowMaximize(driver);
		wlib.waitUntilPageLoad(driver);
		driver.get(Url);
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(Username, Password);
		
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();	
		
		ContactsPage cp=new ContactsPage(driver);
		cp.contactcreate(driver);
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.newcontact(1, ContName);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.contactVerification(driver, ContName);
		
		hp.logout(driver);
		
		driver.close();
		
	}

}
