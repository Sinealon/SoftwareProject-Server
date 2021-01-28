package Server;

import SharedInterface.FileServer;
import SharedInterface.FileTransfer;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ServerImplementation extends UnicastRemoteObject implements FileServer, FileTransfer{
    HashMap <String,byte[]> speicher;
    public ServerImplementation() throws RemoteException {
        speicher = new HashMap<String,byte[]>();
    }

    @Override
    public FileTransfer getTransfer(String user, String password) throws RemoteException {

        if (user != null && password != null) {
            if ((user.equals("admin")) && (password.equals("admin"))) {
                return this;
            }
        }
        return null;
    }


    @Override
    public String[] listFiles(String pattern) throws RemoteException {
        return new String[0];
    }

    @Override
    public void sendFile(String name, byte[] data) throws RemoteException {
        speicher.put(name,data);
        System.out.println(name+" Gespeichert");
    }

    @Override
    public byte[] receiveFile(String name) throws RemoteException {
        var data = speicher.get(name);
        System.out.println(name+" Wurde ausgelesen");
        return data;
    }

    @Override
    public boolean deleteFile(String name) throws RemoteException {
        return false;
    }


}
