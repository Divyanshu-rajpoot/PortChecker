package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PortScanner {

    private final String os = getOs();

    public void scanPorts() {
        System.out.println();
        System.out.println(" Scanning open ports...\n");
        String command;
        if (os.contains("win")) {
            command = "netstat -aon | findstr LISTENING";
        } else {
            command = "lsof -i -P -n | grep LISTEN";
        }
        runCommand(command);
        System.out.println();
    }

    public void checkPort(int port) {
        System.out.println();
        System.out.println(" Checking port " + port + "...\n");
        String command;
        if (os.contains("win")) {
            command = "netstat -aon | findstr :" + port;
        } else {
            command = "lsof -i :" + port;
        }
        runCommand(command);
        System.out.println();
    }
    public String getOs(){
        return System.getProperty("os.name").toLowerCase();
    }

    private void runCommand(String command) {
        Process process;
        try {
            if (os.contains("win")) {
                process = Runtime.getRuntime().exec("cmd /c " + command);
            } else {
                process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command});
            }

            printProcessOutput(process);
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }

    private void printProcessOutput(Process process) throws IOException {
        BufferedReader stdOut = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdErr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;

        while ((line = stdOut.readLine()) != null) {
            System.out.println(line);
        }
        while ((line = stdErr.readLine()) != null) {
            System.err.println(line);
        }
    }

    public void killProcess(int port) {
        System.out.println(" Killing process on port " + port + "...\n");
        String command;

        if (os.contains("win")) {
            // Find PID and kill
            command = "for /f \"tokens=5\" %a in ('netstat -aon | findstr :" + port + "') do taskkill /PID %a /F";
        } else {
            // Unix-style kill
            command = "lsof -ti :" + port + " | xargs kill -9"; //-9 is for force full
        }
        runCommand(command);
        System.out.println("Port : " + port + " Killed successfully!!");
    }
}
