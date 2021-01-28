package de.hft_stuttgart.ip1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunLength {
    public final static int RLEA = 0;
    public final static int RLEB = 1;

    /**
     * Transform the given input according to the algorithm given above for transformation
     */
    public static short[] transform(short[] input) {
        var ergebniss = new LinkedList<Short>();
        int nullCounter = 0;
        for (short input2:input) {
            if(input2>0){
                while(nullCounter>0){
                    if(nullCounter%2 == 1){
                        ergebniss.add((short) RLEA);
                    }else{
                        ergebniss.add((short) RLEB);
                    }
                    nullCounter--;
                    nullCounter/=2;
                }
                ergebniss.add((short)(input2+1));
            }else{
                nullCounter++;
            }
        }
        short [] ergebnissArray = new short[ergebniss.size()];
        for ( int i= 0; i<ergebniss.size();i++) {
            ergebnissArray[i] = ergebniss.get(i);
        }
        return  ergebnissArray;
        /*
        for(int i = 0;){
            var result = new ArrayList<Integer>();
            while(input>0){
                if(input%2 == 1){
                    result.add(RLEA);
                }else{
                    result.add(RLEB);
                }
                input--;
                input/=2;
            }
        }


        */
    }

    /**
     * Transform the given input according to the algorithm given above for retransformation
     */
    public static short[] retransform(short[] input) {
        var ergebniss = new LinkedList<Short>();
        int nullCounter = 0;
        short bit = 1;
        for (short input2:input) {
            if(input2>1){
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
        /*
        short bit = 1;
        short ergebniss = 0;
        for(short s : input){
            if(s==RLEA){
                ergebniss += bit;
            }else{
                ergebniss += 2*bit;
            }
            bit <<= 1;
        }
        return ergebniss;
         */
    }

}