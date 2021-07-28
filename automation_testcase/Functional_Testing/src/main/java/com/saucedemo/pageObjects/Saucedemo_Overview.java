package com.saucedemo.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Saucedemo_Overview {

	WebDriver driver;
	List<WebElement> productOveriew ;
	
	public Saucedemo_Overview(WebDriver ldriver) {
		driver = ldriver;
	}
	
	private By btn_finish = By.id("finish");
	private By btn_cancel = By.id("cancel");
	private By text_name = By.xpath("//div[@class='inventory_item_name']");
	private By text_price = By.xpath("//div[@class='inventory_item_price']");
	
	private By text_itemTotal = By.xpath("//div[@class='summary_subtotal_label']");
	private By text_tax = By.xpath("//div[@class='summary_tax_label']");
	private By text_fullTotal = By.xpath("//div[@class='summary_total_label']");
	
	public Saucedemo_Overview Click_Finish() {
		driver.findElement(btn_finish).click();
		return this;
	}
	
	public Saucedemo_Overview Click_Cancel() {
		driver.findElement(btn_cancel).click();
		return this;
	}
	
	public Saucedemo_Overview verify_PriceTotal() {
		try {
			
			Float itemTotal = Float.valueOf(driver.findElement(text_itemTotal).getText().substring(13).trim());
			Float tax = Float.valueOf(driver.findElement(text_tax).getText().substring(6).trim());
			Float total = Float.valueOf(driver.findElement(text_fullTotal).getText().substring(8).trim());
			
			
			Float checktotal = itemTotal + tax;
			double check = Math.round(checktotal * 100.0) / 100.0;
			
			double finalValue = Math.round(total * 100.0) / 100.0;
			
			
			//validating whether the total is correct or not
			if(check == finalValue) {
				System.out.println("Total is correct " +finalValue);
			}
			else {
				Assert.assertTrue(false, "Total is not correct "+finalValue);
			}
			
			
		}catch(Exception e) {
			e.getMessage();
		}


		return this;
	}
	
	public Saucedemo_Overview verify_checkOutProductsAreSame(ArrayList<String> name) {
		try {
			
			productOveriew = driver.findElements(text_name);
			if(productOveriew.size() == name.size()) {
				for(int i=0; i< productOveriew.size(); i++) {
					if(productOveriew.get(i).getText().equals(name.get(i))) {
						System.out.println("Both Selected and Products in Cart is matching");
					}
					else {
						System.out.println("Not Matching");
					}
				}
			}
			else {
				System.out.println("Not Matching");
				Assert.assertTrue(false, "Product is not matching in overview");
			}
		}catch(Exception e) {
			e.getMessage();
		}
		return this;
	}
	
	public Saucedemo_Overview verify_checkOutPricesAreSame(HashMap<String, Float> map) {
		try {
			float subtotal = 0;
			float actualprice =0;
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(text_price));
			
			
			//getting the prices on overview screen
			List<WebElement> price = driver.findElements(text_price);
			
			
			//Adding all the product price together in the overview page
			if(price.size() > 0) {
				for(int i=0; i<price.size();i++) {
					 subtotal += Float.valueOf(price.get(i).getText().replaceAll("[$]","").trim() );
				}
			}
			
			
			//Getting the actual price from the homepage and adding it all together
			for(int i=0;i<productOveriew.size();i++) {
				
				if(map.containsKey(productOveriew.get(i).getText())) {
					actualprice += map.get(productOveriew.get(i).getText());	
				}
				else {
					Assert.assertTrue(false, "Key is invalid");
				}
			}
			
			System.out.println("Actual"+actualprice+"\n"+"Subtotal"+subtotal);

			//Validating whether the subtotal price in overview and homepage price total are same
			if(subtotal == actualprice) {
				System.out.println("Prices are matching");
			}
			else {
				Assert.assertTrue(false, "Prices are not matching");
			}
			
			//Removing $ from the Itemtotal excluding of tax
			Float itemTotal = Float.valueOf(driver.findElement(text_itemTotal).getText().substring(13).trim());
			
			//validating whether the total of the all the price and the subtotal in overview page is same
			if(itemTotal == subtotal) {
				System.out.println("Checkout prices are matching");
			}
			else {
				Assert.assertTrue(false, "Checkout prices are not matching");
			}
			
			
			
		}catch(Exception e) {
			e.getMessage();
		}
		return this;
	}
	
	
}
