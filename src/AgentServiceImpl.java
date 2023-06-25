import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AgentServiceImpl extends UnicastRemoteObject implements AgentService {
    private String agentId;
    private ServiceRegistry serviceRegistry;

    public AgentServiceImpl(String agentId, ServiceRegistry serviceRegistry) throws RemoteException {
        this.agentId = agentId;
        this.serviceRegistry = serviceRegistry;
    }

    @Override
    public void start() throws RemoteException {
        System.out.println("Agent started: " + agentId);
        System.out.println("Listening for messages...");
        // Lógica para ouvir e processar mensagens aqui
    }
}
