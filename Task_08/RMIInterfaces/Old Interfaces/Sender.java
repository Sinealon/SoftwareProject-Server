package de.hft_stuttgart.ip1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sender extends Remote {
    void sendMessage(String message) throws RemoteException;
}
