package de.gerweckweb.helper;

import java.io.File;
import java.io.IOException;
import java.lang.*;

/**
 * Created with IntelliJ IDEA,
 * User: corat
 * Date: 29.08.2020
 * Time: 16:10
 */


public class RestartApp {
    public static void newInstance(String[] params) {
        File javaPath = new File(System.getProperty("java.home") + System.getProperty("file.separator") + "bin" + System.getProperty("file.separator"));
        // check for windows consoleless
        File java = new File(javaPath, "javaw.exe");
        // else take the default interpreter
        if (!java.exists())
            java = new File(javaPath, "java");
        String[] cmd = new String[4 + params.length];
        // path to java
        cmd[0] = java.getAbsolutePath();
        // parameter for classpath
        cmd[1] = "-cp";
        // restore classpath
        cmd[2] = System.getProperty("java.class.path");
        // class to start
        cmd[3] = Object.class.getName();
        // copy old params
        System.arraycopy(params, 0, cmd, cmd.length - params.length,
                params.length);
        // execute
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void restart(String[] args) {
        try {
            newInstance(args);
        } catch (Exception e) {
            // perhaps make a info dialog to inform user about the failed restart
            System.exit(1);
        } finally {
            // fine, the new instance is running
            System.exit(5);
        }
    }
}



