package com.TestNG;

import org.testng.annotations.Test;

public class Sample3 {

  @Test(enabled = false)
  public void f() {
	  System.out.println("Test F");
  }
  
  @Test
  public void r() {
	  System.out.println("Test R");
  }
  
  @Test
  public void a() {
	  System.out.println("Test A");
  }
}
