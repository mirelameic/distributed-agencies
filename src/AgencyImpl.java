import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.UUID;

public class AgencyImpl extends UnicastRemoteObject implements Agency {
    private String agencyId;
    private String agencyName;

    public AgencyImpl(String agencyName) throws RemoteException {
        this.agencyId = generateUniqueCode();
        this.agencyName = agencyName;
    }

    private String generateUniqueCode(){
        return UUID.randomUUID().toString();
    }
}
