import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {
    private Map<String, String> agentRegistry;
    private Map<String, String> agencyRegistry;

    public ServiceRegistry() {
        agentRegistry = new HashMap<>();
        agencyRegistry = new HashMap<>();
    }

    public void registerAgent(String agentId, String agencyId) {
        agentRegistry.put(agentId, agencyId);
    }

    public void registerAgency(String agencyId, String machineName) {
        agencyRegistry.put(agencyId, machineName);
    }

    public void migrateAgent(String agentId, String destinationAgencyId) {
        if (agentRegistry.containsKey(agentId) && agencyRegistry.containsKey(destinationAgencyId)) {
            agentRegistry.put(agentId, destinationAgencyId);
        } else {
            System.out.println("Invalid source or destination agent!");
        }
    }

    public void sendMessage(String sourceAgentId, String destinationAgentId, String message) {
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

    public void startAgent(String agentId) {
        String agencyId = agentRegistry.get(agentId);

        if (agencyId != null) {
            AgencyThread agencyThread = new AgencyThread(new Agent(agentId, this));
            agencyThread.start();
        } else {
            System.out.println("Agent not found!");
        }
    }

    private class AgencyThread extends Thread {
        private Agent agent;

        public AgencyThread(Agent agent) {
            this.agent = agent;
        }

        @Override
        public void run() {
            agent.start();
        }
    }
}
