package com.TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNgAnnotations {
	@Test
	public void f() {
		System.out.println("I am @Test f");
	}
	@Test
	public void r() {
		System.out.println("I am @Test r ");
	}
	@Test
	public void a() {
		System.out.println("I am @Test a");
	}
	
	

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am @AfterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am @BeforeClass ");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am @AfterClass");
	}

}
