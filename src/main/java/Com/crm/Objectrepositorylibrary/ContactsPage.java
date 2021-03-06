package Com.crm.Objectrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
public WebDriver driver;
	
	public  ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement Plusbtn ;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPlusbtn() {
		return Plusbtn;
	}
	
	public void contactcreate(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Plusbtn.click();
	}

}
