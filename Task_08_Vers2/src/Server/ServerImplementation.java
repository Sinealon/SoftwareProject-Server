package Server;

import SharedInterface.FileServer;
import SharedInterface.FileTransfer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImplementation implements FileServer, FileTransfer {

   public ServerImplementation() throws RemoteException {
       UnicastRemoteObject.exportObject(this, 0);

   }

    @Override
    public FileTransfer getTransfer(String user, String password) throws RemoteException {
        return null;
    }

    @Override
    public String[] listFiles(String pattern) throws RemoteException {
        return new String[0];
    }

    @Override
    public void sendFile(String name, byte[] data) throws RemoteException {

    }

    @Override
    public byte[] receiveFile(String name) throws RemoteException {
        return new byte[0];
    }

    @Override
    public boolean deleteFile(String name) throws RemoteException {
        return false;
    }
}
