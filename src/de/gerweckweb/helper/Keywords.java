package de.gerweckweb.helper;

import java.io.IOException;

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
        public void doAnything() throws IOException {
            System.out.println("restart");
            String[] params = {};
            RestartApplications.restartApplication(new Runnable() {
                @Override
                public void run() {
                    try {
                        KeyboardTester.main(new String[]{""});
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            });
        }
    },
    CLEAR {
        public void doAnything() {
            System.out.println("CLEAR");
        }
    };

    abstract void doAnything() throws IOException;



}