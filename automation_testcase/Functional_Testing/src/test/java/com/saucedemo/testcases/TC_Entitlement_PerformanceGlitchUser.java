package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageObjects.Saucedemo_Login;

public class TC_Entitlement_PerformanceGlitchUser extends BaseClass{
	
	@Test(description = "Verify whether the Performance Glitch user is able to login successfuly")
	public void Login_StandardUser() {
		
		Saucedemo_Login login = new Saucedemo_Login(driver);
		
		//logging into the application
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName(readconfig.performanceGlitchUser())
		.Enter_Password(readconfig.getPassword())
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
	}

}
