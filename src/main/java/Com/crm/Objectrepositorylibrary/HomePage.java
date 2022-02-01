package Com.crm.Objectrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.Genericlibrary.WebDriverUtility;


public class HomePage extends WebDriverUtility
{
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(linkText="Organizations")
	private WebElement Orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement Contactlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement Adminicon;
	
	@FindBy(linkText="Sign Out")
	private WebElement Logoutbtn;
	
	
	
	public WebDriver getDriver()
	{
		return driver;
	}

	public WebElement getOrglink() 
	{
		return Orglink;
	}

	public WebElement getContactlink()
	{
		return Contactlink;
	}

	public WebElement getAdminicon() 
	{
		return Adminicon;
	}

	public WebElement getLogoutbtn()
	{
		return Logoutbtn;
	}

	public void logout(WebDriver driver)
	{
		mouseHover(driver, Adminicon);
		Logoutbtn.click();
		
	}
	

}
