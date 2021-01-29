package Client;

import SharedInterface.FileTransfer;

import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.*;

public class ReceiveFile {
    public ReceiveFile(FileTransfer fileTransfer) {

        Scanner in = new Scanner(System.in);
        System.out.println("Bitte Namen des zu empfangenden Textes angeben: ");
        String name = in.next();

        try {
            var byteData = fileTransfer.receiveFile(name);
            if(byteData.length != 0) {
                var result = burrowsWheelerRetransform(byteData);
                System.out.println(result);
            }
            else{
                System.out.println("Kein Text gefunden");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private String burrowsWheelerRetransform(byte[] byteData) {
        var huffmen = new HuffmanTree(HuffmanDistribution.getDistribution()).decode(byteData);
        var runLength = runLengthRetransform(huffmen);
        String moveToFront = moveToFrontRetransform(runLength);

        char[] sortarray = moveToFront.toCharArray();
        int[] wiederholungen = new int[sortarray.length];

        wiederholungen[0] = 0;

        Arrays.sort(sortarray);

        for(int i = 1; i < sortarray.length; i++){
            if(sortarray[i] == sortarray[i-1]){
                wiederholungen[i] = wiederholungen[i-1] + 1;
            }
            else {
                wiederholungen[i] = 0;
            }
        }

        final String endMarker = "\uFFED";
        int index = moveToFront.indexOf(endMarker);

        String result = String.valueOf(sortarray[index]);

        while(true)
        {
            index = searchforIndex(wiederholungen[index], sortarray[index], moveToFront);

            if(sortarray[index] == endMarker.toCharArray()[0])
            {
                return result;
            }

            result += sortarray[index];
        }
    }

    private static int searchforIndex(int position, char target, String input){
        int curindex = 0;

        int index = 0;
        for(int i = 0; i <= position; i++){
            index = input.indexOf(target, curindex );
            curindex = index + 1;
        }

        return index;
    }

    private String moveToFrontRetransform(short[] input){

        boolean [] vorzeichenWechsel = new boolean[input.length];
        for(int i = 0;i<input.length;i++) {
            if (input[i] < 0) {
                vorzeichenWechsel[i] = true;
                input[i] = (byte) (input[i]*-1);
            }
        }


        var gefundenliste = new LinkedList<Short>();
        byte [] ergebniss = new byte[input.length];



        index: for(int i = 0;i<input.length;i++){
            int zuverschieben = 0;
            for (int k = 0; k<gefundenliste.size();k++){
                if(input[i]<gefundenliste.size()){
                    ergebniss[i] = gefundenliste.get(input[i]).byteValue();
                    short speicher = gefundenliste.get(input[i]);
                    gefundenliste.remove(input[i]);
                    gefundenliste.addFirst(speicher);
                    continue index;
                }else if(gefundenliste.get(k)>=input[i]){
                    zuverschieben++;
                }
            }
            ergebniss[i] = (byte) (input[i]-zuverschieben);
            gefundenliste.addFirst((short) (input[i]-zuverschieben));
        }


        for(int i = 0;i<input.length;i++) {
            if (vorzeichenWechsel[i]) {
                ergebniss[i] = (byte) (ergebniss[i]*-1);
            }
        }

        return new String(ergebniss);
    }

    private short[] runLengthRetransform(byte[] input){

        final int RLEA = 0;
        final int RLEB = 1;

        var ergebniss = new LinkedList<Short>();
        int nullCounter = 0;
        short bit = 1;
        for (short input2:input) {
            if(input2!=1 && input2!= 0){
                while(nullCounter>0){
                    ergebniss.add((short)0);
                    nullCounter--;
                }
                ergebniss.add((short)(input2-1));
                nullCounter = 0;
                bit = 1;
            }else if(input2==RLEA){
                nullCounter += bit;
                bit <<= 1;
            }else if(input2==RLEB){
                nullCounter += 2*bit;
                bit <<= 1;
            }
        }
        short [] ergebnissArray = new short[ergebniss.size()];
        for ( int i= 0; i<ergebniss.size();i++) {
            ergebnissArray[i] = ergebniss.get(i);
        }
        return  ergebnissArray;
    }
}
