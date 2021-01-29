package de.hft_stuttgart.ip1;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class AtFront {
    /**
     Transform the given input according to the algorithm given above for transformation
     */
    public static short[] transform(byte []input) {
        /* banane
        // ..........abcdefghijklmnopqrstuvwxyz
        // 97 => b..........acdefghijklmnopqrstuvwxyz
        // 97 => ab...........cdefghijklmnopqrstuvwxyz
        // 109 => nab...........cdefghijklmopqrstuvwxyz
        // 1 => anb...........cdefghijklmopqrstuvwxyz
        // 1 => nab...........cdefghijklmopqrstuvwxyz
        // 101 => enab...........cdefghijklmopqrstuvwxyz
        //   ..........abcdefghijklmnopqrstuvwxyz
        // 97 = b => b..........acdefghijklmnopqrstuvwxyz
        // 97 = a => ab...........cdefghijklmnopqrstuvwxyz
        109 = n => nab...........cdefghijklmopqrstuvwxyz
        1 = a => anb...........cdefghijklmopqrstuvwxyz
        1 = n => nab...........cdefghijklmopqrstuvwxyz
        101 = e => enab...........cdefghijklmopqrstuvwxyz
        */

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

    /**
     Transform the given input according to the algorithm given above for retransformation
     */
    public static byte[] retransform(short [] input) {
        /* banane
        ..........abcdefghijklmnopqrstuvwxyz
        97 = b => b..........acdefghijklmnopqrstuvwxyz
        97 = a => ab...........cdefghijklmnopqrstuvwxyz
        109 = n => nab...........cdefghijklmopqrstuvwxyz
        1 = a => anb...........cdefghijklmopqrstuvwxyz
        1 = n => nab...........cdefghijklmopqrstuvwxyz
        101 = e => enab...........cdefghijklmopqrstuvwxyz
        */

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

        return ergebniss;


    }
}
