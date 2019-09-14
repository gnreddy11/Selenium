package com.TestScenarios;

import org.testng.annotations.Test;

import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class FB_Login extends StaticVaraibles {
	//WebDriver driver;

	//create reference of CommonFunctions class to re-use of functions
	CommonFunctions cfn = new CommonFunctions ();
	
	@Test // 2
	public void login() {
//		driver.findElement(By.name("email")).sendKeys("test123@gmail.com");
//		driver.findElement(By.id("pass")).sendKeys("test123");
//		driver.findElement(By.id("loginbutton")).click();
		
	//cfn.sendkeysByNAME("email", "test123@gmail.com");
	//cfn.sendkeysByID("pass", "test123");
	//cfn.clickByID("loginbutton");//*
		cfn.sendkeysByID("identifierId", "gnageshreddy@gmail.com");
		cfn.sendkeysByID("password","kuyiyui");
		
	}

	@Test
	public void test() {
		System.out.println("dssdg");
	}
	@AfterMethod // 3
	public void afterMethod(ITestResult res) throws Exception {
		//cfn.takescreenhot("fbLogin");
		cfn.takescreenshotPassorFail(res);

	}

	@BeforeClass // 1
	public void beforeClass() {
		//browser launch
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//driver.get("https://www.fb.com");
		driver.get("https://www.gmail.com");
		driver.manage().window().maximize();
		
	}

	@AfterClass // 4
	public void afterClass() {
		driver.quit();
	}

}
