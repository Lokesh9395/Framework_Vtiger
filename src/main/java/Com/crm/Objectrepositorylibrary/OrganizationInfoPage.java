package Com.crm.Objectrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class OrganizationInfoPage
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Header;
	
	

	public WebElement getHeader() {
		return Header;
	}
	
	public void orgVerification(WebDriver driver, String Orgname)
	{
		SoftAssert SA=new SoftAssert();
		String ActualTitle = Header.getText();
		/**if(ActualTitle.contains(Orgname))
		{
			System.out.println(Orgname + "=> organization created successfully, test passed ");
		}
		else
		{
			System.out.println("Organization not created, test failed");
		}
		*/
	boolean verification = ActualTitle.contains(Orgname);
		SA.assertTrue(verification, "contact not created, test failed");
		System.out.println(Orgname + "=> Contact created successfully, test passed ");
		SA.assertAll();
	}
	

}