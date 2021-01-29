package Client;

import SharedInterface.FileTransfer;

import java.rmi.RemoteException;

public class DeleteFiles {
    public DeleteFiles(FileTransfer fileTransfer, String [] listedFiles) {
        for (int i=0;i <listedFiles.length;i++) {
            try {
                fileTransfer.deleteFile(listedFiles[i]);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }


    }
    public static String getIP(){return "";}
    public static int getPort(){return 0;}

}
