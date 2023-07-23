package Agent;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Agent extends Remote {
    void start() throws RemoteException;
    public String getName() throws RemoteException;
    public String getId() throws RemoteException;
    public String generateUniqueCode() throws RemoteException;
}
