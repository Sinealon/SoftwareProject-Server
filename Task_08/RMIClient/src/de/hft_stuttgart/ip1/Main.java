package de.hft_stuttgart.ip1;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {

        Scanner in = new Scanner(System.in);

        System.out.println("IP eingeben.");
        String iP = in.nextLine();

        System.out.println("Port eingeben.");
        int port = in.nextInt();

        System.out.println("Starting the Client");
        ReceiverImpl receiver = new ReceiverImpl();
        String userName = null, password = null;

        UnicastRemoteObject.exportObject((Remote) receiver, 0);
        FileServer authentication = null;
        try {

        Registry registry = LocateRegistry.getRegistry(iP, port);

          //  sender.sendMessage(line);
            authentication = (FileServer) registry.lookup(FileServer.class.getName());

            FileTransfer status = authentication.getTransfer(userName, password);

            /*
            while ( true ) {
                Scanner sc = new Scanner(System.in);
                String line = sc.nextLine();
                if (line == null || line.strip().length() == 0) {
                    break;
                }
            }
            UnicastRemoteObject.unexportObject(receiver, true);
            */
        }
        catch (RemoteException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (NotBoundException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
