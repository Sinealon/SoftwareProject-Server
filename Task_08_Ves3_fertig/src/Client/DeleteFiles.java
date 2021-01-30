package Client;

import SharedInterface.FileTransfer;

import java.rmi.RemoteException;
import java.util.Scanner;

public class DeleteFiles {
    public DeleteFiles(FileTransfer fileTransfer) throws RemoteException {

        Scanner in = new Scanner(System.in);
        System.out.println("Wollen sie ALLE Files (1)\noder ein bestimmtes File Löschen(2)");
        var auswahl = in.nextInt();

        switch (auswahl){
            case 1:
                var allFiles = fileTransfer.listFiles("");
                for(String file: allFiles){
                    try {
                        fileTransfer.deleteFile(file);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                System.out.println("\nBitte geben Sie den Namen des Files an:");
                var name = in.next();

                try {
                    fileTransfer.deleteFile(name);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Falsche Eingabe");
                break;
        }
    }

}
