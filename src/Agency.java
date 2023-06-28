import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Agency extends Remote{
    public void addAgent(Agent agent) throws RemoteException;
    public void printAgentList() throws RemoteException;
    public String getName() throws RemoteException;
    public String getId() throws RemoteException;
    public String generateUniqueCode() throws RemoteException;
}
