package de.hft_stuttgart.ip1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Receiver extends Remote {
    void receive(String message) throws RemoteException;
}
