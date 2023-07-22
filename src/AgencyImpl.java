import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AgencyImpl extends UnicastRemoteObject implements Agency {
    // todo: conectar ao serviço de nome pra conseguir registrar
    private String agencyId;
    private String agencyName;
    private List<Agent> agentList;

    public AgencyImpl(String agencyName) throws RemoteException {
        this.agencyId = generateUniqueCode();
        this.agencyName = agencyName;
        this.agentList = new ArrayList<>();
    }

    public void addAgent(Agent agent) { // esse parametro provavelmente errado
        this.agentList.add(agent);
        // 01. Gera um ID para o novo agente (enunciado fala q quem cria id eh agencia)
        // 02. Cria uma thread para este novo agente
        // 03. Adiciona o novo agente no serviço de nomes
        // 04. Roda o "file" na nova thread
        // 05. Retorna o ID
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
    
    public void moveAgent(Agent agent, String destinationAgencyName) throws RemoteException {
        agentList.remove(agent);
        try {
            Agency destinationAgency = (Agency) Naming.lookup(destinationAgencyName);
            destinationAgency.addAgent(agent);
            NamingService namingService = (NamingService) Naming.lookup("rmi://localhost:8080/namingservice");
            namingService.moveAgent(agent.getId(), destinationAgency.getId());
        } catch (Exception e) {
            UserInterface.displayError("Error while moving agent.", e);
        }
    }

    public void removeAgent(Agent agent) {
        // pega id do objeto
        // para thread dele
        // excluir lista de agentlist
        // excluir do serviço de nome
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
}
