package de.gerweckweb.helper;

import java.io.IOException;

public class KeyboardTester {

    public static void main(String[] args) throws IOException {

        //int intInput;
        //String promptMsg1 = "Enter an Integer Value: ";
        //String errorMsg1 = "Invalid entry! Enter an Integer Value: ";
//
        //intInput = Keyboard.readInteger(promptMsg1, errorMsg1, 5, 10);
//
        //System.out.println("You entered tha Value: " + intInput);
//
        //SimpleGui gui = new SimpleGui("tester");
        //gui.setSize(100,100);
        //gui.setVisible(true);



//try Keywords
        int a = Keyboard.readInteger("Zahl oder Keyword", "no");
        System.out.println(a);
    }
}
