package com.crm.comcast.orgtest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrnsht {
	
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException
	{
		
		
		//opens empty chrome browser
        WebDriver driver=new  ChromeDriver();
        
        driver.manage().window().maximize();
        
        //Enter the URL
        driver.get("https://www.myntra.com/");
      //implicit wait
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        TakesScreenshot t=(TakesScreenshot)driver;
       File src=t.getScreenshotAs(OutputType.FILE);
       File dest=new File("./Image/myntra1.png");
       FileUtils.copyFile(src, dest);
       
       Thread.sleep(2000);
       driver.close();
	}
}

