import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private static Agency agency;

    public static void main(String[] args) {
        try {
            listAllAgencys();
            boolean running = true;

            while (running) {
                String command = UserInterface.getUserCommand();

                // if (command.startsWith("bind ")) {
                //     String newRepositoryName = command.substring(5);
                //     bindRepository(newRepositoryName);
                // } else if (command.equals("listp")) {
                //     listParts();
                // } else if (command.equals("lists")) {
                //     listAllServers();
                // } else if (command.startsWith("getp ")) {
                //     String partCode = command.substring(5);
                //     getPart(partCode);
                // } else if (command.equals("showp")) {
                //     showPart();
                // } else if (command.equals("showsub")){
                //     showSubParts();
                // } else if (command.equals("clearlist")) {
                //     clearSubPartsList();
                // } else if (command.equals("addsubpart")) {
                //     addSubPart();
                // } else if (command.equals("addp")) {
                //     addPart();
                // }else if (command.equals("showinfo")){
                //     showRepInfo();
                // } else if (command.equals("quit")) {
                //     UserInterface.displayMessage("Client terminated.");
                //     System.exit(0);
                // } else {
                //     UserInterface.displayMessage("Invalid command.");
                // }
            }
        } catch (Exception e) {
            UserInterface.displayError("Client exception.", e);
        }





    //     try {
    //         // Lendo o arquivo .class do agente como um array de bytes
    //         byte[] agentCode = Files.readAllBytes(Path.of("bin/Agent.class"));

    //         // Fazendo a chamada à agência para executar o agente
    //         // serviceRegistry.executeAgent(agentCode);
    //     } catch (IOException e) {
    //         System.out.println("Failed to read agent file: " + e.getMessage());
    //         System.exit(1);
    //     }
    // }


    }

    public static void listAllAgencys() throws Exception{
        Registry registry = LocateRegistry.getRegistry();
        String[] registryList = registry.list();
        UserInterface.displayMessage("Available Agencys: ");
        for(String element : registryList){
            UserInterface.displayMessage(element);
        }
    }

}