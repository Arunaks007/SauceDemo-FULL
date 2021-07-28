package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageObjects.Saucedemo_HomePage;
import com.saucedemo.pageObjects.Saucedemo_Login;

public class TC_Entitlement_ProblemUser extends BaseClass {
	
	@Test(description = "Verify whether the Problem user is able to login successfuly",groups="ProblemUser")
	public void ProblemUser_Login() {
		
		Saucedemo_Login login = new Saucedemo_Login(driver);
		Saucedemo_HomePage homePage = new Saucedemo_HomePage(driver);

		
		//logging into the application
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName(readconfig.problemUser())
		.Enter_Password(readconfig.getPassword())
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
		
		homePage.click_Logout();
	}
}
