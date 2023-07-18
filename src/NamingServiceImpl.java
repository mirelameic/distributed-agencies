import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class NamingServiceImpl extends UnicastRemoteObject implements NamingService {
    // alterações
    // map com id e name, sem a agencia em si
    // para os metodos de alteração são passados o id da agencia, e o name eh considerado endereço a ser encontrado
    // adição dos métodos moveAgent e getAgencies
    // map de agentes dentro das agencias (id do agente, id da agencia)
    private Map<String, String> registeredAgencies;
    private Map<String, String> agentsRelatedToAgencies;

    public NamingServiceImpl() throws RemoteException {
        registeredAgencies = new HashMap<>();
    }

    @Override
    public void registerAgency(String agencyId, String agencyName) throws RemoteException {
        registeredAgencies.put(agencyId, agencyName);
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
        return agentsRelatedToAgencies;
        // retorna os agentes e as agencias - pra achar o endereço de uma agencia especifica, dar getagency com id da agencia que apareceu
    }
}
