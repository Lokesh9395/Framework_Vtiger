package Com.crm.Objectrepositorylibrary;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		
		    public WebDriver driver;
		    public LoginPage(WebDriver driver)
			{
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}

		    
			@FindBy(name="user_name")
			private WebElement userName;
			
			@FindBy(name="user_password")
			private WebElement passWord;
			
			@FindBy(id="submitButton")
			private WebElement loginbtn;
			
			
			public WebDriver getDriver() 
			{
				return driver;
			}

			public WebElement getUserName() 
			{
				return userName;
			}

			public WebElement getPassWord() 
			{
				return passWord;
			}


			public WebElement getLoginbtn()
			{
				return loginbtn;
			}


			public void Login(String username,String password)
			{
				userName.sendKeys(username);
				passWord.sendKeys(password);
				loginbtn.click();
			}

	}



