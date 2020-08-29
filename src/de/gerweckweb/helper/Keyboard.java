package de.gerweckweb.helper;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;

public final class Keyboard {

	/**
	 * Ask the user to input a number. Returns an integer value.
	 * 
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg  Output tells user the error
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
			//check for keyword
			tryKeyword(strInput.toUpperCase());
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
			//check for keyword
			tryKeyword(strInput.toUpperCase());
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
	 * @param textField check this textField for valid Input (Integer) between min
	 *                  and max
	 * @return only Integer are possible
	 * @author daniel neubiesser
	 */
	public static int guiReadInt(JTextField textField, int min, int max) {
		// keep looking until valid userinput
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
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
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
		// try to convert String to int
		try {
			Integer.parseInt(textField.getText());

		} catch (NumberFormatException e) {
			textField.setText("Input Integer");
		}
		return Integer.parseInt(textField.getText());
	}

	/**
	 *
	 *@param promptMsg Output for request a specified Input
	 * @param errorMsg Output tells user the errors
	 * @param low determines the smallest number
	 * @param high determines the largest number
	 * @return returns the valid whole number entry(double)
	 */
	public static double readDouble(String promptMsg, String errorMsg, double low, double high) {
		Scanner input = new Scanner(System.in);
		double num = 0;
		String strInput;
		boolean isValid = false;
		// keep looking until valid userinput
		while (!isValid) {
			// prompt the user
			System.out.println(promptMsg);
			// grab input from Keyboard
			strInput = input.nextLine();
			//check for keyword
			tryKeyword(strInput.toUpperCase());
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
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg Output tells user the errors
	 * @return returns the valid whole number entry(double)
	 */
	public static double readDouble(String promptMsg, String errorMsg) {
		Scanner input = new Scanner(System.in);
		double num = 0;
		String strInput;
		boolean isValid = false;
		// keep looking until valid userinput
		while (!isValid) {
			// prompt the user
			System.out.println(promptMsg);
			// grab input from Keyboard
			strInput = input.nextLine();
			//check for keyword
			tryKeyword(strInput.toUpperCase());
			// try to convert String to int
			try {
				num = Double.parseDouble(strInput);
			} catch (NumberFormatException e) {
				System.out.println(errorMsg);
			}
			isValid = true;
		}
		return num;
	}

	/**
	 *
	 * @param textField check this textField for valid Input (Double) between min, max
	 * @param min determines the smallest number
	 * @param max determines the largest number
	 * @return only Double are possible between min max
	 */
	public static double guiReadDouble(JTextField textField, double min, double max){
		// keep looking until valid userinput
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
		// try to convert String to int
		try {
			Double.parseDouble(textField.getText());

		} catch (NumberFormatException e) {
			textField.setText("Input Double");
		}
		if(Double.parseDouble(textField.getText()) < min || Double.parseDouble(textField.getText()) > max) {
			System.out.println(Double.parseDouble(textField.getText()));
			String trash = "trash";
			try {
				Double.parseDouble(trash);
			} catch (NumberFormatException e2) {
				textField.setText("Integer between " + min + " & " + max);
			}
		}
		return Double.parseDouble(textField.getText());
	}

	/**
	 *
	 * @param textField check this textField for valid Input (Double)
	 * @return only Integer are possible
	 */
	public static Double guiReadDouble(JTextField textField){
		// keep looking until valid userinput
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
		// try to convert String to int
		try {
			Double.parseDouble(textField.getText());

		} catch (NumberFormatException e) {
			textField.setText("Input Integer");
		}
		return Double.parseDouble(textField.getText());
	}

	/**
	 *
	 * tryKeyword takes over the param text and checks whether it is a keyword
	 * in order to then start the Keyword - method doAnything()
	 *
	 * @param text input is checked for keywords
	 */
	public static void tryKeyword(String text){
		text = text.toUpperCase();
		if(contains(text)) {
			try {
				Keywords.valueOf(text.toUpperCase()).doAnything();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	/**
	 *
	 * @param text Input is checked for keywords
	 * @return is present in keywords
	 */
	public static boolean contains(String text) {
		for (Keywords c : Keywords.values()) {
			if (c.name().equals(text)) {
				return true;
			}
		}
		return false;
	}
}
