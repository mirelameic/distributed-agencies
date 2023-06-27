import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NamingService extends Remote {
    void registerAgent(String agentId, String agencyId) throws RemoteException;
    void registerAgency(String agencyId, String machineName) throws RemoteException;
    void migrateAgent(String agentId, String destinationAgencyId) throws RemoteException;
    void sendMessage(String sourceAgentId, String destinationAgentId, String message) throws RemoteException;
    void executeAgent(byte[] agentCode) throws RemoteException;
    Class<?> defineAgentClass(byte[] agentCode) throws Exception;
    void startAgent(String agentId) throws RemoteException;
}
