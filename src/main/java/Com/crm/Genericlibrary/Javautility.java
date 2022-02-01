package Com.crm.Genericlibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class contains generic methods wrt java
 * @author Lokesh
 *
 */
public class Javautility 
{
	public int getRandomNumber() 
	{
		Random r = new Random();
		int ranNum = r.nextInt(1000); 
		return ranNum;
	
	}
	
	/** 
	 * This method will return current date
	 * @return
	 */
	public String getCurrentDate()
	{
		Date d=new Date();
		String date = d.toString();
		return date;
		
	}
		
	/**
	 * This method will return date in specified format
	 * @return
	 */
	public String getFinalDate()
	{
		Date d1=new Date();
		String date1 = d1.toString();
		String[] dte = date1.split(" ");
		String yyyy = dte[5];
		String dd = dte[2];
		String mm = dte[1];
		String today = (mm+"-"+dd+"-"+yyyy) ;
		return today;
	}

}
