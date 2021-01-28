package Client;

import SharedInterface.FileServer;
import SharedInterface.FileTransfer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RMIClient {

    public RMIClient() {}
    Scanner in = new Scanner(System.in);
    public void startClient() throws RemoteException, NotBoundException {

        System.out.println("IP eingeben.");
        //localhost / lida2.fkc.hft-stuttgart.de
        String iP = in.nextLine();
        //1099 / 28765
        System.out.println("Port eingeben.");
        int port = in.nextInt();


        Registry registry = LocateRegistry.getRegistry(iP, port);

        //FileServer vom server laden
        FileServer fileServer = (FileServer) registry.lookup(FileServer.class.getName());


        System.out.println("Bitte Nutzernamen eingeben");
        //admin /
        String user;
        user = in.nextLine();
        user = in.nextLine();
        System.out.println("Bitte Password eingeben");
        //admin /
        String password = in.nextLine();


        //FileServer vom server laden
        FileTransfer fileTransfer = fileServer.getTransfer(user,password);
        //überprüfung der korektheit der Passwörter;
        if(fileTransfer != null){
            //auswahl der gewünschten tätigkeit
            loop: while (true){
                System.out.println("Wähle einen befehl mit den folgenden nummern aus:" +
                        "\n1. Liste alle auf dem server existenten files auf." +
                        "\n2. Sende eine Eingabe an den Server zum verschlüsselten abspeichern." +
                        "\n3. Empfange einen Text vom Server auf deinem Gerät" +
                        "\n4. Lösche einen gespeicherten Text vom Server" +
                        "\n5. Beende die vorhandene Verbindung und schlist den Client");

                String input = in.nextLine();
                switch (input){
                    case "1":
                        //fileTransfer.listFiles();
                        break;
                    case "2":
                        sendFile(fileTransfer);
                        break;
                    case "3":
                        //fileTransfer.receiveFile();
                        break;
                    case "4":
                        //fileTransfer.deleteFile();
                        break;
                    case "5":
                        break loop;
                    default:
                        System.out.println("Bitte eine der genanten möglichkeiten Wählen.");
                        break;
                }
            }
        }else{
            System.out.println("Fehlerhafte Anmeldedaten schlisse Client");
        }



    }

    private void sendFile(FileTransfer fileTransfer) {

    }




}
