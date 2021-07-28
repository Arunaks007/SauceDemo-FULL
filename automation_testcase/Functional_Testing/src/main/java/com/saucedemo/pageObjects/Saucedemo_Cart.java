package com.saucedemo.pageObjects;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Saucedemo_Cart {

	WebDriver driver;
	
	public Saucedemo_Cart(WebDriver ldriver) {
		driver = ldriver;
	}
	
	private By count_cart = By.xpath("//div[@class='cart_item']");
	private By product_name = By.xpath("//div[@class='inventory_item_name']");
	private By btn_checkOut = By.id("checkout");
	private By btn_continueShopping = By.id("continue-shopping");
		
	public Saucedemo_Cart click_checkOut() {
		if(Get_ProductsCount() == 0) {
			Assert.assertTrue(false, "Cart is Empty");
		}
		else {
			driver.findElement(btn_checkOut).click();
		}
		return this;
	}
	
	public Saucedemo_Cart click_continueShopping() {
		driver.findElement(btn_continueShopping).click();
		return this;
	}
	
	public int Get_ProductsCount() {
		int count = driver.findElements(count_cart).size();
		return count;
	}
	
	public Saucedemo_Cart verify_SelectedProductsAreShowing(ArrayList<String> Products) {
		try {
			System.out.println(Products.size());
			if(Get_ProductsCount() == Products.size()) {
				List<WebElement> cartProductNames = driver.findElements(product_name);
				
				for(int i=0; i< cartProductNames.size(); i++) {
					if(cartProductNames.get(i).getText().equals(Products.get(i))) {
						System.out.println("Both Selected and Products in Cart is matching");
					}
					else {
						System.out.println("Not Matching");
						Assert.assertTrue(false, "Not Matching");
					}
				}
			}
			else {
				System.out.println("Not Matching");
				Assert.assertTrue(false, "Not Matching");
			}
		}catch(Exception e) {
			e.getMessage();
		}
		
		return this;
	}

	
	
}
