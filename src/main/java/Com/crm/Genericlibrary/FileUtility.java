package Com.crm.Genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
/**
 * This method is used to read data from properties file
 * @param key
 * @return
 * @throws IOException
 */
	public String getDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis=new FileInputStream(IpathConstants.PropertyFilePath);
		Properties p=new Properties();
		p.load(fis);
		String Value = p.getProperty(key);
		return Value;
	}

}
