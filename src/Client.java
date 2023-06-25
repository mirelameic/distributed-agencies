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


        UserInterface.displayMessage("Enter the Agency ID:");
        String agencyId = UserInterface.getUserCommand();

        UserInterface.displayMessage("Enter the Machine Name:");
        String machineName = UserInterface.getUserCommand();

        Agency agency = new Agency(agencyId, machineName, serviceRegistry);
        agency.register();

        UserInterface.printLine();

        UserInterface.displayMessage("Enter the Agent ID:");
        String agentId = UserInterface.getUserCommand();

        agency.registerAgent(agentId);

        UserInterface.printLine();

        UserInterface.displayMessage("Enter the Destination Agency ID:");
        String destinationAgencyId = UserInterface.getUserCommand();

        agency.migrateAgent(agentId, destinationAgencyId);
    }
}