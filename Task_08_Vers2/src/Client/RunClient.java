package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Arrays;

public class RunClient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIClient client = new RMIClient();
        client.startClient();

    }
}
