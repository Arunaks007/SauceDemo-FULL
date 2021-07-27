package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageObjects.Saucedemo_Cart;
import com.saucedemo.pageObjects.Saucedemo_CheckOut;
import com.saucedemo.pageObjects.Saucedemo_CheckOutComplete;
import com.saucedemo.pageObjects.Saucedemo_HomePage;
import com.saucedemo.pageObjects.Saucedemo_Login;
import com.saucedemo.pageObjects.Saucedemo_Overview;

public class TC_PerformanceGlitchUser_RemovingAndAddingInCart extends BaseClass {

	@Test(description = "Verify whether the PerformanceGlitch user is able add multiple products into cart and remove")
	public void PerformanceGlitchUser_Removing() throws Exception {
		
		Saucedemo_Login login = new Saucedemo_Login(driver);
		Saucedemo_HomePage homePage = new Saucedemo_HomePage(driver);
		Saucedemo_Cart cart = new Saucedemo_Cart(driver);
		Saucedemo_CheckOut checkOut =  new Saucedemo_CheckOut(driver);
		Saucedemo_Overview overiew = new Saucedemo_Overview(driver);
		Saucedemo_CheckOutComplete complete = new Saucedemo_CheckOutComplete(driver);
		
		//logging into the application
		
		logger.info("Launching the Browser");
		
		login
		.LaunchUrl(readconfig.getLoginURL())
		.Enter_UserName(readconfig.performanceGlitchUser())
		.Enter_Password(readconfig.getPassword())
		.Click_Login()
		.verify_ErrorMsg();
		
		login
		.verify_isUserLoggedIn();
		
		//getting the products price
		
		homePage.MapAll_Price();
		
		logger.info("Selecting a Multiple product and removing");
		//clicking single product and checking the cart.
		homePage
		.click_AddToCart_BackPack()
		.click_AddToCart_BikeLight()
		.click_AddToCart_FleeJacket()
		.click_Remove_BikeLight()
		.verify_cartCount();
				
		logger.info("Clicking Cart");
		homePage
		.click_Cart();
		
		logger.info("Verify whether the selected products are displaying");		
		cart
		.verify_SelectedProductsAreShowing(homePage.checkedProducts);
		
		logger.info("clicking checkout");
		cart
		.click_checkOut();
		
		logger.info("Entering firstname, lastname, zipcode to proceed");
		checkOut
		.Enter_FirstName("Tester")
		.Enter_LastName("full")
		.Enter_PostalCode("600100")
		.Click_Continue();
		
		logger.info("Verifying the Products are the same which user checked out");
		overiew
		.verify_checkOutProductsAreSame(homePage.checkedProducts)
		.verify_checkOutPricesAreSame(homePage.map)
		.verify_PriceTotal()
		.Click_Finish();
		
		complete
		.Verify_Success()
		.Click_Home();
		
		homePage.click_Logout();
			
	}
}
