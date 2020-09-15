package de.gerweckweb.helper;
/**
 *@autor from http://lewisleo.blogspot.com/2012/08/programmatically-restart-java.html
 */

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.List;

public class RestartApplications {
    /**
     * Sun property pointing the main class and its arguments.
     * Might not be defined on non Hotspot VM implementations.
     */
    public static final String SUN_JAVA_COMMAND = "sun.java.command";

    /**
     * Restart the current Java application
     *
     * @param runBeforeRestart some custom code to be run before restarting
     * @throws IOException Signals that an I/O exception of some sort has occurred
     */

    //TODO ConsolenAbfragen werden mit "restart" korrekt behandelt, Gui wird nur beendet
    public static void restartApplication(Runnable runBeforeRestart) throws IOException {
        try {
        // java binary
            String java = System.getProperty("java.home") + "/bin/java";
        // vm arguments
            List<String> vmArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
            StringBuilder vmArgsOneLine = new StringBuilder();
            for (String arg : vmArguments) {
                checkArgumentForAgentLib(vmArgsOneLine, arg);
            }
        // init the command to execute, add the vm args
            final StringBuffer cmd = new StringBuffer("\"" + java + "\" " + vmArgsOneLine);

        // program main and program arguments
            String[] mainCommand = System.getProperty(SUN_JAVA_COMMAND).split(" ");
            checkForJarOrClassPath(cmd, mainCommand);
            addProgramArgs(cmd, mainCommand);
            excecuteCommandInShutdownHook(cmd);
            exceuteSomeCostums(runBeforeRestart);
            // exit
            System.exit(0);
        } catch (Exception e) {
        // something went wrong
            throw new IOException("Error while trying to restart the application", e);
        }
    }

    private static void excecuteCommandInShutdownHook(StringBuffer cmd) {
        // execute the command in a shutdown hook, to be sure that all the
        // resources have been disposed before restarting the application
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                Runtime.getRuntime().exec(cmd.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private static void exceuteSomeCostums(Runnable runBeforeRestart) {
        // execute some custom code before restarting
        if (runBeforeRestart != null) {
            runBeforeRestart.run();
        }
    }

    private static void addProgramArgs(StringBuffer cmd, String[] mainCommand) {
        // finally add program arguments
        for (int i = 1; i < mainCommand.length; i++) {
            cmd.append(" ");
            cmd.append(mainCommand[i]);
        }
    }

    private static void checkArgumentForAgentLib(StringBuilder vmArgsOneLine, String arg) {
        // if it's the agent argument : we ignore it otherwise the
        // address of the old application and the new one will be in conflict
        if (!arg.contains("-agentlib")) {
            vmArgsOneLine.append(arg);
            vmArgsOneLine.append(" ");
        }
    }

    private static void checkForJarOrClassPath(StringBuffer cmd, String[] mainCommand) {
        // program main is a jar
        if (mainCommand[0].endsWith(".jar")) {
        // if it's a jar, add -jar mainJar
            cmd.append("-jar ").append(new File(mainCommand[0]).getPath());
        } else {
        // else it's a .class, add the classpath and mainClass
            cmd.append("-cp \"").append(System.getProperty("java.class.path")).append("\" ").append(mainCommand[0]);
        }
    }
}
