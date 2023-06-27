import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

public class AgentImpl extends UnicastRemoteObject implements Agent {
    private String agentId;
    private NamingService serviceRegistry;

    public AgentImpl(NamingService serviceRegistry) throws RemoteException {
        this.agentId = generateUniqueCode();
        this.serviceRegistry = serviceRegistry;
    }

    @Override
    public void start() throws RemoteException {
        System.out.println("Agent started: " + agentId);
        System.out.println("Listening for messages...");
        // Lógica para ouvir e processar mensagens aqui
    }

    private String generateUniqueCode(){
        return UUID.randomUUID().toString();
    }
}
