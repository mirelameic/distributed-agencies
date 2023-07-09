import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class NamingServiceServer {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: NamingServiceServer <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);
        String serviceName = "NamingService";
        try {
            NamingServiceImpl namingService = new NamingServiceImpl();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.rebind(serviceName, namingService);
            UserInterface.displayMessage("NamingService bound at port " + port);
        } catch (Exception e) {
            UserInterface.displayError("NamingService Exception.", e);
        }
    }
}