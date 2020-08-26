package de.gerweckweb.helper;

import javax.swing.*;
import java.util.Scanner;

public final class Keyboard {

	/**
	 *
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg Output tells user the errors
	 * @param low determines the smallest number
	 * @param high determines the largest number
	 * @return returns the valid whole number entry
	 */
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

	/**
	 *
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg Output tells user the errors
	 * @return returns the valid whole number entry
	 */
	public static int readInteger(String promptMsg, String errorMsg) {
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
			} catch (NumberFormatException e) {
				System.out.println(errorMsg);
			}
			isValid = true;
		}
		return num;
	}

	/**
	 *
	 * @param textField check this textField for valid Input (Integer) between min, max
	 * @param min determines the smallest number
	 * @param max determines the largest number
	 * @return only Integer are possible between min max
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
