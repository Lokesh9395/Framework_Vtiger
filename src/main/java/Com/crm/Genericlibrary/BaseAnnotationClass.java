package Com.crm.Genericlibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Com.crm.Objectrepositorylibrary.HomePage;
import Com.crm.Objectrepositorylibrary.LoginPage;

public class BaseAnnotationClass 
{ 
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public Javautility jlib=new Javautility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;//only for screenshot (Listener)
	
	//@Parameters("browser")//for cross browser execution
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void configBC(/**String browser*/) throws IOException
	{                    // ^ for cross browser execution
		//launch browser
		/**
		 * It will Launch the browser
		 */
		//comment below line 34 for cross browser execution
		String Browser = flib.getDataFromPropertyFile("browser");
		String Url = flib.getDataFromPropertyFile("url");
		
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
		sdriver=driver;//only for screenshot(listener)
	}
	
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void configBM() throws IOException
	{
		
		//login
		/**
		 * Get data from property file
		 * @author Lokesh
		 * @Username
		 * @password
		 * @Url
		 */
		
		String Username = flib.getDataFromPropertyFile("username");
		String Password= flib.getDataFromPropertyFile("password");
		/**
		 * Login page will Login to the application
		 */
		LoginPage lp=new LoginPage(driver);
		lp.Login(Username, Password);
		
	}
	
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void configAM()
	{
		//logout
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		
		
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void configAC()
	{
		//close browser
		driver.quit();
	}
	

}
