package com.TestScenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Objectrepository.Locaters;
import com.Utilities.CommonFunctions;
import com.Utilities.StaticVaraibles;

public class FramesSample extends StaticVaraibles {
	@Test
	public void f() throws Exception {

		// create reference of CommonFunctions class to re-use of functions
		CommonFunctions cfn = new CommonFunctions();
		Locaters obj = new Locaters();

		String path = "./testData/TD.properties";
		File f = new File(path);
		FileInputStream fi = new FileInputStream(f);

		Properties p = new Properties();
		p.load(fi);

		cfn.browserLaunch("Chrome");
		driver.get(p.getProperty("FrmaesURL"));
		
		
		//Frame handle
		cfn.IframeCount();
		cfn.loopAllframesAndReturnCountofElement(obj.lbmp_Zonal_Link);		
		cfn.ScrollToElementBottom(obj.lbmp_Zonal_Link);
		//cfn.clickByanyLocater(obj.lbmp_Zonal_Link);
		//cfn.clickByJSE(obj.lbmp_Zonal_Link);
		
		

	}
}
