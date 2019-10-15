package coreJava;

public class StringSample {

	public static void main(String[] args) {

		String abc;
		abc = "Nagesh";

		String bcd = "Reddy";

		String result;
		result = "Pass";
		result = "Fail";

		System.out.println(abc);
		System.out.println(bcd);

		System.out.println(abc + " " + bcd);

		System.out.println(abc.toUpperCase());
		System.out.println(bcd.toLowerCase());

		// Equal / EqualIgnoreCase
		String a = "Apple";
		String b = "Mango";
		String c = "apple";

		if (a.equals(c)) {
			System.out.println("Both the Strings are matching");

		} else {
			System.out.println("Both the Strings are NOT matching");
		}

		if (a.equalsIgnoreCase(c)) {
			System.out.println("Both the Strings are matching************");
			if (a.equals(b)) {
				System.out.println("test");
			}

		} else {
			System.out.println("Both the Strings are NOT matching*****************");
		}

		String e = "123";
		int f = 121;
		System.out.println(e + f);// 244 123121

		int g = Integer.parseInt(e);
		System.out.println(f + g);
		
		
		String h = "NageshReddy";
		
		h=h.toLowerCase();
		System.out.println(h);
		if (h.contains("Redd") || abc.contains("Nag")) {
			System.out.println("'Redd' text is avaialble in String 'h'");
		}else {
			System.out.println("String not contains 'Redd' text*****");
		}
		
		if (h.contentEquals("NageshReddy")) {
			System.out.println("'NageshReddy' text is avaialble in String 'h'");
		}
		

	}

}
