package com.crm.comcast.testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.crm.Genericlibrary.ExcelUtility;

public class AddToCarttest 
{
	@Test(dataProvider = "prod_products")
	public void products(String ProductName,String qty,String Cost)
	{
		System.out.println("\t" + ProductName + "\t" + qty + "\t"  + Cost);
		System.out.println(" ");
	}

	@DataProvider
	 public Object[][] prod_products() throws EncryptedDocumentException, IOException
	{
		ExcelUtility elib=new ExcelUtility();
		int rows = elib.getRowCount("products");
		int cells = elib.getCellCount("products", 0);
		
		Object[][] objar=new Object[rows][cells];
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cells;j++)
			{
				
				objar[i][j]=elib.getDataFromExcel("products", i, j); 
			}	
		}
		return objar;
		
	}
}
