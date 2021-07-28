package com.saucedemo.pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Saucedemo_HomePage {

	WebDriver driver;
	
	public HashMap<String, Float> map = new HashMap<String, Float>();
	
	public ArrayList<String> checkedProducts = new ArrayList<String>();
	
	
	
	private By btn_logout = By.id("logout_sidebar_link");
	private By btn_sidebar = By.id("react-burger-menu-btn");
	
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
	
	//name of all products
	private By product_name = By.xpath("//div[@class='inventory_item_name']");
	
	//cart button
	private By btn_cart = By.xpath("//a[@class='shopping_cart_link']");
	
	//cart count
	private By btn_cart_count = By.xpath("//a[@class='shopping_cart_link']/span");
	
	public Saucedemo_HomePage(WebDriver ldriver) {
		driver = ldriver;
	}
	
	List<WebElement> prices= new ArrayList<WebElement>();      
	List<WebElement> names =  new ArrayList<WebElement>();	
	
	//Methods
	
	public int temp=0;
	
	public Saucedemo_HomePage click_Logout() {
		
		Actions action = new Actions(driver);
		Action ac = action.moveToElement(driver.findElement(btn_sidebar)).click().build();
		
		ac.perform();
		
		driver.findElement(btn_logout).click();
		return this;
	}
	
	public Saucedemo_HomePage click_Cart() {
		driver.findElement(btn_cart).click();
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_BackPack() {
		driver.findElement(btn_addToCart_backPack).click();
		temp+=1;
		checkedProducts.add(names.get(0).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_BikeLight() {
		driver.findElement(btn_addToCart_bikeLight).click();
		temp+=1;
		checkedProducts.add(names.get(1).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_TShirt() {
		driver.findElement(btn_addToCart_tShirt).click();
		temp+=1;
		checkedProducts.add(names.get(2).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_FleeJacket() {
		driver.findElement(btn_addToCart_fleeJacket).click();
		temp+=1;
		checkedProducts.add(names.get(3).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_Onesies() {
		driver.findElement(btn_addToCart_onesies).click();
		temp+=1;
		checkedProducts.add(names.get(4).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_AddToCart_TShirtRed() {
		driver.findElement(btn_addToCart_tShirtRed).click();
		temp+=1;
		checkedProducts.add(names.get(5).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_BackPack() {
		driver.findElement(btn_remove_backPack).click();
		temp-=1;
		checkedProducts.remove(names.get(0).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_BikeLight() {
		driver.findElement(btn_remove_bikeLight).click();
		temp-=1;
		checkedProducts.remove(names.get(1).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_TShirt() {
		driver.findElement(btn_remove_tShirt).click();
		temp-=1;
		checkedProducts.remove(names.get(2).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_FleeJacket() {
		driver.findElement(btn_remove_fleeJacket).click();
		temp-=1;
		checkedProducts.remove(names.get(3).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_Onesies() {
		driver.findElement(btn_remove_onesies).click();
		temp-=1;
		checkedProducts.remove(names.get(4).getText());
		return this;
	}
	
	public Saucedemo_HomePage click_Remove_TShirtRed() {
		driver.findElement(btn_remove_tShirtRed).click();
		temp-=1;
		checkedProducts.remove(names.get(5).getText());
		return this;
	}
	
	
	public Saucedemo_HomePage MapAll_Price() {
		try {
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			wait.until(ExpectedConditions.presenceOfElementLocated(price));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			names = driver.findElements(product_name);
			prices = driver.findElements(price);
			
			ArrayList<Float> updatedPrice = new ArrayList<Float>();
			
			for(int i = 0; i<prices.size();i++) {
				updatedPrice.add(Float.valueOf(prices.get(i).getText().replaceAll("[$]","") ));
			}
			
			for(int i =0; i<names.size(); i++){
				map.put(names.get(i).getText(), updatedPrice.get(i));
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
			System.out.println("Cart is empty");
		}
		return count;
	}
	
	public Saucedemo_HomePage verify_cartCount() {
		
		if(Get_CartCount() == temp) {
			System.out.println("count is matching");
		}
		else {
			System.out.println("count is not matching");
			Assert.assertTrue(false, "Cart count is not matching");
		}
		return this;
	}
	
}
