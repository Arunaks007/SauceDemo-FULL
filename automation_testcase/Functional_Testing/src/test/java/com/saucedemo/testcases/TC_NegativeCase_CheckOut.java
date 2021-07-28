package com.saucedemo.testcases;

import org.testng.annotations.Test;

import com.saucedemo.pageObjects.Saucedemo_Cart;
import com.saucedemo.pageObjects.Saucedemo_CheckOut;
import com.saucedemo.pageObjects.Saucedemo_CheckOutComplete;
import com.saucedemo.pageObjects.Saucedemo_HomePage;
import com.saucedemo.pageObjects.Saucedemo_Login;
import com.saucedemo.pageObjects.Saucedemo_Overview;

public class TC_NegativeCase_CheckOut extends BaseClass{

	
	@Test(description = "Verify whether the checkout page is accepting invalid/empty values.")
	public void StandardUser_CheckOut_NC() throws Exception {
		
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
		
		logger.info("Validating whether the fields throwing error or not-Postal Only");
		checkOut
		.Enter_FirstName("")
		.Enter_LastName("")
		.Enter_PostalCode("600100")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		driver.navigate().refresh();
		
		logger.info("Validating whether the fields throwing error or not -FirstName Only");
		checkOut
		.Enter_FirstName("Tester")
		.Enter_LastName("")
		.Enter_PostalCode("")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		driver.navigate().refresh();
		
		logger.info("Validating whether the fields throwing error or not-lastname Only");
		checkOut
		.Enter_FirstName("")
		.Enter_LastName("T")
		.Enter_PostalCode("")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		driver.navigate().refresh();
		
		
		logger.info("Validating whether the fields throwing error or not-Fname and Postal Only");
		checkOut
		.Enter_FirstName("Tester")
		.Enter_LastName("")
		.Enter_PostalCode("600100")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		driver.navigate().refresh();
		
		//.verify_CheckOutErrorMsg();
		
		logger.info("Validating whether the fields throwing error or not-Lname and Postal Only");
		checkOut
		.Enter_FirstName("")
		.Enter_LastName("T")
		.Enter_PostalCode("600100")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		logger.info("Validating whether the fields throwing error or not - Empty");
		checkOut
		.Enter_FirstName("")
		.Enter_LastName("")
		.Enter_PostalCode("")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		logger.info("Validating whether the fields throwing error or not - Numerics");
		checkOut
		.Enter_FirstName("1234")
		.Enter_LastName("1234")
		.Enter_PostalCode("test")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		logger.info("Validating whether the fields throwing error or not - Random Symbols");
		checkOut
		.Enter_FirstName("!@##")
		.Enter_LastName("!@##")
		.Enter_PostalCode("!@#")
		.Click_Continue()
		.verify_CheckOutErrorMsg();
		
		
		homePage.click_Logout();
		
	}

}
