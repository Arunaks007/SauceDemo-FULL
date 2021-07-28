package com.saucedemo.testcases;

import org.testng.annotations.Test;
import com.saucedemo.pageObjects.Saucedemo_HomePage;
import com.saucedemo.pageObjects.Saucedemo_Login;
 
public class TC_StandardUser_Sort extends BaseClass {
	@Test(description = "Verify whether the Sort is working for Standard user")
	public void StandardUser_Sort() throws Exception {
		
		Saucedemo_Login login = new Saucedemo_Login(driver);
		Saucedemo_HomePage homePage = new Saucedemo_HomePage(driver);
		
		
		//logging into the application
		
		logger.info("Launching the Browser");
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName(readconfig.getStandardUsername())
		.Enter_Password(readconfig.getPassword())
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
		
		//getting the products price
		
		homePage.MapAll_Price();
		
		//sorting
		homePage
		.Select_Filter("az")
		.Select_Filter("za")
		.Select_Filter("lohi")
		.Select_Filter("hilo");
		
		homePage
		.click_Logout();
		
		
	}

}
