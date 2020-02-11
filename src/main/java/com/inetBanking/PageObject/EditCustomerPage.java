package com.inetBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class EditCustomerPage extends AddCustomerPage{
	
   public EditCustomerPage(WebDriver rdriver) {
		super(rdriver);
   }

WebDriver Idriver;
   		
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	@CacheLookup
	WebElement lnkEditCustomer;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement customerId;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement accSubmit;
	
	public void lnkEditCustomer() {
		lnkEditCustomer.click();			
	}

	public void customerId(String cid) {
		customerId.sendKeys(cid);		
	}
	
	public void accSubmit(){
		accSubmit.click();
	}

}
