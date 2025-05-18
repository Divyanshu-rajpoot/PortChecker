package src;

public class PortCheckerApp {
    public static void main(String[] args) {
        PortScanner portscanner = new PortScanner();

        if (args.length == 0 || args[0].equalsIgnoreCase("--help")) {
            printHelp();
            return;
        }

        switch (args[0]){
            case "--list":
                portscanner.scanPorts();
                break;
            case "--check":
                if (args.length<2){
                    System.out.println("Provide the Port Number");
                }
                else{
                    portscanner.checkPort(Integer.parseInt(args[1]));
                }
                break;
            case "--kill":
                if (args.length<2){
                    System.out.println("Provide the Port Number");
                }
                else{
                    portscanner.killProcess(Integer.parseInt(args[1]));
                }
                break;
            default:
                System.out.println("Unknown command: " + args[0]);
                printHelp();
                break;
        }
    }
    private static void printHelp() {
        System.out.println("\nPort Checker CLI Tool");
        System.out.println("----------------------");
        System.out.println("Usage:");
        System.out.println("  java -jar port-checker.jar --list           List active ports");
        System.out.println("  java -jar port-checker.jar --check <port>   Check if a port is in use");
        System.out.println("  java -jar port-checker.jar --kill <port>    Kill process using a port");
        System.out.println("  java -jar port-checker.jar --help           Show help menu\n");
    }
}
