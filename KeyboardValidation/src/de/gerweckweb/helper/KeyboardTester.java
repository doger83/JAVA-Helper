package de.gerweckweb.helper;

public class KeyboardTester {

	public static void main(String[] args) {
//		Keyboard kb = new Keyboard();

		int intInput;
		String promptMsg1 = "Enter an Integer Value: ";
		String errorMsg1 = "Invalid entry! Enter an Integer Value: ";

		intInput = Keyboard.readInteger(promptMsg1, errorMsg1, 5, 10);

		System.out.println("You entered tha Value: " + intInput);

	}

}
