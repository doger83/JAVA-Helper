package de.gerweckweb.helper;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author domininic gerweck/daniel neubieser
 */
public class KeyboardTester {

    public static void main(String[] args) throws IOException, SQLException {
//try to check an entry for correctness
        //int intInput;
        //String promptMsg1 = "Enter an Integer Value: ";
        //String errorMsg1 = "Invalid entry! Enter an Integer Value: ";
//
        //intInput = Keyboard.readInteger(promptMsg1, errorMsg1, 5, 10);
//
        //System.out.println("You entered tha Value: " + intInput);
//try to check an entry for correctness in Gui
        //SimpleGui gui = new SimpleGui("tester");
        //gui.setSize(100,100);
        //gui.setVisible(true);



//try Keywords
        int a = Keyboard.readInteger("Zahl oder Keyword", "no");
        System.out.println(a);


//try Databaseconnector


        ConnectDatabase cb = new ConnectDatabase("localhost",1433,"TeachSQL",new Logins().getUsername(),new Logins().getPassword());
        cb.connectDatabaseAndExecuteQuery("USE TeachSQL SELECT count(LEASEID) AS 'Entrys' FROM tblDHCPLog");
        //cb = new ConnectDatabase("localhost",1433,"Northwind",new Logins().getUsername(),new Logins().getPassword());
        cb.connectDatabaseAndExecuteQuery("USE Northwind SELECT *FROM Employees");
//        Logins seperaterLogin = new Logins("User","Passwort");
//        ConnectDatabase cb2 = new ConnectDatabase("localhost",1433,"TeachSQL",seperaterLogin.getUsername(),seperaterLogin.getPassword());
//        cb2.connectDatabaseAndExecuteQuery("USE Northwind SELECT *FROM Territorys);

    }
}