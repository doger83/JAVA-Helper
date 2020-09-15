/*corat
 *12.09.2020
 *16:23
 *JAVA-Helper
 */

package de.gerweckweb.helper;

/**a class for login handling
 * The standard constructor does not require a username and / or password.
 * Another constructor expects the username and then the password to be entered
 *
 */
public class Logins {
    private final String username;
    private final String password;

    public Logins(){
        username = "client";
        password = "testdb";
    }

    public Logins(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}


