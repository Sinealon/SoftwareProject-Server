package Client;

import SharedInterface.FileTransfer;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class SendFile {
    Scanner in = new Scanner(System.in);
    public SendFile(FileTransfer fileTransfer) {
        System.out.println("Bitte Namen des zu speichernden Textes angeben: ");

        String name = in.next();
        System.out.print("Bitte gieb den zu komprimieren und abzuspeichernden Text ein: ");
        String komprimiren = in.next();
        String burrowsWheeler = burrowsWheelerTransform(komprimiren);
        short[] moveToFront = moveToFrontTransform(burrowsWheeler);
        byte[] runLength = runLengthTransform(moveToFront);
        byte[] huffmen = HuffmenTransform(runLength);




        try {
            fileTransfer.sendFile(name,huffmen);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    private String burrowsWheelerTransform(String komprimiren) {

        ArrayList<String> list = new ArrayList <String>();
        komprimiren = komprimiren + '\uFFED';
        list.add(komprimiren.substring(1)+komprimiren.charAt(0));
        komprimiren = komprimiren.substring(1)+komprimiren.charAt(0);
        while(komprimiren.charAt(komprimiren.length()-1) !=  '\uFFED'){
            list.add(komprimiren.substring(1)+komprimiren.charAt(0));
            komprimiren = komprimiren.substring(1)+komprimiren.charAt(0);
        }

        list.sort(String::compareTo);
        String ergebnisTask04 = "";


        for (String letzerBustabe : list) {
            ergebnisTask04 = ergebnisTask04+letzerBustabe.charAt(letzerBustabe.length()-1);
        }

        return ergebnisTask04;

    }


    private short[] moveToFrontTransform(String komprimiren) {
        byte[] input = komprimiren.getBytes();
        var gefundenliste = new LinkedList<Byte>();
        short[] ergebnisAtFront = new short[input.length];
        //i = index des zu durschreitenden byte aus input
        index: for(int i = 0;i<input.length;i++){
            short zuverschieben = 0;
            // überprüfung ob bereits aufgetreten
            for (short k = 0;k<gefundenliste.size();k++){
                if(gefundenliste.get(k).byteValue() == input[i]){
                    ergebnisAtFront[i] = k;
                    byte speicher = gefundenliste.get(k);
                    gefundenliste.remove(k);
                    gefundenliste.addFirst(speicher);
                    continue index;
                }else if(input[i]<gefundenliste.get(k).byteValue()){
                    zuverschieben++;
                }
            }
            //fügt bei nochnicht gefundenen hinzu
            ergebnisAtFront[i] =(short)(input[i]+zuverschieben);
            gefundenliste.addFirst(input[i]);
        }

        return ergebnisAtFront;
    }


    public static byte[] runLengthTransform(short[] input) {
        final int RLEA = 0;
        final int RLEB = 1;
        var ergebniss = new LinkedList<Byte>();
        int nullCounter = 0;
        for (short input2 : input) {
            if (input2 > 0) {
                while (nullCounter > 0) {
                    if (nullCounter % 2 == 1) {
                        ergebniss.add((byte) RLEA);
                    } else {
                        ergebniss.add((byte) RLEB);
                    }
                    nullCounter--;
                    nullCounter /= 2;
                }
                ergebniss.add((byte) (input2 + 1));
            } else {
                nullCounter++;
            }
        }
        byte[] ergebnissArray = new byte[ergebniss.size()];
        for (int i = 0; i < ergebniss.size(); i++) {
            ergebnissArray[i] = ergebniss.get(i);
        }
        return ergebnissArray;
    }

    public static byte[] HuffmenTransform(byte [] input) {
        return new HuffmanTree(HuffmanDistribution.getDistribution(input)).encode(input);
    }


}