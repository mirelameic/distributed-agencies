public class AgentRegistry {
    private ServiceRegistry serviceRegistry;

    public AgentRegistry(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    public void registerAgent(String agentId, String agencyId) {
        serviceRegistry.registerAgent(agentId, agencyId);
        System.out.println("Agent registered successfully!");
    }

    public void migrateAgent(String agentId, String destinationAgencyId) {
        serviceRegistry.migrateAgent(agentId, destinationAgencyId);
        System.out.println("Agent migrated successfully!");
    }
}
