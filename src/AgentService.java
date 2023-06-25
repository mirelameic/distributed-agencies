import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AgentService extends Remote {
    void start() throws RemoteException;
}
