package com.crm.comcast.testng;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Com.crm.Genericlibrary.BaseAnnotationClass;
import Com.crm.Objectrepositorylibrary.CreateOrganizationsPage;
import Com.crm.Objectrepositorylibrary.HomePage;
import Com.crm.Objectrepositorylibrary.OrganizationInfoPage;
import Com.crm.Objectrepositorylibrary.OrganizationsPage;

public class CreateOrgTestNgTest extends BaseAnnotationClass
{
	
	
	
	@Test(groups = "smokeTest")
	public void Createorgtest() throws IOException
	{
	
				/**
				 * Get random number
				 */
				int random = jlib.getRandomNumber();
			
				/**
				 * Get data from ExcelFile
				 */
				String Orgname = elib.getDataFromExcel("Sheet1",1,0)+random;
				
				/**
				 * Homepage
				 */
				HomePage hp=new HomePage(driver);
				hp.getOrglink().click();
				/**
				 * Organisationpage
				 */
				OrganizationsPage op=new OrganizationsPage(driver);
				op.orgcreate(driver);
				/**
				 * CreateOrganisationpage
				 */
				CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
				cop.createOrg(Orgname);
				
				/**
				 * Verification
				 */
				
				OrganizationInfoPage iop=new OrganizationInfoPage(driver);
				wlib.waitForElementToBeClickable(driver,iop.getHeader());
				//String header = iop.getHeader().getText();
				/**
				//  if(header.contains(Orgname))
				
				*{
				*	System.out.println("Test case passed");
					
				*}
				*else
				*{
				*	System.out.println("Test  case failed");
				*}
			 */
				//boolean verification = header.contains(Orgname);
				//Assert.assertTrue(verification, "Organization not created => test case Failed");
				//System.out.println("Organization created successfully => testcase passed");
				iop.orgVerification(driver, Orgname);	
			}
		
		
		@Test(groups = "regressionTest")
		public void CreateOrgwithIndustryandTypetest() throws IOException 
		{
								
				/**
				 * Get random number
				 */
				int random = jlib.getRandomNumber();
				
				//  Get data from ExcelFile
				 
				String Orgname = elib.getDataFromExcel("Sheet1",1,0)+random;
				
				 // Homepage
				 
				HomePage hp=new HomePage(driver);
				hp.getOrglink().click();
				/**
				 * Organisationpage
				 */
				OrganizationsPage op=new OrganizationsPage(driver);
				op.orgcreate(driver);
				/**
				 * CreateOrganisationpage
				 */
				CreateOrganizationsPage cop=new CreateOrganizationsPage(driver);
				cop.createOrgwithIndandType(Orgname, 6,3);
				
				/**
				 * Verification
				 */
				
				OrganizationInfoPage iop=new OrganizationInfoPage(driver);
				wlib.waitForElementToBeClickable(driver,iop.getHeader());
				//String header = iop.getHeader().getText();
				//if(header.contains(Orgname))
				//{
				//	System.out.println("Test case passed");
					
				//}
				//else
				//{
				//	System.out.println("Test  case failed");
				//}
				//boolean verification = header.contains(Orgname+20);
				//Assert.assertTrue(verification, "Organization with Industry and type not created => test case Failed");
				//System.out.println("Organization with Industry and type created successfully => testcase passed");
				iop.orgVerification(driver, Orgname);
			}

		
		
}
