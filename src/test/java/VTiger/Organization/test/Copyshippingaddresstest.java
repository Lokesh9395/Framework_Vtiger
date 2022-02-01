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
import org.openqa.selenium.support.ui.Select;

public class Copyshippingaddresstest 
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
		
		FileInputStream fis1=new FileInputStream("./Data/organiszationdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Random r = new Random();
		int rn = r.nextInt(1000);
		
		int lastrow = wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(lastrow);
		
		for(int i=1; i<=lastrow; i++)
		{
			
		String OrgName = wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue()+rn;
		String Orgno = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
		String Website = wb.getSheet("Sheet1").getRow(i).getCell(2).getStringCellValue();
		String Phone = wb.getSheet("Sheet1").getRow(i).getCell(3).getStringCellValue();
		String fax = wb.getSheet("Sheet1").getRow(i).getCell(4).getStringCellValue();
		String Email = wb.getSheet("Sheet1").getRow(i).getCell(6).getStringCellValue();
		String Emp = wb.getSheet("Sheet1").getRow(i).getCell(8).getStringCellValue();
		String BA = wb.getSheet("Sheet1").getRow(i).getCell(18).getStringCellValue();
		String BPO = wb.getSheet("Sheet1").getRow(i).getCell(19).getStringCellValue();
		String BC = wb.getSheet("Sheet1").getRow(i).getCell(20).getStringCellValue();
		String BS = wb.getSheet("Sheet1").getRow(i).getCell(21).getStringCellValue();
		String BPC = wb.getSheet("Sheet1").getRow(i).getCell(22).getStringCellValue();
		String BCOUNTRY = wb.getSheet("Sheet1").getRow(i).getCell(23).getStringCellValue();
		
		
		
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
         Thread.sleep(1000);
	     driver.findElement(By.id("employees")).sendKeys(Emp);
	     Thread.sleep(1000);
	     driver.findElement(By.name("phone")).sendKeys(Phone);
	     Thread.sleep(1000);
	     driver.findElement(By.name("fax")).sendKeys(fax);
	     Thread.sleep(1000);
	     driver.findElement(By.name("email1")).sendKeys(Email);
	     Thread.sleep(1000);
	     WebElement ele2 = driver.findElement(By.name("rating"));
	     Select s1=new Select(ele2);
		 s1.selectByIndex(1);
	     
	     driver.findElement(By.name("ship_street")).sendKeys(BA);
	     Thread.sleep(1000);
	     driver.findElement(By.name("ship_city")).sendKeys(BC);
	     Thread.sleep(1000);
	     driver.findElement(By.name("ship_state")).sendKeys(BS);
	     Thread.sleep(1000);
	     driver.findElement(By.name("ship_code")).sendKeys(BPC);
	     Thread.sleep(1000);
	     driver.findElement(By.name("ship_country")).sendKeys(BCOUNTRY);
	     WebElement ele1 = driver.findElement(By.xpath("(//input[@name='cpy'])[1]"));
	    
	     ele1.click();
	     Thread.sleep(2000);
	     ele1.click();
	     Thread.sleep(2000);
	     
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
}

