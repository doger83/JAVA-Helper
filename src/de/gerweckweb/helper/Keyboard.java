package de.gerweckweb.helper;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JTextField;

/**
 * @author domininic gerweck/daniel neubieser
 */
public final class Keyboard {
	static Scanner input = new Scanner(System.in);
	static String strInput;

	/**
	 * Ask the user to input a number from console. Returns an integer value.
	 * 
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg  Output tells user the error
	 * @return num The valid whole number entry
	 * @author domininic gerweck
	 */
	public static int readInteger(String promptMsg, String errorMsg) {
		// keep looking until valid userinput
		return tryToParsoToIntBetweenMinMax(promptMsg, errorMsg, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * Asks the user to input a number from console in a given range. returns an integer value.
	 * 
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg  Output tells user the errors
	 * @param low       determines the smallest number
	 * @param high      determines the largest number
	 * @return num The valid whole number entry
	 * @author domininic gerweck
	 */
	public static int readInteger(String promptMsg, String errorMsg, int low, int high) {
		// keep looking until valid userinput
		return tryToParsoToIntBetweenMinMax(promptMsg, errorMsg, low, high);
	}

	private static int tryToParsoToIntBetweenMinMax(String promptMsg, String errorMsg, int low, int high ) {
		int num = 0;
		boolean isValid = false;
		while (!isValid) {
			// try to convert String to int
			try {
				num = Integer.parseInt(userInput(promptMsg));
				// check if input is in the right range
				isValid = betweenMinMaxIsValid(low, high, num);
			} catch (NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}

	/**
	 *
	 *@param promptMsg Output for request a specified Input
	 * @param errorMsg Output tells user the errors
	 * @param low determines the smallest number
	 * @param high determines the largest number
	 * @return returns the valid whole number entry(double)
	 * @author domininic gerweck/daniel neubieser
	 */
	public static double readDouble(String promptMsg, String errorMsg, double low, double high) {
		return getValueAfterCheckForValid(promptMsg, errorMsg, low, high);
	}

	/**
	 *
	 * @param promptMsg Output for request a specified Input
	 * @param errorMsg Output tells user the errors
	 * @return returns the valid whole number entry(double)
	 * @author domininic gerweck/daniel neubieser
	 */
	public static double readDouble(String promptMsg, String errorMsg) {
		return getValueAfterCheckForValid(promptMsg, errorMsg, Double.MIN_VALUE, Double.MAX_VALUE);
	}

	private static double getValueAfterCheckForValid(String promptMsg, String errorMsg, double low, double high) {
		double num = 0;
		boolean isValid = false;
		// keep looking until valid userinput
		while (!isValid) {
			// try to convert String to int
			try {
				num = Double.parseDouble(userInput(promptMsg));
				// check if input is in the right range
				isValid = betweenMinMaxIsValid(low, high, num);
				if (!isValid) { System.out.println(errorMsg);	}
			} catch (NumberFormatException e) {
				System.out.println(errorMsg);
			}
		}
		return num;
	}

	private static boolean betweenMinMaxIsValid(double low, double high, double num) {
		return num >= low && num <= high;
	}


	/**
	 *
	 * @param textField check this textField for valid Input (Integer) between min
	 *                  and max
	 * @return only Integer are possible
	 * @author daniel neubieser
	 */
	public static int guiReadInt(JTextField textField, int min, int max) {
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
		// keep looking until valid userinput
		tryGuiValueBetweenMinMax(textField, min, max);
		return Integer.parseInt(textField.getText());
	}

	/**
	 *
	 * @param textField check this textField for valid Input (Integer)
	 * @return only Integer are possible
	 * @author daniel neubieser
	 */
	public static int guiReadInt(JTextField textField) {
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
		// keep looking until valid userinput
		tryGuiValueBetweenMinMax(textField, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return Integer.parseInt(textField.getText());
	}

	private static void tryGuiValueBetweenMinMax(JTextField textField, int min, int max) {
		// try to convert String to int
		String toCheck = tryToParseGuiValueToInt(textField, min, max);

		if (Integer.parseInt(toCheck) < min || Integer.parseInt(toCheck) > max) {
			textField.setText("Integer between " + min + " & " + max);
		}
	}

	private static String tryToParseGuiValueToInt(JTextField textField, int min, int max) {
		try {
			return String.valueOf(Integer.parseInt(textField.getText()));

		} catch (NumberFormatException e) {
			return "Integer between " + min + " & " + max;
		}

	}

	/**
	 *
	 * @param textField check this textField for valid Input (Double) between min, max
	 * @param min determines the smallest number
	 * @param max determines the largest number
	 * @return only Double are possible between min max
	 * @author daniel neubieser
	 */
	public static double guiReadDouble(JTextField textField, double min, double max){
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
		// keep looking until valid userinput
		parseGuiValueToDouble(textField, min, max);
		return Double.parseDouble(textField.getText());
	}

	/**
	 *
	 * @param textField check this textField for valid Input (Double)
	 * @return only Integer are possible
	 * @author daniel neubieser
	 */
	public static double guiReadDouble(JTextField textField){
		//check for keyword
		tryKeyword(textField.getText().toUpperCase());
		// keep looking until valid userinput
		parseGuiValueToDouble(textField,Double.MIN_VALUE, Double.MAX_VALUE);
		return Double.parseDouble(textField.getText());
	}

	private static void parseGuiValueToDouble(JTextField textField, double min, double max) {
		try {
			Double.parseDouble(textField.getText());
		} catch (NumberFormatException e) {
			textField.setText("Input Double");
		}
		isValidDoubleInRange(textField, min, max);
	}

	/**check text box entry for is double in valid range
	 *
	 * @param textField check this textField for valid Input (Double) between min, max
	 * @param min determines the smallest number
	 * @param max determines the largest number
	 */
	private static void isValidDoubleInRange(JTextField textField, double min, double max) {
		if(Double.parseDouble(textField.getText()) < min || Double.parseDouble(textField.getText()) > max) {
			System.out.println(Double.parseDouble(textField.getText()));
			String trash = "trash";
			try {
				Double.parseDouble(textField.getText());
			} catch (NumberFormatException e2) {
				textField.setText("Integer between " + min + " & " + max);
			}
		}
	}

	/**
	 *
	 * tryKeyword takes over the param text and checks whether it is a keyword
	 * in order to then start the Keyword - method doAnything()
	 *
	 * @param text input is checked for keywords
	 * @author daniel neubieser
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
	 * @author daniel neubieser
	 */
	public static boolean contains(String text) {
		for (Keywords c : Keywords.values()) {
			if (c.name().equals(text)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method for get UserInput and check this for valid Keywords
	 * @param promptMsg Output for request a specified Input
	 */
	public static String userInput(String promptMsg){
		System.out.println(promptMsg);
		// grab input from Keyboard
		strInput = input.nextLine();
		//check for keyword
		tryKeyword(strInput.toUpperCase());
		return strInput;
	}

	/**
	 * Method for get UserInput and check this for valid Keywords
	 * print min & max values
	 * @param promptMsg Output for request a specified Input
	 */
	public static String userInput(String promptMsg, int low, int high){
		System.out.printf(promptMsg + "\n(%d - %d)\n", low, high);
		// grab input from Keyboard
		strInput = input.nextLine();
		//check for keyword
		tryKeyword(strInput.toUpperCase());
		return strInput;
	}
}
