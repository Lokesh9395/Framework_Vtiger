package Com.crm.Genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListImp implements ITestListener

{
	

	public void onTestFailure(ITestResult result) 
	{
		Javautility jlib=new Javautility();
		String Date = jlib.getCurrentDate().replace(":", "_").replace(" ", "_");
		
		EventFiringWebDriver efwDriver=new EventFiringWebDriver(BaseAnnotationClass.sdriver);
		File src = efwDriver.getScreenshotAs(OutputType.FILE);
		String add = result.getMethod().getMethodName();
	
		File dest=new File("./Image/_"+ Date + add + ".png");
		
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
	} 

}
