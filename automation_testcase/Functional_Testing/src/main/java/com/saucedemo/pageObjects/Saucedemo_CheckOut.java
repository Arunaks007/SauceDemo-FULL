package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;

public class Saucedemo_CheckOut{

	WebDriver driver;
	
	public Saucedemo_CheckOut(WebDriver ldriver) {
		driver = ldriver;
	}
	
	private By text_firstName = By.id("first-name");
	private By text_lastName = By.id("last-name");
	private By text_zipCode = By.id("postal-code");
	
	private By btn_cancel = By.id("cancel");
	private By btn_continue = By.id("continue");
	
	private By text_error = By.xpath("//h3[@data-test = 'error']");

	
	public Saucedemo_CheckOut Enter_FirstName(String fname) {
		driver.findElement(text_firstName).clear();
		driver.findElement(text_firstName).sendKeys(fname);
		return this;
	}

	public Saucedemo_CheckOut Enter_LastName(String lname) {
		driver.findElement(text_lastName).clear();
		driver.findElement(text_lastName).sendKeys(lname);
		return this;
	}
	
	public Saucedemo_CheckOut Enter_PostalCode(String Pcode) {
		driver.findElement(text_zipCode).clear();
		driver.findElement(text_zipCode).sendKeys(Pcode);
		return this;
	}
	
	public Saucedemo_CheckOut Click_Continue() throws Exception {
		driver.findElement(btn_continue).click();
		Thread.sleep(2000);
		return this;
	}
	
	public Saucedemo_CheckOut Click_Cancel() {
		driver.findElement(btn_cancel).click();
		return this;
	}
	
	public Saucedemo_CheckOut verify_ErrorMsg() {
		try {
			if(driver.findElement(text_error).isDisplayed()) {
				System.out.println("Error Message : " + driver.findElement(text_error).getText());
				Assert.assertTrue(false, "driver.findElement(text_error).getText()");
			}else {
				System.out.println("Valid Credentials");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return this;
	}
	
	public Saucedemo_CheckOut verify_CheckOutErrorMsg() {
		try {
			if(driver.findElements(text_error).size() > 0) {
				System.out.println("Error Message : " + driver.findElement(text_error).getText());
			}else {
				Assert.assertTrue(false, "Error Message is not Showing");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return this;
	}
}
