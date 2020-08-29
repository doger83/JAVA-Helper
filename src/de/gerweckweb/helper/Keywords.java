package de.gerweckweb.helper;

/**
 * Created with IntelliJ IDEA,
 * User: corat
 * Date: 28.08.2020
 * Time: 14:41
 */
public enum Keywords {
    EXIT {
        public void doAnything() {
            System.exit(0);
        }
    },
    RESTART {
        public void doAnything() {
            System.out.println("restart");
            RestartApp restart = new RestartApp();
            String[] params = {};
            RestartApp.restart(new String[]{});

        }
    },
    CLEAR {
        public void doAnything() {
            System.out.println("CLEAR");
        }
    };

    abstract void doAnything();



}