package Agency;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

import Agent.Agent;
import NamingService.NamingService;
import User.UserInterface;

public class AgencyImpl extends UnicastRemoteObject implements Agency {
    private String agencyID;
    private String agencyName;
    private int agencyPort;
    private LinkedList<Agent> agentsList;
    private Map<String, LinkedBlockingQueue<Message>> receivedMessages;
    private Map<String, LinkedBlockingQueue<Message>> answeredMessages;
    
    public AgencyImpl(String agencyName, int agencyPort) throws RemoteException {
        super();
        this.agencyID = generateUniqueCode();
        this.agencyName = agencyName;
        this.agencyPort = agencyPort;
        this.agentsList = new LinkedList<Agent>();
        this.receivedMessages = new ConcurrentHashMap<String, LinkedBlockingQueue<Message>>();
        this.answeredMessages = new ConcurrentHashMap<String, LinkedBlockingQueue<Message>>();
    }

    @Override
    public void addAgent(Agent agent) throws RemoteException{ // esse parametro provavelmente errado
        this.agentsList.add(agent);
        // 01. Gera um ID para o novo agente (enunciado fala q quem cria id eh agencia)
        // 02. Cria uma thread para este novo agente
        // 03. Adiciona o novo agente no serviço de nomes
        // 04. Roda o "file" na nova thread
        // 05. Retorna o ID
    }
    
    @Override
    public void moveAgent(Agent agent, String destinationAgencyName) throws RemoteException {
        agentsList.remove(agent);
        try {
            Agency destinationAgency = (Agency) Naming.lookup(destinationAgencyName);
            destinationAgency.addAgent(agent);
            NamingService namingService = (NamingService) Naming.lookup("rmi://localhost:8080/namingservice");
            namingService.moveAgent(agent.getId(), destinationAgency.getID());
        } catch (Exception e) {
            UserInterface.displayError("Error while moving agent.", e);
        }
    }

    @Override
    public void removeAgent(Agent agent) throws RemoteException{
        // pega id do objeto
        // para thread dele
        // excluir lista de agentslist
        // excluir do serviço de nome
    }

    @Override
    public String getID() throws RemoteException{
        return this.agencyID;
    }

    @Override
    public String getName() throws RemoteException{
        return this.agencyName;
    }


    @Override
    public List<Agent> getAgentsList() throws RemoteException{
        return this.agentsList;
    }

    @Override
    public String generateUniqueCode() throws RemoteException{
        return UUID.randomUUID().toString();
    }
    
}
