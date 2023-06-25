public class ExampleUsage {
    public static void main(String[] args) {
        ServiceRegistry serviceRegistry = new ServiceRegistry();

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
