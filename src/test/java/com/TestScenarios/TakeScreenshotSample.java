package com.TestScenarios;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshotSample {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);//Thu Sep 12 22:33:39 EDT 2019

		//yyyy_MM_dd_HH_mm_ss
		DateFormat df = new SimpleDateFormat("yyyy_MMM_dd_HH_mm_ss a");
		String timestamp = df.format(d);
		System.out.println(timestamp);
		
		
		
	}

}
