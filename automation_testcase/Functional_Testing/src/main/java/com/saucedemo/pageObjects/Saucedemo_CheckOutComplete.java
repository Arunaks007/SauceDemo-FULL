package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Saucedemo_CheckOutComplete {
	
	WebDriver driver;

	private By text_success = By.xpath("//h2[@class='complete-header']");
	private By btn_home = By.id("back-to-products");
	
	public Saucedemo_CheckOutComplete(WebDriver ldriver) {
		driver = ldriver;
	}
	
	public Saucedemo_CheckOutComplete Verify_Success() throws Exception {
		if(driver.findElement(text_success).isDisplayed()) {
			System.out.println(driver.findElement(text_success).getText());
		}
		else {
			throw new Exception("Order not placed");
		}
		return this;
	}
	
	public Saucedemo_CheckOutComplete Click_Home() {
		driver.findElement(btn_home).click();
		return this;
	}
}
