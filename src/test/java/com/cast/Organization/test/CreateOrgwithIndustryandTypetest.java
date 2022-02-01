package com.cast.Organization.test;




import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Com.crm.Genericlibrary.ExcelUtility;
import Com.crm.Genericlibrary.FileUtility;
import Com.crm.Genericlibrary.Javautility;
import Com.crm.Genericlibrary.WebDriverUtility;
import Com.crm.Objectrepositorylibrary.CreateOrganizationsPage;
import Com.crm.Objectrepositorylibrary.HomePage;
import Com.crm.Objectrepositorylibrary.LoginPage;
import Com.crm.Objectrepositorylibrary.OrganizationInfoPage;
import Com.crm.Objectrepositorylibrary.OrganizationsPage;



public class CreateOrgwithIndustryandTypetest {
	
	public static void main(String[] args) throws Throwable {
		
		
		
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
		String Orgname = elib.getDataFromExcel("Sheet1",1,0)+random;
		
		
		/**
		 * It will Launch the browser
		 */
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
		
		/**
		 * Login page will Login to the application
		 */
		LoginPage lp=new LoginPage(driver);
		lp.Login(Username, Password);
		/**
		 * Homepage
		 */
		HomePage hp=new HomePage(driver);
		hp.getOrglink().click();
		/**
		 * Organisationpage
		 */
		OrganizationsPage op=new OrganizationsPage(driver);
		op.orgcreate(driver);
		/**
		 * CreateOrganisationpage
		 */
		CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
		cop.createOrgwithIndandType(Orgname, 6,3);
		
		/**
		 * Verification
		 */
		
		OrganizationInfoPage iop=new OrganizationInfoPage(driver);
		wlib.waitForElementToBeClickable(driver,iop.getHeader());
		String header = iop.getHeader().getText();
		if(header.contains(Orgname))
		{
			System.out.println("Test case passed");
			
		}
		else
		{
			System.out.println("Test  case failed");
		}
		
		hp.logout(driver);
		driver.quit();
	}

}