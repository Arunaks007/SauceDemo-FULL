package com.yoloj.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.yoloj.PageObjects.LoginPageObject;

public class TC_Login_Retest extends BaseClass {
  
	@Test
	public void loginTestCase() {
		try {
			
		//loading the login Webpage
		driver.get(readconfig.getLoginURL());
		logger.info("URL is Opened");
		
		//get instance of LoginPageObjectModel
		LoginPageObject loginPage = new LoginPageObject(driver);
		
		//initialization of Excel file
		FileInputStream fis=setFileInput(readconfig.getLoginDataExcel());
		
		//Workbook
		XSSFWorkbook book=new XSSFWorkbook(fis);
		logger.info("opening of the excel");
		
		//sheet
		XSSFSheet sheet=book.getSheetAt(0);
		
		//getting the values from cells
		int total=sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		//looping through the cells to get the data
		logger.info("Using loop to get the data from cells");
		for(int i=1 ; i<=total ;i++) {
			//variable initialization
			String email=""; String password="";
			String email_errorMsg = ""; String password_errorMsg=""; String finalerror = "";
			
			//getting and asssigning the data
			email = sheet.getRow(i).getCell(0).getStringCellValue();
			password = sheet.getRow(i).getCell(1).getStringCellValue();
			
			//passing the data 
			logger.info("User added the value for email");
			loginPage.setEmail(email);
			logger.info("User added the value for password");
			loginPage.setPassword(password);
			logger.info("User Clicked the Login Button");
			loginPage.clickButton();
			
			Thread.sleep(1000);
			if(driver.findElements(By.xpath(loginPage.errorMsgForlogin)).size() != 0) {
				finalerror = loginPage.getErrorMsg();
			}
			
			//Checking whether the element is Displayed or not
			if(driver.findElements(By.id(loginPage.emailErrorAll)).size() != 0) {
				email_errorMsg = loginPage.getEmailErrorMsg();}
			
			else if (driver.findElements(By.id(loginPage.passwordErrorAll)).size() != 0) {
				password_errorMsg = loginPage.getPasswordErrorMsg();}
			
			
			logger.info("checking the format");
			//checking whether the variable is empty or not
			if(email_errorMsg.length() !=0 || password_errorMsg.length() != 0){
					sheet.getRow(i).getCell(3).setCellValue(email_errorMsg+" "+password_errorMsg);
			}			
			else if(finalerror.length() != 0 ){ 
				sheet.getRow(i).getCell(3).setCellValue(finalerror); 
			}
			else{
				sheet.getRow(i).getCell(3).setCellValue("Success");
			}
			
			//loading the webpage for reseting the text field
			driver.get(readconfig.getLoginURL());
			logger.info("Reloading the webpage");
		
		}
		
		//saving the updated file
		FileOutputStream fos=setFileOutput(readconfig.getLoginDataExcel());
		book.write(fos);
		logger.info("Saving the overwrited file");
		//closing the Excel file
		fos.close();
		fis.close();
		logger.info("Closing the Workbook/Excel");
	  }
	
	catch (Exception e) {
		System.out.println("Error Message"+e.getMessage());
	}	
}}
