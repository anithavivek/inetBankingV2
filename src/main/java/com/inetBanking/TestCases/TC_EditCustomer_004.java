package com.inetBanking.TestCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.AddCustomerPage;
import com.inetBanking.PageObject.EditCustomerPage;
import com.inetBanking.PageObject.LoginPage;

public class TC_EditCustomer_004 extends BaseClass {

  @Test
  public void editCustomer() throws InterruptedException{
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("User name is provided");
	lp.setPassword(password);
	logger.info("Passsword is provided");
	lp.clickSubmit();

	driver.navigate().refresh();
	
	EditCustomerPage editcust=new EditCustomerPage(driver);
	
	AddCustomerPage addcust=new AddCustomerPage(driver);
	
	editcust.lnkEditCustomer();
	
	logger.info("Opened the Edit Customer Form...");
	
	editcust.customerId("10449");
	
	editcust.accSubmit();
	
	logger.info("Submitted the customer ID: 10449");
	
	if(isAlertPresent()==true)
	{
		String alert=driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();//close alert
		driver.switchTo().defaultContent();
		logger.error(alert);
		logger.warn("Entered invalid ID");
		Assert.assertTrue(false);
		}
	
	else
	{
		logger.info("Valid ID");
		addcust.custaddress("Canada");
		addcust.custcity("Brampton");
		addcust.custstate("ON");
		addcust.custpinno("123456");
		String phone=randomeNum(10);
		addcust.custtelephoneno(phone);
		String email=randomestring(8)+"@gmail.com";
		addcust.custemailid(email);
		addcust.custsubmit();
		logger.info("Customer details updated Successfully!!!");
		Assert.assertTrue(true);
		}
	}
}
