package Com.crm.Genericlibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
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

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


}
