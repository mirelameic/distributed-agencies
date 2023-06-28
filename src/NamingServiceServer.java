import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NamingServiceServer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: NamingServiceServer <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        try {
            NamingService namingService = new NamingServiceImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind("NamingService", namingService);
            System.out.println("NamingService-Server is ready.");
        } catch (Exception e) {
            UserInterface.displayError("NamingServiceServer error", e);
        }
    }
}