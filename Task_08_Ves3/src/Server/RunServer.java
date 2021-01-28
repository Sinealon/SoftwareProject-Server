package Server;

import SharedInterface.FileServer;
import SharedInterface.FileTransfer;

import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {

    public static void main(String[] args) throws RemoteException {
        FileServer server = new ServerImplementation();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind(FileServer.class.getName(), server);

        /*FileTransfer transfer = new ServerImplementation();
        registry.rebind(FileTransfer.class.getName(), transfer);
        */
        System.out.println("Server Started");
    }

}
