import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

public class AgentImpl extends UnicastRemoteObject implements Agent {
    private String agentId;
    private String agentName;

    public AgentImpl(String agentName) throws RemoteException {
        this.agentId = generateUniqueCode();
        this.agentName = agentName;
    }

    @Override
    public void start() throws RemoteException {
        System.out.println("Agent started: " + agentId);
        System.out.println("Listening for messages...");
    }

    @Override
    public String getName() throws RemoteException {
        return this.agentName;
    }

    @Override
    public String getId() throws RemoteException {
        return this.agentId;
    }

    @Override
    public String generateUniqueCode() throws RemoteException {
        return UUID.randomUUID().toString();
    }
}
