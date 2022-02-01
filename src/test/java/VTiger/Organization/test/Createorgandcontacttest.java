package VTiger.Organization.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import Com.crm.Genericlibrary.ExcelUtility;
import Com.crm.Genericlibrary.FileUtility;
import Com.crm.Genericlibrary.Javautility;
import Com.crm.Genericlibrary.WebDriverUtility;

public class Createorgandcontacttest {
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Javautility jlib=new Javautility();
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		int ranNum=jlib.getRandomNumber();
		String USERNAME = flib.getDataFromPropertyFile("username");
		String PASSWORD = flib.getDataFromPropertyFile("password");
		String URL = flib.getDataFromPropertyFile("url");
		String BROWSER = flib.getDataFromPropertyFile("browser");
		
		String orgName = elib.getDataFromExcel("Sheet1", 1, 0) + ranNum;
		String ContName = elib.getDataFromExcel("Sheet1", 5, 1);
		System.out.println(orgName);

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
			
			wlib.windowMaximize(driver);
			wlib.waitUntilPageLoad(driver);
			driver.get(URL);
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			Thread.sleep(2000);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
			
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			
			WebElement ele1 = driver.findElement(By.name("industry"));
			ele1.click();
			wlib.dropDown(ele1, 11);
			
			WebElement ele2 = driver.findElement(By.name("accounttype"));
			ele2.click();
			wlib.dropDown(ele2, 3);
			
			driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		     Thread.sleep(4000);
		     
		     driver.findElement(By.linkText("Contacts")).click();
		     
             driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
             Thread.sleep(2000);
             
             WebElement ele3 = driver.findElement(By.name("salutationtype"));
 			ele3.click();
 			wlib.dropDown(ele3, 1);
 			driver.findElement(By.name("lastname")).sendKeys(ContName);
 			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
 			String partialWinTitle1 = "Accounts";
 			wlib.switchToWindow(driver, partialWinTitle1);
 			driver.findElement(By.id("search_txt")).sendKeys(orgName);
 			WebElement ele4 = driver.findElement(By.name("search_field"));
 			ele4.click();
 			wlib.dropDown(ele4, 0);
 			
 			driver.findElement(By.name("search")).click();
 			Thread.sleep(3000);
 			driver.findElement(By.id("1")).click();
 			
 			String partialWinTitle2 = "Contacts";
 			wlib.switchToWindow(driver, partialWinTitle2);
 			
 			driver.findElement(By.xpath("//input[@type='submit']")).click();
 			
 			String Conheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
 			if(Conheader.contains(ContName))
 			{
 				System.out.println("contact created successfully with org name...test case passed");
 			}
 			else
 			{
 				System.out.println("contact not created...test case failed");
 			}
			
			WebElement ele5 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wlib.mouseHover(driver, ele5);
			
			 Thread.sleep(2000);
		     driver.findElement(By.xpath("//a[. = 'Sign Out']")).click();
			driver.quit();


}
}
