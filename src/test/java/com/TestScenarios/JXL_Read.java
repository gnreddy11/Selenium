package com.TestScenarios;

import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;

public class JXL_Read extends StaticVaraibles {
	// WebDriver driver;

	// create reference of CommonFunctions class to re-use of functions
	CommonFunctions cfn = new CommonFunctions();
	Locaters obj = new Locaters();

	@Test // 2
	public void login() throws IOException, Exception {
		// get the data from property file

		String path = "./testData/TD.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);
		driver.get(p.getProperty("URL"));
		// to read data from excel
		File f1 = new File("./testData/testdata.xls");
		FileInputStream fi1 = new FileInputStream(f1);

		Workbook w = Workbook.getWorkbook(fi1);
		Sheet s = w.getSheet(0);

		for (int i = 1; i < s.getRows(); i++) {
			
			driver.findElement(obj.Email_EditBox).clear();
			cfn.sendKeysByanyLocater(obj.Email_EditBox, s.getCell(0, i).getContents());
			driver.findElement(obj.Password_EditBox).clear();
			cfn.sendKeysByanyLocater(obj.Password_EditBox, s.getCell(1, i).getContents());
			cfn.clickByanyLocater(obj.Login_Button);
			Thread.sleep(5000);
			// validate whether given credentials are valid or not?
			if (driver.findElements(By.xpath("//a[text()='Create New Account']")).size() > 0 
					|| driver.findElements(By.xpath("//a[text()='Sign Up']")).size() > 0 ) {
				System.out.println("Given credentials are InValid");
				//Recall your home page
				driver.get(p.getProperty("URL"));
			} else {
				System.out.println("Given credentials are Valid");
			}

		} // for loop end

	}

	@AfterMethod // 3
	public void afterMethod(ITestResult res) throws Exception {
		// cfn.takescreenhot("fbLogin");
		cfn.takescreenshotPassorFail(res);

	}

	@Parameters("browser")
	@BeforeClass // 1
	public void beforeClass(@Optional("chrome") String browser) {
		cfn.browserLaunch(browser);

	}

	@AfterClass // 4
	public void afterClass() {
		//driver.quit();
	}

}
