package com.saucedemo.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Saucedemo_HomePage {

	WebDriver driver;
	
	HashMap<String, Float> map = new HashMap<String, Float>();
	
	//Add to Cart of products
	private By btn_addToCart_backPack = By.id("add-to-cart-sauce-labs-backpack");
	private By btn_addToCart_bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
	private By btn_addToCart_tShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
	private By btn_addToCart_fleeJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
	private By btn_addToCart_onesies = By.id("add-to-cart-sauce-labs-onesie");
	private By btn_addToCart_tShirtRed = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
	
	//remove products from cart
	private By btn_remove_backPack = By.id("remove-sauce-labs-backpack");
	private By btn_remove_bikeLight = By.id("remove-sauce-labs-bike-light");
	private By btn_remove_tShirt = By.id("remove-sauce-labs-bolt-t-shirt");
	private By btn_remove_fleeJacket = By.id("remove-sauce-labs-fleece-jacket");
	private By btn_remove_onesies = By.id("remove-sauce-labs-onesie");
	private By btn_remove_tShirtRed = By.id("remove-test.allthethings()-t-shirt-(red)");
	
	//price of all products
	private By price = By.xpath("//div[@class='inventory_item_price']");
	
	//cart button
	private By btn_cart = By.xpath("//a[@class='shopping_cart_link']");
	
	//cart count
	private By btn_cart_count = By.xpath("//a[@class='shopping_cart_link']/span");
	
	public Saucedemo_HomePage(WebDriver ldriver) {
		driver = ldriver;
	}
	
	//Methods
	
	public int temp=0;
	
	public Saucedemo_HomePage click_Cart() {
		driver.findElement(btn_cart).click();
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_BackPack() {
		driver.findElement(btn_addToCart_backPack).click();
		temp+=1;
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_BikeLight() {
		driver.findElement(btn_addToCart_bikeLight).click();
		temp+=1;
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_TShirt() {
		driver.findElement(btn_addToCart_tShirt).click();
		temp+=1;
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_FleeJacket() {
		driver.findElement(btn_addToCart_fleeJacket).click();
		temp+=1;
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_Onesies() {
		driver.findElement(btn_addToCart_onesies).click();
		temp+=1;
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_TShirtRed() {
		driver.findElement(btn_addToCart_tShirtRed).click();
		temp+=1;
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_BackPack() {
		driver.findElement(btn_remove_backPack).click();
		temp-=1;
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_BikeLight() {
		driver.findElement(btn_remove_bikeLight).click();
		temp-=1;
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_TShirt() {
		driver.findElement(btn_remove_tShirt).click();
		temp-=1;
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_FleeJacket() {
		driver.findElement(btn_remove_fleeJacket).click();
		temp-=1;
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_Onesies() {
		driver.findElement(btn_remove_onesies).click();
		temp-=1;
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_TShirtRed() {
		driver.findElement(btn_remove_tShirtRed).click();
		temp-=1;
		return this;
	}
	
	
	
	
	
	public Saucedemo_HomePage MapAll_Price() {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(price));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			List<WebElement> prices= driver.findElements(price);
			
			ArrayList<Float> updatedPrice = new ArrayList<Float>();
			
			for(int i = 0; i<prices.size();i++) {
				updatedPrice.add(Float.valueOf(prices.get(i).getText().replaceAll("[$]","") ));
			}
			
			if(prices.size() > 0) {
				map.put("BackPack", updatedPrice.get(0));
				map.put("BikeLight", updatedPrice.get(1));
				map.put("TShirt", updatedPrice.get(2));
				map.put("FleeceJacket", updatedPrice.get(3));
				map.put("Onesie", updatedPrice.get(4));
				map.put("TShirtRed", updatedPrice.get(5));
			}
			else {
				System.out.println("Empty List");
			}
			
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return this;
	}
	
	@SuppressWarnings("null")
	public Float Get_Price(String product) {
		Float value = null;
		try {
			if(map.containsKey(product)) {
				value = map.get(product);	
			}
			else {
				throw new Exception("Key is invalid");
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		
		return value;
	}
	
	public int Get_CartCount() {
		int count = 0;
		
		try {
		count = Integer.valueOf(driver.findElement(btn_cart_count).getText());
		}
		catch(Exception e){
			System.out.println("Cart was empty");
		}
		return count;
	}
	
	public Saucedemo_HomePage verify_cartCount() {
		
		if(Get_CartCount() == temp) {
			System.out.println("count is matching");
		}
		else {
			System.out.println("count is not matching");
		}
		return this;
	}
}
