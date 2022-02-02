package Com.crm.Objectrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.crm.Genericlibrary.WebDriverUtility;

public class CreateOrganizationsPage extends WebDriverUtility
{
	public WebDriver driver;
	public CreateOrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="accountname")
	private WebElement OrgName;
	
	@FindBy(name="industry")
	private WebElement IndusTry;
	
	@FindBy(name="accounttype")
	private WebElement Type;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	
	public void createOrg(String Orgname)
	{
		OrgName.sendKeys(Orgname);
		SaveBtn.click();
		
	}
	public void createOrgwithIndandType(String Orgname, int i, int j)
	{
		OrgName.sendKeys(Orgname);
		dropDown(IndusTry, i);
		dropDown(Type, j);
		SaveBtn.click();
	}

	public void createOrgWithIndustrytext(String Orgname, String Industrytext)
	{
		OrgName.sendKeys(Orgname);
		dropDown(Industrytext,IndusTry);
		SaveBtn.click();
		
		
	}

	public WebDriver getDriver() 
	{
		return driver;
	}

	public WebElement getOrgName()
	{
		return OrgName;
	}

	public WebElement getIndusTry()
	{
		return IndusTry;
	}

	public WebElement getType()
	{
		return Type;
	}

	public WebElement getSaveBtn()
	{
		return SaveBtn;
	}

	
}
