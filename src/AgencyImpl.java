import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AgencyImpl extends UnicastRemoteObject implements Agency {
    private String agencyId;
    private String agencyName;
    private List<Agent> agentList;

    public AgencyImpl(String agencyName) throws RemoteException {
        this.agencyId = generateUniqueCode();
        this.agencyName = agencyName;
        this.agentList = new ArrayList<>();
    }

    public void addAgent(Agent agent) {
        this.agentList.add(agent);
    }
    
    public void printAgentList() {
        if (agentList.isEmpty()) {
            System.out.println("No agents available in the list.");
        } else {
            System.out.println("Agent List:");
            for (Agent agent : agentList) {
                try {
                    System.out.println(agent.getName());
                } catch (RemoteException e) {
                    UserInterface.displayError("printAgentList error", e);
                }
            }
        }
    }
    
    public String getName() {
        return this.agencyName;
    }

    public String getId() {
        return this.agencyId;
    }

    public String generateUniqueCode() {
        return UUID.randomUUID().toString();
    }

    // Métodos para lidar com agentes
}
