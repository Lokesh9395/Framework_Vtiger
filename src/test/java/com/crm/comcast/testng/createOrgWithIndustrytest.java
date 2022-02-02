package com.crm.comcast.testng;

import java.io.IOException;

//import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.crm.Genericlibrary.BaseAnnotationClass;
import Com.crm.Genericlibrary.ExcelUtility;
//import Com.crm.Genericlibrary.Javautility;
//import Com.crm.Genericlibrary.WebDriverUtility;
import Com.crm.Objectrepositorylibrary.CreateOrganizationsPage;
import Com.crm.Objectrepositorylibrary.HomePage;
import Com.crm.Objectrepositorylibrary.OrganizationInfoPage;
import Com.crm.Objectrepositorylibrary.OrganizationsPage;

public class createOrgWithIndustrytest extends BaseAnnotationClass
{
	      int rnum = jlib.getRandomNumber();
	
		@Test(dataProvider = "details_orgIndustrytest")
		
		public void orgIndustrytest(String Organazation_Name,String Industry_type)
		{   
			System.out.println("\t" + Organazation_Name + "\t" + Industry_type);
			System.out.println(" \t ");
			
			HomePage hp=new HomePage(driver);
			hp.getOrglink().click();
			OrganizationsPage op=new OrganizationsPage(driver);
			op.getPlusbtn().click();
			
			CreateOrganizationsPage cop= new CreateOrganizationsPage(driver);
			
			cop.createOrgWithIndustrytext(Organazation_Name+rnum, Industry_type);
			
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			oip.orgVerification(driver, Organazation_Name+rnum);
			
			
			
			}
			
			
		

		@DataProvider
		 public Object[][] details_orgIndustrytest() throws EncryptedDocumentException, IOException
		{
			ExcelUtility elib=new ExcelUtility();
			int rows = elib.getRowCount("orgname");
			System.out.println(rows);
			int cell = elib.getCellCount("orgname", 0);
			System.out.println(cell);
			
			Object[][] objar= null;
					objar=new Object[rows][cell];
			for(int i=0;i<(rows);i++)
		
				{
					for(int j=0;j<cell;++j)
				{
						
					
					objar[i][j]=elib.getDataFromExcel("orgname", i, j); 
					objar[i][j]=elib.getDataFromExcel("orgname", i, j);
				}	
				}
			
			return objar;
			
		}
	}


