package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

public class CommonFunctions extends StaticVaraibles {

	// String browser = "nagesh";
	public void browserLaunch(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				chromeBrowserLaunch();
			} else if (browser.equalsIgnoreCase("firefox")) {
				firefoxBrowserLaunch();
			} else if (browser.equalsIgnoreCase("ie")) {
				ieBrowserLaunch();
			} else {
				System.out.println("Plz enter valid browser name   ************");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Chrome browser launch
	public void chromeBrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	// IE browser launch
	public void ieBrowserLaunch() {
		System.setProperty("webdriver.ie.driver", ".\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();

	}

	// Firefox browser launch
	public void firefoxBrowserLaunch() {
		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	// Java script click
	public void clickByJSE(final By locater) {
		WebElement ele = driver.findElement(locater);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", ele);
	}

	// WebDriver driver;
	public void sendKeysByanyLocater(final By locater, String inputData) {
		try {
			WebElement ele = driver.findElement(locater);
			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {
					ele.sendKeys(inputData);

				} else {
					System.out.println("Element is not Enabled state, please check*************");
				}

			} else {
				System.out.println("Element is not Displayed, please check*************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/******* SendKeys ****************************/
	public void sendkeysByID(String locater, String inputData) {
		try {
			WebElement ele = driver.findElement(By.id(locater));
			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {
					ele.sendKeys(inputData);

				} else {
					System.out.println("Element is not Enabled state, please check*************");
				}

			} else {
				System.out.println("Element is not Displayed, please check*************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendkeysByNAME(String locater, String inputData) {
		try {
			WebElement ele = driver.findElement(By.name(locater));
			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {
					ele.sendKeys(inputData);

				} else {
					System.out.println("Element is not Enabled state, please check*************");
				}

			} else {
				System.out.println("Element is not Displayed, please check*************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void sendkeysByXpath(String locater, String inputData) {
		try {
			WebElement ele = driver.findElement(By.xpath(locater));
			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {
					ele.sendKeys(inputData);

				} else {
					System.out.println("Element is not Enabled state, please check*************");
				}

			} else {
				System.out.println("Element is not Displayed, please check*************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/****************** click on webelement **********************/

	public void clickByID(String locater) {
		try {
			WebElement ele = driver.findElement(By.id(locater));
			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {
					ele.click();

				} else {
					System.out.println("Element is not Enabled state, please check*************");
				}

			} else {
				System.out.println("Element is not Displayed, please check*************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickByName(String locater) {
		try {
			WebElement ele = driver.findElement(By.name(locater));
			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {
					ele.click();

				} else {
					System.out.println("Element is not Enabled state, please check*************");
				}

			} else {
				System.out.println("Element is not Displayed, please check*************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickByXpath(String locater) {
		try {
			WebElement ele = driver.findElement(By.xpath(locater));
			if (ele.isDisplayed()) {
				if (ele.isEnabled()) {
					ele.click();

				} else {
					System.out.println("Element is not Enabled state, please check*************");
				}

			} else {
				System.out.println("Element is not Displayed, please check*************");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void takescreenhot(String nameoftheScreenshot) throws IOException {
		// take screenshots
		Date d = new Date();
		System.out.println(d);// Thu Sep 12 22:33:39 EDT 2019
		// yyyy_MM_dd_HH_mm_ss
		DateFormat df = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss a");
		String timestamp = df.format(d);
		System.out.println(timestamp);
		String path = "./screenshots/";

		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(f, new File(path + nameoftheScreenshot + "_" + timestamp + ".PNG"));
	}

	public void takescreenshotPassorFail(ITestResult res) throws Exception {

		// To get the runner class and method names
		className = res.getTestClass().getName().trim();
		methodName = res.getName().trim();
		// take screenshots
		Date d = new Date();
		System.out.println(d);// Thu Sep 12 22:33:39 EDT 2019
		// yyyy_MM_dd_HH_mm_ss
		DateFormat df = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss a");
		String timestamp = df.format(d);
		System.out.println(timestamp);
		
		if (res.getStatus() == ITestResult.FAILURE) {
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(f, new File("./screenshots/" +"Fail_"+className  + "_" +methodName+"_"+ timestamp + ".PNG"));

		}
		if (res.getStatus() != ITestResult.FAILURE) {
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(f, new File("./screenshots/" +"Pass_"+className  + "_" +methodName+"_"+ timestamp + ".PNG"));

		}
		Thread.sleep(3000);
		
	}

}
