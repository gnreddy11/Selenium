package com.TestScenarios;

import java.util.Random;

public class RandomSample {
	public static void main(String[] args) {
		//print any random number in 1 to 10 
		Random r = new  Random();
		int myNumber = r.nextInt(10);
		if (myNumber==0) {
			myNumber=1;
			System.out.println("myNumber has changed manually to '1'");
		}
		System.out.println(myNumber);
		
		
	}

}
