package NamingService;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface NamingService extends Remote {
    public void registerAgency(String agencyId, String agencyName) throws RemoteException;
    public void removeAgency(String agencyId) throws RemoteException;
    public void moveAgent(String agentId, String actualAgencyId) throws RemoteException;
    public Map<String, String> getAgencies() throws RemoteException;
    public Map<String, String> getAgentsRelatedToAgencies() throws RemoteException;
}
