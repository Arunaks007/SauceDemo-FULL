package com.yoloj.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserRegister_PageObject {
	
WebDriver ldriver;
	
	public UserRegister_PageObject(WebDriver rdriver){
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/header/div/div[2]/ul/li[3]/button/span[1]" )
	WebElement RegLink;
	
	@FindBy(id = "name")
	WebElement txtName;
	
	@FindBy(id = "email")
	WebElement txtEmail;
	
	@FindBy(id = "password")
	WebElement txtPass;
	
	@FindBy(id = "confirm_password")
	WebElement txtConfirmPass;
	
	@FindBy(id = "demo-simple-select")
	WebElement CodeLink;
	
	@FindBy(id = "phone_number")
	WebElement txtPhone;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div/div/div/div[2]/form/button/span[1]")
	WebElement Createbtn;
	
	@FindBy(linkText = "Link")
	WebElement Loginbtn;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/header/div/img")
	WebElement HomePageLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div/div[1]")    
	WebElement Errormsg;
	
	public void ClickRegisterbtn(){
		RegLink.click();
	}
	
	public void setName(String name){
		txtName.sendKeys(name);
	}
	
	public void setEmail(String mail){
		txtEmail.sendKeys(mail);
	}
	
	public void setPassword(String password){
		txtPass.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmpass){
		txtConfirmPass.sendKeys(confirmpass);
	}
	
	public void setPhone(String phone){
		txtPhone.sendKeys(phone);
	}
	
	public void createAccount(){
		Createbtn.click();
	}
	
	public void gotoHome(){
		HomePageLink.click();
	}
	
	public void gotoLogin(){
		Loginbtn.click();
	}
	
	public String getErrormsg(){
		return Errormsg.getText();
		
	}

}
