package de.gerweckweb.helper;

import java.util.Scanner;

public final class Keyboard {

//	Keyboard() {
//		input = new Scanner(System.in);
//	}

//	public int readInteger(String promptMsg, String errorMsg) {
//		int num = 0;
//		String strInput;
//		boolean isValid = false;
//		// keep looking until valid userinput
//		while (isValid == false) {
//			// prompt the user
//			System.out.println(promptMsg);
//			// grab input from Keyboard
//			strInput = input.nextLine();
//			// try to convert String to int
//			try {
//				num = Integer.parseInt(strInput);
//				isValid = true;
//			} catch (NumberFormatException e) {
//				System.out.println(errorMsg);
//			}
//		}
//		return num;
//	}

	public static int readInteger(String promptMsg, String errorMsg, int low, int high) {
		Scanner input = new Scanner(System.in);
		int num = 0;
		String strInput;
		boolean isValid = false;
		// keep looking until valid userinput
		while (isValid == false) {
			// prompt the user
			System.out.println(promptMsg);
			// grab input from Keyboard
			strInput = input.nextLine();
			// try to convert String to int
			try {
				num = Integer.parseInt(strInput);
				// check if input is in the right range
				if (num >= low && num <= high) {
					input.close();
					isValid = true;
				} else {
					System.out.println(errorMsg);
				}
			} catch (NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}

		return num;
	}

//	public double readDouble(String promptMsg, String errorMsg) {
//		double num = 0.0;
//		String strInput;
//		boolean isValid = false;
//		// keep looking until valid userinput
//		while (isValid == false) {
//			// prompt the user
//			System.out.println(promptMsg);
//			// grab input from Keyboard
//			strInput = input.nextLine();
//			// try to convert String to int
//			try {
//				num = Double.parseDouble(strInput);
//				isValid = true;
//			} catch (NumberFormatException e) {
//				System.out.println(errorMsg);
//			}
//		}
//		return num;
//	}

}
