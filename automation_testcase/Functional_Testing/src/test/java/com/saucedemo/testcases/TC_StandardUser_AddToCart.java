package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageObjects.Saucedemo_HomePage;
import com.saucedemo.pageObjects.Saucedemo_Login;

public class TC_StandardUser_AddToCart extends BaseClass {

	@Test(description = "Verify whether the Standard user is able add products into cart")
	public void Login_StandardUser() {
		
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
		
		logger.info("Selecting a single product");
		//clicking single product and checking the cart.
		homePage
		.click_AddToCart_BackPack()
		.click_AddToCart_BikeLight()
		.click_Remove_BackPack()
		.verify_cartCount();
		
		homePage.click_Cart();
		
		
		
	}
}
