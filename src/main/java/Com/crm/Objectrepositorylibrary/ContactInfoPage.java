package Com.crm.Objectrepositorylibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ContactInfoPage
{
	WebDriver driver;
	 public ContactInfoPage(WebDriver driver) 
	{
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement Header;

	public WebElement getHeader() {
		return Header;
	}
	
	public void contactVerification(WebDriver driver, String contactname)
	{
		SoftAssert SA=new SoftAssert();
		String ActualTitle = Header.getText();
		/**if(ActualTitle.contains(contactname))
		{
			System.out.println(contactname + "=> Contact created successfully, test passed ");
		}
		else
		{
			System.out.println("contact not created, test failed");
		}
		*/
	    boolean verification = ActualTitle.contains(contactname);
		SA.assertTrue(verification, "contact not created, test failed");
		System.out.println(contactname + "=> Contact created successfully, test passed ");
		SA.assertAll();
	}

}
