package de.gerweckweb.helper;

import java.util.Scanner;

import javax.swing.JTextField;

public final class Keyboard {

	/**
	 * Ask the user to input a number. Returns an integer value.
	 * 
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg  Output tells user the errors
	 * @param low       determines the smallest number
	 * @param high      determines the largest number
	 * @return num The valid whole number entry
	 * @author domininic gerweck
	 */
	public static int readInteger(String promptMsg, String errorMsg) {
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
				input.close();
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}

	/**
	 * Asks the user to input a number in a given range. returns an integer value.
	 * 
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg  Output tells user the errors
	 * @param low       determines the smallest number
	 * @param high      determines the largest number
	 * @return num The valid whole number entry
	 * @author domininic gerweck
	 */
	public static int readInteger(String promptMsg, String errorMsg, int low, int high) {
		// TODO check if low is lower than hight!
		Scanner input = new Scanner(System.in);
		int num = 0;
		String strInput;
		boolean isValid = false;
		// keep looking until valid userinput
		while (!isValid) {
			// prompt the user
			System.out.println(promptMsg);
			System.out.printf("(%d - %d)\n", low, high);
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
	 * Asks the user to input a number. returns an double value.
	 * 
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg  Output tells user the errors
	 * @return num The valid floatingpoint number entry
	 * @author dominic gerweck
	 */
	public static double readDouble(String promptMsg, String errorMsg) {
		Scanner input = new Scanner(System.in);
		double num = 0.0;
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
				num = Double.parseDouble(strInput);
				input.close();
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}

	/**
	 * Asks the user to input a number in a given range. returns an double value.
	 * 
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg  Output tells user the errors
	 * @param low       determines the smallest number
	 * @param high      determines the largest number
	 * @return num The valid floatingpoint number entry
	 * @author dominic gerweck
	 */
	public static double readDouble(String promptMsg, String errorMsg, double low, double high) {
		// TODO check if low is lower than hight!
		Scanner input = new Scanner(System.in);
		double num = 0;
		String strInput;
		boolean isValid = false;
		// keep looking until valid userinput
		while (!isValid) {
			// prompt the user
			System.out.println(promptMsg);
			System.out.printf("(%.2f - %.2f)\n", low, high);
			// grab input from Keyboard
			strInput = input.nextLine();
			// try to convert String to int
			try {
				num = Double.parseDouble(strInput);
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
	 * @param textField check this textField for valid Input (Integer) between min
	 *                  and max
	 * @return only Integer are possible
	 * @author daniel neubiesser
	 */
	public static int guiReadInt(JTextField textField, int min, int max) {
		// keep looking until valid userinput
		// try to convert String to int
		try {
			Integer.parseInt(textField.getText());

		} catch (NumberFormatException e) {
			textField.setText("Input Integer");
		}
		if (Integer.parseInt(textField.getText()) < min || Integer.parseInt(textField.getText()) > max) {
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
	 * @author daniel neubiesser
	 */
	public static int guiReadInt(JTextField textField) {
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
