package User;

import java.rmi.Naming;
import java.util.Map;

import Agency.Agency;
import NamingService.NamingService;

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
                if(command.equals("show-commands")){
                    showCommands();
                }else if (command.startsWith("bind ")) {
                    String agency = command.substring(5);
                    bindAgency(agency);
                } else if (command.equals("list-agencies")){
                    listAgencies();
                }else if (command.startsWith("create-agent ")){
                        
                } else if (command.equals("list-agents")){
                    //listAgents();
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
        UserInterface.printLine();
        UserInterface.displayMessage("'show-commands': Show vailable commands");
        UserInterface.displayMessage("'bind <agency_name>': Binds to the specified agency");
        UserInterface.displayMessage("'list-agencies': Lists all available agencies");
        UserInterface.displayMessage("'list-agents': Lists all available agents");
        UserInterface.displayMessage("'quit': Terminates the client");
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
        try {
            namingService = (NamingService) Naming.lookup("rmi://localhost:8080/namingservice");
            UserInterface.displayMessage("Connected to NamingService");
        } catch (Exception e) {
            UserInterface.displayError("bind NamingService Exception.", e);
        }
    }

    public static void listAgencies() {
        try {
            Map<String, String> agencies = namingService.getAgencies();
            UserInterface.printLine();
            UserInterface.displayMessage("Available Agencies:");
            for (Map.Entry<String, String> entry : agencies.entrySet()) {
                String agencyId = entry.getKey();
                String agencyName = entry.getValue();
                UserInterface.displayMessage("Agency: " + agencyName + " | ID: " + agencyId);
            }
            UserInterface.printLine();
        } catch (Exception e) {
            UserInterface.displayError("listAgencies Exception.", e);
        }
    }
}