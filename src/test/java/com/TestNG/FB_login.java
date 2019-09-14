package com.TestNG;

import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class FB_login extends StaticVaraibles {
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();
	
	@Test
	public void f() throws Exception {
		//To identify TD.properties file in your local system with the help of path URL
		File f = new File(".\\testData\\TD.properties");
		FileInputStream fi = new FileInputStream(f);
		
		Properties prop = new Properties();
		prop.load(fi);
		
			
		driver.get(prop.getProperty("URL"));
		cfn.sendKeysByanyLocater(obj.Email_EditBox, prop.getProperty("Email"));
		cfn.sendKeysByanyLocater(obj.Password_EditBox, prop.getProperty("Password"));
		//cfn.clickByID(obj.Login_Button);
		cfn.clickByJSE(obj.Login_Button);
		
		Thread.sleep(5000);
	}
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("Chrome") String browser) {
		//cfn.chromeBrowserLaunch();
		//cfn.ieBrowserLaunch();
	//	cfn.firefoxBrowserLaunch();
		cfn.browserLaunch(browser);
		
	}
	@AfterMethod
	public void screenshot() throws Exception {

		Date d = new Date();
		System.out.println(d);//Thu Sep 12 22:33:39 EDT 2019
		//yyyy_MM_dd_HH_mm_ss
		DateFormat df = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss a");
		String timestamp = df.format(d);
		System.out.println(timestamp);
		String path = "./screenshots/";
		
		File f  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File(path+"test_"+timestamp+".PNG"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
