package Com.crm.Genericlibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility 

{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	
	/**
	 * This method will wait   20sec for the page to load
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		   
	 }
	
	/**
	 * This method will wait for the element to be clicked
	 * * @param driver
	 * @param element
	 */
	   public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 40);
		  wait.until(ExpectedConditions.elementToBeClickable(element));
	   }

	   /**
	    * This method is for customized wait, it will wait for the element to be clicked
	 * @param element 
	 * @throws InterruptedException 
	    */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			try {element.click();
			break;}
			catch(Throwable e)
			{
				Thread.sleep(1000);
			count++;
			}
			
			
			}
		}
	
	/**
	 * This method will select option in dropdown by index
	 * @param element
	 * @param i
	 */
	public void dropDown(WebElement element, int i)
	{
		Select s= new Select(element);
		s.selectByIndex(i);
		
	}
	
	/**
	 * This method will select option in dropdown by value of element
	 * @param element
	 * @param value
	 */
	public void dropDown(WebElement element, String value)
	{
		Select s= new Select(element);
		s.selectByValue(value);
		
	}	
	
	/**
	 * This method will select option in dropdown by visible text of element
	 * @param text
	 * @param element
	 */
	public void dropDown(String text,WebElement element)
	{
		Select s= new Select(element);
		s.selectByVisibleText(text);
		
	}
	
	
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions A=new Actions(driver);
		A.moveToElement(element).perform();
				
	}
	
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions A=new Actions(driver);
		A.contextClick(element).perform();
				
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions A=new Actions(driver);
		A.doubleClick(element).perform();
				
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target)
	{
		Actions A=new Actions(driver);
		A.dragAndDrop(source, target).perform();
				
	}
	
    /**
     * This method will switch the control from one window to another
     * @param driver
     * @param partialWinTitle
     */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }
			   
		   }
		   
	   }
	
	public void switchToFrame(WebDriver driver, String i)
	{
		driver.switchTo().frame(i);
	}
	
	public void switchToFrame(WebDriver driver,WebElement element) 
	{
    	driver.switchTo().frame(element);

	}
	
	public void alertPopupAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	
	public void alertPopupDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

    /**
     * this method is used to take screenshot and save in images folder
     * @param driver
     * @param screenshotName
     * @throws Throwable
     */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./Images/"+screenshotName+".PNG");
    	Files.copy(src, dest);
    }
    
	   public void passEnterKey(WebDriver driver)
	   {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 

	   /**
		 * Scroll until
		 * @param driver
		 * 
		 * @param element
		 */
		public void scrollToElement(WebDriver driver,WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("argument[0].scrollIntoView()",element);
		}
		
		//Method to use shortcut keys
		public void enterKey() throws AWTException
		{
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
		
			r.keyRelease(KeyEvent.VK_ENTER);
		}
}
