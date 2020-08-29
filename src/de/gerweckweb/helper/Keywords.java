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
            System.out.println("RESTART");
        }
    },
    CLEAR {
        public void doAnything() {
            System.out.println("CLEAR");
        }
    };

    abstract void doAnything();


}
