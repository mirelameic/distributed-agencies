import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class NamingServiceImpl extends UnicastRemoteObject implements NamingService {
    private Map<String, Agency> registeredAgencies;

    public NamingServiceImpl() throws RemoteException {
        registeredAgencies = new HashMap<>();
    }

    @Override
    public void registerAgency(String agencyName, Agency agency) throws RemoteException {
        registeredAgencies.put(agencyName, agency);
    }

    @Override
    public Agency getAgency(String agencyName) throws RemoteException {
        return registeredAgencies.get(agencyName);
    }

    @Override
    public void removeAgency(String agencyName) throws RemoteException {
        registeredAgencies.remove(agencyName);
    }
}
