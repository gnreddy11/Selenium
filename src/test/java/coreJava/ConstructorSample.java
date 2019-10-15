package coreJava;

public class ConstructorSample {

	/*
	 * public void test() { System.out.println("Test method code"); }
	 * 
	 * // Constructor ConstructorSample() { System.out.println("Constructor code");
	 * }
	 * 
	 * public void test1() { System.out.println("Test1 method code"); }
	 * 
	 * public static void main(String[] args) {
	 * 
	 * // System.out.println("Main method code"); ConstructorSample abc = new
	 * ConstructorSample(); // test(); abc.test(); abc.test1(); }
	 */
	
	
	String name;
	   //Constructor
	ConstructorSample(){
	      this.name = "Nagesh";
	      System.out.println("cons: "+ name);
	   }
	   public static void main(String[] args) {
		   ConstructorSample obj = new ConstructorSample();
		   String name = "Seenu";
		   System.out.println(name);
	      System.out.println(obj.name);
	   }

}
