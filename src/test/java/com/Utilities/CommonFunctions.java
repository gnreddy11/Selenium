package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

public class CommonFunctions extends StaticVaraibles {

	public CommonFunctions() {
		ProjectDir = System.getProperty("user.dir");

		File file = new File(ProjectDir + "\\screenshots");
		boolean a = false;
		if (!file.exists()) {
			a = file.mkdir();
		}
		if (a)
			System.out.println("screenshots folder successfully created.");
		else
			System.out.println("screenshots folder already exists.");

		ScreenshotsPath = ProjectDir + "\\screenshots\\";
		System.out.println("Current Project Physical Location: " + ProjectDir);
		System.out.println("For screenshots path: " + ScreenshotsPath);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	}

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
		driver.manage().window().maximize();

	}

	// Chrome browser launch
	public void chromeBrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", ".\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

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

	public void clickByanyLocater(final By locater) {
		try {
			WebElement ele = driver.findElement(locater);
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
			FileHandler.copy(f,
					new File("./screenshots/" + "Fail_" + className + "_" + methodName + "_" + timestamp + ".PNG"));

		}
		if (res.getStatus() != ITestResult.FAILURE) {
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(f,
					new File("./screenshots/" + "Pass_" + className + "_" + methodName + "_" + timestamp + ".PNG"));

		}
		Thread.sleep(3000);

	}

	/************ Frame Handle *******************/
	public int loopAllframesAndReturnCountofElement(final By locator) {
		// WebElement found = fluentWait(By.xpath(xPathElement));
		int ElementpresenceCount = 0;
		int Loop = 0;
		int maxFramaecount = IframeCount();// 3

		while (ElementpresenceCount < 1) {
			try {
				Thread.sleep(250);
				switchToFrameByInt(Loop);
				ElementpresenceCount = driver.findElements(locator).size();// 1
				System.out.println(
						"Try LoopAllframesAndReturnWebEL: " + Loop + "; ElementpresenceCount: " + ElementpresenceCount);
				Loop++;// 2
				if (ElementpresenceCount > 0 || Loop > maxFramaecount) {
					break;
				}
			} catch (Exception ex) {
				System.out.println("Catch LoopAllframesAndReturnWebEL : " + Loop + "; " + ex);
			}
		}
		return ElementpresenceCount;
	}

//	public WebElement ReturnWebElementByAnyLocator(final By locator) {
//		WebElement RetEl = driver.findElement(locator);
//		return RetEl;
//	}

	/***********************/
	public int IframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are: " + numberOfFrames);

		return numberOfFrames;
	}

	/**********************/
	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	/****************** ScrollToElementBottom *****************************/

	public void ScrollToElementBottom(final By locator) {
		WebElement element = driver.findElement(locator);
		try {

			System.out.println("***ScrollToElementBottom:  ***");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", element);
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		} catch (StaleElementReferenceException e) {
			System.out.println("Element - " + element + " is not attached to the page document " + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + element + " was not found in DOM" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Error description: " + e.getStackTrace());

		}
	}
	
	/****** ExplicitWait ******/
	public void explicitWaitUsingElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitforelementtobevisible(WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitforelementinvisibility(WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * instead of fluent wait use customized While loop statement
	 * 
	 * @throws Exception
	 *****/

	public void waitforElement(String locater) throws Exception {
		int i = 0;
		while (driver.findElements(By.xpath(locater)).size() < 1) {
			Thread.sleep(500);
			System.out.println("Wait for the element***************");
			// Suppose system has not present the element it will repeat 20 time
			// then stop the execution using break
			if (i > 20) {
				System.out.println("Element is not present");
				break;
			}
			i++;
		}
	}
	/************* Random Number generator ***************/
	public int RandomNo(int Max) {
		int randomInt = 0;
		Random rg = new Random();
		for (int idx = 1; idx <= Max; ++idx) {
			randomInt = rg.nextInt(Max);
			if (randomInt == 0) {
				randomInt = 1;
			}
			System.out.println("Generated : " + randomInt);
		}
		return randomInt;
	}
	
}