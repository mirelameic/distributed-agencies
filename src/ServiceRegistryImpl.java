import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ServiceRegistryImpl extends UnicastRemoteObject implements ServiceRegistry {
    private Map<String, String> agentRegistry;
    private Map<String, String> agencyRegistry;

    public ServiceRegistryImpl() throws RemoteException {
        agentRegistry = new HashMap<>();
        agencyRegistry = new HashMap<>();
    }

    @Override
    public void registerAgent(String agentId, String agencyId) throws RemoteException {
        agentRegistry.put(agentId, agencyId);
    }

    @Override
    public void registerAgency(String agencyId, String machineName) throws RemoteException {
        agencyRegistry.put(agencyId, machineName);
    }

    @Override
    public void migrateAgent(String agentId, String destinationAgencyId) throws RemoteException {
        if (agentRegistry.containsKey(agentId) && agencyRegistry.containsKey(destinationAgencyId)) {
            agentRegistry.put(agentId, destinationAgencyId);
        } else {
            System.out.println("Invalid source or destination agent!");
        }
    }

    @Override
    public void sendMessage(String sourceAgentId, String destinationAgentId, String message) throws RemoteException {
        String sourceAgencyId = agentRegistry.get(sourceAgentId);
        String destinationAgencyId = agentRegistry.get(destinationAgentId);

        if (sourceAgencyId != null && destinationAgencyId != null) {
            System.out.println("Sending message from Agent: " + sourceAgentId);
            System.out.println("Source Agency: " + sourceAgencyId);
            System.out.println("Destination Agent: " + destinationAgentId);
            System.out.println("Destination Agency: " + destinationAgencyId);
            System.out.println("Message: " + message);
        } else {
            System.out.println("Invalid source or destination agent!");
        }
    }

    @Override
    public void startAgent(String agentId) throws RemoteException {
        String agencyId = agentRegistry.get(agentId);

        if (agencyId != null) {
            try {
                Registry registry = LocateRegistry.getRegistry();
                AgentService agentService = new AgentServiceImpl(agentId, this);
                registry.rebind(agentId, agentService);
                System.out.println("Agent started: " + agentId);
            } catch (Exception e) {
                System.out.println("Failed to start agent: " + agentId);
                e.printStackTrace();
            }
        } else {
            System.out.println("Agent not found!");
        }
    }
}