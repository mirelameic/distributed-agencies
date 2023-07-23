import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class NamingServiceImpl extends UnicastRemoteObject implements NamingService {
    private Map<String, String> registeredAgencies;
    private Map<String, String> agentsRelatedToAgencies;

    public NamingServiceImpl() throws RemoteException {
        registeredAgencies = new HashMap<>();
    }

    @Override
    public void registerAgency(String agencyId, String agencyName) throws RemoteException {
        registeredAgencies.put(agencyId, agencyName);
        System.out.println("Registered agency: " + agencyName);
    }

    @Override
    public String getAgency(String agencyId) throws RemoteException {
        return registeredAgencies.get(agencyId);
    }

    @Override
    public void removeAgency(String agencyId) throws RemoteException {
        registeredAgencies.remove(agencyId);
    }

    @Override
    public void moveAgent(String agentId, String actualAgencyId) throws RemoteException {
        agentsRelatedToAgencies.put(agentId, actualAgencyId);
    }

    @Override
    public Map<String, String> getAgencies() throws RemoteException {
        return registeredAgencies;
    }
}
