package com.inetBanking.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;
import com.inetBanking.Utilites.XLUtils;

public class TC_loginTest_002 extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			logger.info("Entered wrong username "+user+" and password "+pwd);
			logger.warn("Login failed");
			Assert.assertTrue(false);
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			logger.info("Logout passed");
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();			
		}
}
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/inetBanking/TestData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Login");
		int colcount=XLUtils.getCellCount(path,"Login",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Login", i,j);//1 0
			}
				
		}
	return logindata;
	}
	
}