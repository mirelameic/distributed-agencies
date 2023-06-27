import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Agent extends Remote {
    void start() throws RemoteException;
}
