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
        AgencyRegistry agencyRegistry = new AgencyRegistry(serviceRegistry);
        agencyRegistry.registerAgency(agencyId, machineName);
    }

    public void registerAgent(String agentId) {
        AgentRegistry agentRegistry = new AgentRegistry(serviceRegistry);
        agentRegistry.registerAgent(agentId, agencyId);
    }

    public void migrateAgent(String agentId, String destinationAgencyId) {
        AgentRegistry agentRegistry = new AgentRegistry(serviceRegistry);
        agentRegistry.migrateAgent(agentId, destinationAgencyId);
    }
}
