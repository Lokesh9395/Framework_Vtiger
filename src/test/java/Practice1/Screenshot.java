package Practice1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class Screenshot {
	@Test
	public void takescreenshot() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		EventFiringWebDriver efwDriver=new EventFiringWebDriver(driver);
		File src = efwDriver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Image/test.jpg");
		FileUtils.copyFile(src, dest);
		driver.close();
	}

}
