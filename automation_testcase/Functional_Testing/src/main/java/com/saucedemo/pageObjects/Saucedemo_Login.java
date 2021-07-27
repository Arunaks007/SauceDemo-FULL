package com.saucedemo.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Saucedemo_Login {
		
	WebDriver driver;
	
	private By text_userName = By.id("user-name");
	private By text_password = By.id("password");
	private By btn_login = By.id("login-button");
	
	private By text_errorLockedOut = By.xpath("//h3[@data-test = 'error']");
	
	public Saucedemo_Login(WebDriver ldriver) {
		driver = ldriver;
	}
	
	public Saucedemo_Login LaunchUrl(String url) {
		driver.get(url);
		return this;
	}
	
	public Saucedemo_Login Enter_UserName(String userName) {
		driver.findElement(text_userName).sendKeys(userName);
		return this;
	}
	
	public Saucedemo_Login Enter_Password(String password) {
		driver.findElement(text_password).sendKeys(password);
		return this;
	}
	
	public Saucedemo_Login Click_Login() {
		driver.findElement(btn_login).click();
		return this;
	}
	
	public Saucedemo_Login verify_isUserLoggedIn() {
		try {
			if(driver.findElements(btn_login).size() > 0 ) {
				System.out.println("User is not logged in");
				Assert.assertTrue(false, "User is not logged in");
			}else {
				System.out.println("User logged in successfully");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return this;
	}
	
	public Saucedemo_Login verify_ErrorMsg() {
		try {
			if(driver.findElements(text_errorLockedOut).size() > 0 ) {
				System.out.println("Invalid Credentials");
				System.out.println("Error Message : " + driver.findElement(text_errorLockedOut).getText());
				Assert.assertTrue(false,driver.findElement(text_errorLockedOut).getText());
			}else {
				System.out.println("Valid Credentials");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		return this;
	}
	
}
