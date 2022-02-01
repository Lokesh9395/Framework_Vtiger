package com.crm.comcast.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Com.crm.Genericlibrary.BaseAnnotationClass;
import Com.crm.Objectrepositorylibrary.ContactInfoPage;
import Com.crm.Objectrepositorylibrary.ContactsPage;
import Com.crm.Objectrepositorylibrary.CreateContactsPage;
import Com.crm.Objectrepositorylibrary.CreateOrganizationsPage;
import Com.crm.Objectrepositorylibrary.HomePage;
import Com.crm.Objectrepositorylibrary.OrganizationInfoPage;
import Com.crm.Objectrepositorylibrary.OrganizationsPage;

@Listeners(Com.crm.Genericlibrary.ListImp.class)
public class CreateContactTestNgTest extends BaseAnnotationClass
{

	@Test(groups = "smokeTest")
	public void createContact() throws EncryptedDocumentException, IOException, InterruptedException
	{
		int random = jlib.getRandomNumber();
		
		String ContName = elib.getDataFromExcel("Sheet1", 5, 1)+random;
		
		HomePage hp=new HomePage(driver);
		hp.getContactlink().click();	
		
		ContactsPage cp=new ContactsPage(driver);
		cp.contactcreate(driver);
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.newcontact(1, ContName);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.contactVerification(driver, ContName);
	}
	
	
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		int random = jlib.getRandomNumber();
		
		String Orgname = elib.getDataFromExcel("Sheet1",5,0)+random;
		String ContName = elib.getDataFromExcel("Sheet1", 5, 1)+random;
		
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
		/**if(header.contains(Orgname))
		{
			System.out.println("Organization created - Test case passed");
			
		}
		else
		{
			System.out.println("organization not created - Test  case failed");
		}
		*/
		iop.orgVerification(driver, Orgname);
		hp.getContactlink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.contactcreate(driver);
		
		CreateContactsPage ccp=new CreateContactsPage(driver);
		ccp.newcontactwithorg(1, ContName, Orgname);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		cip.contactVerification(driver, ContName);
	}
}
