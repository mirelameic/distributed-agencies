import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    static Agency currentAgency;
    static NamingService namingService;
    public static void main(String[] args) {
        try {
            bindNamingService();
            boolean running = true;
            String command;
            showCommands();
            while (running) {
                command = UserInterface.getUserCommand();
                if(command.equals("show commands")){
                    showCommands();
                }else if (command.startsWith("bind ")) {
                    String newAgencyName = command.substring(5);
                    bindAgency(newAgencyName);
                } else if (command.equals("listagencies")){
                    listAllAgencys();
                } else if (command.equals("listagents")){
                    listAgents();
                } else if (command.equals("quit")) {
                    UserInterface.displayMessage("Client terminated.");
                    running = false;
                } else {
                    UserInterface.displayMessage("Invalid command.");
                }
            }
        } catch (Exception e) {
            UserInterface.displayError("Client exception.", e);
        }
    }

    private static void showCommands() {
        UserInterface.printLine();
        UserInterface.displayMessage("Available commands:");
        UserInterface.displayMessage("show commands - Show vailable commands");
        UserInterface.displayMessage("bind <agency_name> - Binds to the specified agency");
        UserInterface.displayMessage("listagencies - Lists all available agencies");
        UserInterface.displayMessage("listagents - Lists all available agents");
        UserInterface.displayMessage("quit - Terminates the client");
        UserInterface.printLine();
    }


    private static void bindAgency(String agencyName) {
        try {
            currentAgency = (Agency) Naming.lookup(agencyName);
            UserInterface.displayMessage("Connected to agency: " + agencyName);
        } catch (Exception e) {
            UserInterface.displayError("bind Exception.", e);
        }
    }

    private static void bindNamingService() {
        // NamingService namingService;
        try {
            // namingService = (NamingService) Naming.lookup("NamingService");
            NamingService service = (NamingService) Naming.lookup("rmi://localhost:8080/namingservice");
            UserInterface.displayMessage("Connected to NamingService");
        } catch (Exception e) {
            UserInterface.displayError("bind Exception.", e);
            e.printStackTrace();
        }
    }

    public static void listAllAgencys() throws Exception{
        Registry registry = LocateRegistry.getRegistry();
        String[] registryList = registry.list();
        UserInterface.printLine();
        UserInterface.displayMessage("Available Agencies: ");
        for(String element : registryList){
            UserInterface.displayMessage(element);
        }
    }

    public static void listAgents() throws Exception{
        namingService.getAgencies();
    }
}