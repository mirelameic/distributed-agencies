import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        ServiceRegistry serviceRegistry;

        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            serviceRegistry = new ServiceRegistryImpl();
            registry.rebind("ServiceRegistry", serviceRegistry);
            System.out.println("Service Registry started successfully!");
        } catch (RemoteException e) {
            System.out.println("Failed to start Service Registry: " + e.getMessage());
            return;
        }

        UserInterface userInterface = new UserInterface();

        userInterface.displayMessage("Enter the Agency ID:");
        String agencyId = userInterface.getUserCommand();

        userInterface.displayMessage("Enter the Machine Name:");
        String machineName = userInterface.getUserCommand();

        Agency agency = new Agency(agencyId, machineName, serviceRegistry);
        agency.register();

        userInterface.printLine();

        userInterface.displayMessage("Enter the Agent ID:");
        String agentId = userInterface.getUserCommand();

        agency.registerAgent(agentId);

        userInterface.printLine();

        userInterface.displayMessage("Enter the Destination Agency ID:");
        String destinationAgencyId = userInterface.getUserCommand();

        agency.migrateAgent(agentId, destinationAgencyId);
    }
}