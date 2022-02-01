package Com.crm.Objectrepositorylibrary;

 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	public WebDriver driver;
	
	public  OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Plusbtn;
	
	
	public WebElement getPlusbtn()
	{
		return Plusbtn;
	}
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	public void orgcreate(WebDriver driver)
	{
		Plusbtn.click();
	}

}
