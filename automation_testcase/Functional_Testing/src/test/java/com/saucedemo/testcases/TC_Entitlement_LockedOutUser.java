package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageObjects.Saucedemo_Login;

public class TC_Entitlement_LockedOutUser extends BaseClass {
	
	@Test(description = "Verify whether the Locked Out user is able not to login",groups="LockedOutUser")
	public void Login_LockedOutUser() {
		
		Saucedemo_Login login = new Saucedemo_Login(driver);
		
		//logging into the application
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName(readconfig.lockedOutUser())
		.Enter_Password(readconfig.getPassword())
		.Click_Login();
		
		login
		.verify_UserIsNotLoggedIn();
	}
}
