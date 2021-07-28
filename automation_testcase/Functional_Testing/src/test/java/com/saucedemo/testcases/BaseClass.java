package com.saucedemo.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sauce.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
			
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@BeforeClass
	@Parameters("browser")
	public void setup(@Optional("default")String br)
	{			
		logger = Logger.getLogger("SauceDemo");
		PropertyConfigurator.configure("Log4j.properties");
		
//		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//		driver=new ChromeDriver();
		
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver = new InternetExplorerDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver",readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		//driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/TestDatas/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public FileInputStream setFileInput(String path) {
		FileInputStream fis=null;
		try {
			File file = new File(path);
			fis=new FileInputStream(file);
			return fis;
		}
		catch(Exception e) {
			System.out.println("Error Message"+e.getMessage());
		}
		return fis;
	}
	
	public FileOutputStream setFileOutput(String path) {
		FileOutputStream fos=null;
		try {
			File file = new File(path);
			fos=new FileOutputStream(file);
			return fos;
		}
		catch(Exception e) {
			System.out.println("Error Message"+e.getMessage());
		}
		return fos;
	}

}
