import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NamingService extends Remote {
    public void registerAgency(String agencyName, Agency agency) throws RemoteException;
    public Agency getAgency(String agencyName) throws RemoteException;
    public void removeAgency(String agencyName) throws RemoteException;    
}
