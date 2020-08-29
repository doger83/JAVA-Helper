package de.gerweckweb.helper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class KeyboardTester {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Keyboard kb = new Keyboard();

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


        /**
         * Versuche Keywords zu verarbeiten
         */
        String d = "RESTART";
        String e = "EXIT";

        Keywords key;
        System.out.println(Arrays.toString(Keywords.values()));
        //try {
        //	key = Keywords.valueOf(d);
        //	System.out.println("  sd");
        //	key.doAnything();
        //} catch (IllegalArgumentException illegalArgumentException) {
        //	illegalArgumentException.printStackTrace();
        //}
        //try {
        //	key = Keywords.valueOf(e.toUpperCase());
        //	key.doAnything();
        //}
        //catch (IllegalArgumentException ex){
        //	System.out.println(ex.getMessage());
        //}


        int a = Keyboard.readInteger("Enter a Integer", "no Keyword / no Integer");
        System.out.println(a);

    }

}
