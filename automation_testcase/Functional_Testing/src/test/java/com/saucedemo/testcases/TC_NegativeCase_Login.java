package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageObjects.Saucedemo_Login;

public class TC_NegativeCase_Login extends BaseClass {

	@Test(description = "Verify whether the Fields accepting invalid values")
	public void Login_StandardUser() {
		
		Saucedemo_Login login = new Saucedemo_Login(driver);
		
		//logging into the application
		
		logger.info("Checking the Fields with Random symbols");
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName("!@#$")
		.Enter_Password("!@#")
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
		
		logger.info("Checking the Fields with Random values");
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName("test1")
		.Enter_Password("test1")
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
		
		logger.info("Entering username field only");
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName("User")
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
		
		logger.info("Entering password field only");
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_Password("password")
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
		
		logger.info("Leaving both fields empty");

		login
		.LaunchUrl(readconfig.getLoginURL())
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();


		
	}
	
}
