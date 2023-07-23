package Agency;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Agent.Agent;

public interface Agency extends Remote{
    public void addAgent(Agent agent) throws RemoteException;
    public void moveAgent(Agent agent, String destinationAgencyName) throws RemoteException;
    public void removeAgent(Agent agent) throws RemoteException;
    public String getID() throws RemoteException;
    public String getName() throws RemoteException;
    public List<Agent> getAgentsList() throws RemoteException;
    public String generateUniqueCode() throws RemoteException;
}
