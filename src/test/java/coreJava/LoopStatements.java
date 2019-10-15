package coreJava;

public class LoopStatements {
	public static void main(String[] args) {
		// for(initilizeValue;Condition;increment/Decrement){}
		for (int i = 0; i < 11; i++) {

			System.out.println(i);// 0 1 2 3 4 5

		} // for loop end
		System.out.println("******************************");

		// Nestedt For loop: Loop within the loop
		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 2; j++) {
				System.out.println(i + " ," + j);// 0,0 0,1 1,0 1,1
			} // j for loop end

		} // i for loop end

		System.out.println("***********************************************");
		// While loop
		int a = 3;
		while (a < 5) {
			System.out.println(a);// 3 4
			a++;

		}
		System.out.println("##########################################*******");

		int b = 9;
		do {
			System.out.println(b);
			b++;
		} while (b < 12);

	}

}
