package VTiger.Organization.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Notifyownertest 
{
	public static void main(String[] args) throws IOException, InterruptedException

	{
		FileInputStream fis=new FileInputStream("./Data/Commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String Url = p.getProperty("url");
		String BROWSER = p.getProperty("browser");
		String UN = p.getProperty("username");
		String Pwd = p.getProperty("password");
		
		FileInputStream fis1=new FileInputStream("./Data/TC_55.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Random r = new Random();
		int randomNum = r.nextInt(1000);
		String OrgName = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue()+randomNum;
		
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
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(Pwd);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		//Thread.sleep(2000);
		driver.findElement(By.linkText("Organizations")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.name("accountname")).sendKeys(OrgName);
		//Notify owner check box
		WebElement ele1 = driver.findElement(By.name("notify_owner"));
		
		
		ele1.click();
		Thread.sleep(2000);
		ele1.click();
		System.out.println("Notify_owner checkbox is enabled - " + ele1.isEnabled());
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
	     Thread.sleep(4000);

		
		WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	     Actions a=new Actions(driver);
	     a.moveToElement(ele3).build().perform();
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//a[. = 'Sign Out']")).click();
	     Thread.sleep(2000);
	     driver.close();
	}
	

}
