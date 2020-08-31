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
            RestartApplications.restartApplication(() -> {
                {
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
            clearScreen();
            clearRunTerminalFake();
        }
    };

    abstract void doAnything() throws IOException;

    /**
     * checks the operating system and
     * empties the current console with the respectively valid statement
     */
    public static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Is only used to appear empty the terminal RUN in the IDE.
     * This cannot be addressed from Java.
     */
    public static void clearRunTerminalFake(){
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }



}