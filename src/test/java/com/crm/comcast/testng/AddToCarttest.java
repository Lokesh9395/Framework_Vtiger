package com.crm.comcast.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.crm.Genericlibrary.ExcelUtility;

public class AddToCarttest 
{
	@Test(dataProvider = "prod_products")
	public void organizationData(String Organazation_Name,String Industry_type)
	{
		System.out.println("\t" + Organazation_Name + "\t" + Industry_type + "\t"  );
		System.out.println(" \t");
	}

	@DataProvider
	 public Object[][] prod_products() throws EncryptedDocumentException, IOException
	{
		ExcelUtility elib=new ExcelUtility();
		int rows = elib.getRowCount("orgname");
		System.out.println(rows);
		int cell = elib.getCellCount("orgname", 0);
		System.out.println(cell);
		
		Object[][] objar= null;
				objar=new Object[rows][cell];
		for(int i=0;i<rows;i++)
	
			{
				for(int j=0;j<cell;j++)
			{
					
				
				objar[i][j]=elib.getDataFromExcel("orgname", i, j); 
				
			}	
			}
		
		return objar;
		
	}
}
