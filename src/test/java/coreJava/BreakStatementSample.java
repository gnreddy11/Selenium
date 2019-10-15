
package coreJava;

public class BreakStatementSample {
	public static void main(String[] args) {
		int a = 0;
		while (a >= 0) {
			System.out.println(a);
			a++;
			if (a == 15) {
				break;
			}
		}
	}
}
