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

    public String getName(){
        return this.agentName;
    }

    public String getId(){
        return this.agentId;
    }

    public String generateUniqueCode(){
        return UUID.randomUUID().toString();
    }
}
