package de.gerweckweb.helper;

import javax.swing.*;
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
		while (!isValid) {
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

	/**
	 *
	 * @param textField check this textField for valid Input (Integer) between min, max
	 * @return only Integer are possible
	 */
	public static int guiReadInt(JTextField textField, int min, int max){
		// keep looking until valid userinput
		// try to convert String to int
		try {
			Integer.parseInt(textField.getText());

		} catch (NumberFormatException e) {
			textField.setText("Input Integer");
		}
		if(Integer.parseInt(textField.getText()) < min || Integer.parseInt(textField.getText()) > max) {
			System.out.println(Integer.parseInt(textField.getText()));
			String trash = "trash";
			try {
				Integer.parseInt(trash);
			} catch (NumberFormatException e2) {
				textField.setText("Integer between " + min + " & " + max);
			}
		}
		return Integer.parseInt(textField.getText());
	}

	/**
	 *
	 * @param textField check this textField for valid Input (Integer)
	 * @return only Integer are possible
	 */
	public static int guiReadInt(JTextField textField){
		// keep looking until valid userinput
		// try to convert String to int
		try {
			Integer.parseInt(textField.getText());

		} catch (NumberFormatException e) {
			textField.setText("Input Integer");
		}
		return Integer.parseInt(textField.getText());
	}
}
