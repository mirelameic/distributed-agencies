public class AgencyRegistry {
    private ServiceRegistry serviceRegistry;

    public AgencyRegistry(ServiceRegistry serviceRegistry) {
        this.serviceRegistry = serviceRegistry;
    }

    public void registerAgency(String agencyId, String machineName) {
        serviceRegistry.registerAgency(agencyId, machineName);
        System.out.println("Agency registered successfully!");
    }
}
