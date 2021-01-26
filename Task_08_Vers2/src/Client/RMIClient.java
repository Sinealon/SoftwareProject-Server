package Client;

import SharedInterface.FileServer;
import SharedInterface.FileTransfer;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {

    private Object remote;
    public RMIClient() {}

    public void startClient() throws RemoteException, NotBoundException {
        Scanner in = new Scanner(System.in);

        System.out.println("IP eingeben.");
        String iP = in.nextLine();

        System.out.println("Port eingeben.");
        int port = in.nextInt();

        System.out.println("Starting the Client");
        Registry registry = LocateRegistry.getRegistry(iP, 1099);
        remote = registry.lookup(FileServer.class.getName());
        System.out.println("server started ");

    }

    FileTransfer getTransfer(String user, String password) throws RemoteException
    {
        return null;
    }


}
