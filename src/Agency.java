import java.rmi.RemoteException;

public class Agency {
    private String agencyId;
    private String machineName;
    private ServiceRegistry serviceRegistry;

    public Agency(String agencyId, String machineName, ServiceRegistry serviceRegistry) {
        this.agencyId = agencyId;
        this.machineName = machineName;
        this.serviceRegistry = serviceRegistry;
    }

    public void register() {
        try {
            serviceRegistry.registerAgency(agencyId, machineName);
            System.out.println("Agency registered successfully!");
        } catch (RemoteException e) {
            System.out.println("Failed to register agency: " + e.getMessage());
        }
    }

    public void registerAgent(String agentId) {
        try {
            serviceRegistry.registerAgent(agentId, agencyId);
            System.out.println("Agent registered successfully!");
        } catch (RemoteException e) {
            System.out.println("Failed to register agent: " + e.getMessage());
        }
    }

    public void migrateAgent(String agentId, String destinationAgencyId) {
        try {
            serviceRegistry.migrateAgent(agentId, destinationAgencyId);
            System.out.println("Agent migrated successfully!");
        } catch (RemoteException e) {
            System.out.println("Failed to migrate agent: " + e.getMessage());
        }
    }

    public void sendMessage(String sourceAgentId, String destinationAgentId, String message) {
        try {
            serviceRegistry.sendMessage(sourceAgentId, destinationAgentId, message);
        } catch (RemoteException e) {
            System.out.println("Failed to send message: " + e.getMessage());
        }
    }

    public void startAgent(String agentId) {
        try {
            serviceRegistry.startAgent(agentId);
        } catch (RemoteException e) {
            System.out.println("Failed to start agent: " + e.getMessage());
        }
    }
}
