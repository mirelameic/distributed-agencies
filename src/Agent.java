public class Agent {
    private String agentId;
    private ServiceRegistry serviceRegistry;

    public Agent(String agentId, ServiceRegistry serviceRegistry) {
        this.agentId = agentId;
        this.serviceRegistry = serviceRegistry;
    }

    public void start() {
        System.out.println("Agent started: " + agentId);
        System.out.println("Listening for messages...");
        // Logic to listen for and process messages goes here
    }
}
