package com.crm.comcast.testng;

import org.testng.annotations.Test;

public class sample1_testngtest 
{
   @Test
   public void createorg()
   {
	   System.out.println("organization created");
	   int arr[]= {1,2,3};
	   System.out.println(arr[5]);
   }
   
   @Test(dependsOnMethods = "createorg")
   public void modifyorg()
   {
	   System.out.println("Organization is modified");
   }
   
   @Test(invocationCount = 3 )
   public void deleteorg()
   {
	   System.out.println("Organization is deleted");
   }
   
	
}
