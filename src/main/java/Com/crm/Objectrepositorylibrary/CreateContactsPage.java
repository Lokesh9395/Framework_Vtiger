package Com.crm.Objectrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.Genericlibrary.WebDriverUtility;

public class CreateContactsPage extends WebDriverUtility
{
	WebDriver driver;
	public CreateContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//select[@name='salutationtype']")
	private WebElement salutation;
	
	@FindBy(xpath ="//input[@name='lastname']")
	private WebElement CLname;
	
	@FindBy(xpath ="//input[@type='submit']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orglookup;
	
	@FindBy(id = "search_txt")
	private WebElement searchorg;
	@FindBy(name="search_field")
    private WebElement Indropdown;
	
	@FindBy(name="search")
    private WebElement searchbtn;
	
	@FindBy(id ="1")
	private WebElement createdorg;
    
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSalutation() {
		return salutation;
	}

	public WebElement getCLname() {
		return CLname;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void newcontact(int i, String LastName) 
	{
		dropDown(salutation, i);
		CLname.sendKeys(LastName);
		savebtn.click();
	}
	
	public void newcontactwithorg(int i, String LastName, String Organizationname) throws InterruptedException 
	{
		dropDown(salutation, i);
		CLname.sendKeys(LastName);
		orglookup.click();
		String partialWinTitle1 = "Accounts";
	   switchToWindow(driver, partialWinTitle1);
	   searchorg.sendKeys(Organizationname);
	   dropDown(Indropdown, 0);
	   searchbtn.click();
	   Thread.sleep(2000);
	   createdorg.click();
	   String partialWinTitle2="Contacts";
	   switchToWindow(driver, partialWinTitle2);
		savebtn.click();
		
	}
	
	

}
