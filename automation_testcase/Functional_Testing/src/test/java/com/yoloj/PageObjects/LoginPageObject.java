package com.yoloj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

	WebDriver ldriver;
	
	public LoginPageObject(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/button/span[1]")
	WebElement loginButton;
	
	@FindBy(className="MuiTypography-root")
	WebElement signUplnk;
	
	@FindBy(tagName="img")
	WebElement homePagelnk;
	
	@FindBy(xpath="/html/body/div[2]/div[3]/div/ul/li[2]/button/span[1]")
	WebElement loginBtnLink;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/header/div/div[2]/ul/li[3]/button/span[1]")
	WebElement registerBtnLink;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/header/div/div[2]/ul/li[1]/div/div/button/span[1]")
	WebElement providerButton;
	
	@FindBy(xpath="//*[@id=\"menu-list\"]/ul/li[2]/a")
	WebElement providerLoginbtn;
	
	@FindBy(xpath="//*[@id=\"menu-list\"]/ul/li[1]/a")
	WebElement providerRegisterbtn;
	
	@FindBy(id="email-helper-text")
	WebElement emailErrorMsg;
	
	public String emailErrorAll = "email-helper-text";
	
	@FindBy(id="password-helper-text")
	WebElement passwordErrorMsg;
	
	public String passwordErrorAll = "password-helper-text";
	
	@FindBy(xpath="//*[@id='root']/div/div/div/div[2]/div/div[1]")
	WebElement errorMsgForLogin;
	
	public String errorMsgForlogin = "//*[@id='root']/div/div/div/div[2]/div/div[1]"; 
	
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickButton() {
		loginButton.click();
	}

	public void clickSignUp() {
		signUplnk.click();
	}
	
	public void clickHomePage() {
		homePagelnk.click();
	}

	public String getEmailErrorMsg() {
		return emailErrorMsg.getText();
	}
	
	public String getPasswordErrorMsg() {
		return passwordErrorMsg.getText();
	}
	
	public void clickProviderButton() {
		providerButton.click();
	}
	
	public void clickProviderLoginButton() {
		providerLoginbtn.click();
	}
	
	public void clickProviderRegisterButton() {
		providerRegisterbtn.click();
	}
	
	public void clickLoginLink() {
		loginBtnLink.click();
	}
	
	public void clickRegisterLink() {
		registerBtnLink.click();
	}
	
	public String getErrorMsg() {
		return errorMsgForLogin.getText();
	}
	
	
}
	
