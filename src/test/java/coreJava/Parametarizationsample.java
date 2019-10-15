package coreJava;

public class Parametarizationsample {

	/*
	 * public static void emp11() { System.out.println("1234");
	 * System.out.println("Nagesh"); }
	 * 
	 * public static void emp12() { System.out.println("12345");
	 * System.out.println("Nagesh Reddy"); }
	 */

	public static void emp(int empID, String empName) {
		System.out.println("empid:" + empID + "empName:" + empName);
	}

	public static void main(String[] args) {
		// emp11();
		// emp12();
		emp(123,"Nagesh");
		emp(1234,"Nagesh Reddy");
		emp(235325,"Seenu Reddy");

	}

}
