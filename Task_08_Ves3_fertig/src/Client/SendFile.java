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
        String name = "";
        name = in.next();

        in.nextLine();  // Consume newline left-over

        System.out.print("Bitte gieb den zu komprimieren und abzuspeichernden Text ein: ");
        String komprimiren = in.nextLine();

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
        byte[] input = komprimiren.getBytes(StandardCharsets.UTF_8);
        boolean [] vorzeichenWechsel = new boolean[input.length];
        for(int i = 0;i<input.length;i++) {
            if (input[i] < 0) {
                vorzeichenWechsel[i] = true;
                input[i] = (byte) (input[i]*-1);
            }
        }

        var gefundenliste = new LinkedList<Byte>();
        short [] ergebniss = new short[input.length];
        //i = index des zu durschreitenden byte aus input
        index: for(int i = 0;i<input.length;i++){
            short zuverschieben = 0;
            // überprüfung ob bereits aufgetreten
            for (short k = 0;k<gefundenliste.size();k++){
                if(gefundenliste.get(k).byteValue() == input[i]){
                    ergebniss[i] = k;
                    byte speicher = gefundenliste.get(k);
                    gefundenliste.remove(k);
                    gefundenliste.addFirst(speicher);
                    continue index;
                }else if(input[i]<gefundenliste.get(k).byteValue()){
                    zuverschieben++;
                }
            }
            //fügt bei nochnicht gefundenen hinzu
            ergebniss[i] =(short)(input[i]+zuverschieben);
            gefundenliste.addFirst(input[i]);
        }

        for(int i = 0;i<input.length;i++) {
            if (vorzeichenWechsel[i]) {
                ergebniss[i] = (byte) (ergebniss[i]*-1);
            }
        }


        return ergebniss;
    }


    public static byte[] runLengthTransform(short[] input) {
        final int RLEA = 0;
        final int RLEB = 1;
        var ergebniss = new LinkedList<Byte>();
        int nullCounter = 0;
        for (short input2:input) {
            if(input2!=0){
                while(nullCounter>0){
                    if(nullCounter%2 == 1){
                        ergebniss.add((byte) RLEA);
                    }else{
                        ergebniss.add((byte) RLEB);
                    }
                    nullCounter--;
                    nullCounter/=2;
                }
                ergebniss.add((byte)(input2+1));
            }else{
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
        return new HuffmanTree(HuffmanDistribution.getDistribution()).encode(input);
    }


}
