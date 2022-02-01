package com.crm.comcast.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class Sample1 
{
	public static void main(String[] args) throws InterruptedException, IOException
	{
		
		FileInputStream fis=new FileInputStream("./Data/common.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String UN = p.getProperty("username");
		String Pwd = p.getProperty("password");
	String OrgName=p.getProperty("organizationname");
	String OrgNo=p.getProperty("organizationno");
	String Web=p.getProperty("website");    
	String Ph=p.getProperty("phone");
	String Fax=p.getProperty("fax");
	String Email=p.getProperty("email");
	String Emp=p.getProperty("employees");    
	String Ownership=p.getProperty("ownership");
	String Sic=p.getProperty("siccode");
	String AR=p.getProperty("annualrevenue");
	String BA=p.getProperty("billingaddress");    
	String BC=p.getProperty("billingcity");
	String BS=p.getProperty("billingstate");
	String BPC=p.getProperty("billingpostalcode");
	String BCOUNTRY=p.getProperty("billingcountry");			
		
		
		WebDriver driver=null;
		
		if(BROWSER.equals("chrome"))
		{ 
			driver=new ChromeDriver();		
		}
		else if(BROWSER.equals("firefox"))
				{ 
			driver=new FirefoxDriver();		
		}
		else if(BROWSER.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
			
		
		//WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		//Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(Pwd);
		Thread.sleep(2000);
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.name("industry"));
		 Select s=new Select(ele1);
		 s.selectByIndex(27);
	     Thread.sleep(2000);
	     driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
	     
	     
	     driver.findElement(By.id("employees")).sendKeys(Emp);
	     driver.findElement(By.name("phone")).sendKeys(Ph);
	     driver.findElement(By.name("fax")).sendKeys(Fax);
	     driver.findElement(By.name("email1")).sendKeys(Email);
	     WebElement ele2 = driver.findElement(By.name("rating"));
	     Select s1=new Select(ele2);
		 s1.selectByIndex(1);
	     
	     driver.findElement(By.name("bill_street")).sendKeys(BA);
	     driver.findElement(By.name("bill_city")).sendKeys(BC);
	     driver.findElement(By.name("bill_state")).sendKeys(BS);
	     driver.findElement(By.name("bill_code")).sendKeys(BPC);
	     driver.findElement(By.name("bill_country")).sendKeys(BCOUNTRY);
	     driver.findElement(By.xpath("(//input[@name='cpy'])[2]")).click();
	     driver.findElement(By.xpath("(//input[@name='button'])")).click();
	     Thread.sleep(2000);
	     
	     WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     Actions a=new Actions(driver);
	     a.moveToElement(ele3).perform();
	     Thread.sleep(2000);
	     driver.findElement(By.linkText("Sign Out")).click();
	     Thread.sleep(2000);
	     System.out.println("Organization created successfully");
	     
	     
	     
		driver.close();
		
	

	
		
	}

}
