package com.sauce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getLoginURL()
	{
		String url=pro.getProperty("loginURL");
		return url;
	}
	
	public String getStandardUsername()
	{
	String username=pro.getProperty("standardUser");
	return username;
	}
	
	public String lockedOutUser()
	{
	String username=pro.getProperty("lockedOutUser");
	return username;
	}
	
	public String problemUser()
	{
	String username=pro.getProperty("problemUser");
	return username;
	}
	
	public String performanceGlitchUser()
	{
	String username=pro.getProperty("performanceGlitchUser");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getEdgePath()
	{
	String edge=pro.getProperty("edgepath");
	return edge;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}
	
	public String getLoginDataExcel()
	{
	String loginData=pro.getProperty("loginData");
	return loginData;
	}

}
