package de.hft_stuttgart.ip1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunLength {
    public final static int RLEA = 0;
    public final static int RLEB = 1;

    /**
     * Transform the given input according to the algorithm given above for transformation
     */
    public static short[] transform(short[] input) {

        List<Short> result = new ArrayList<>();
        int countzero = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                if (countzero > 0) {
                    result.addAll(compri(countzero));
                    countzero = 0;
                }
                result.add((short) (input[i] + 1));
            } else {
                countzero++;
            }
        }
        result.addAll(compri(countzero));

        short realResult[] = new short[result.size()];
        for (int i = 0; i< realResult.length; i++){
            realResult[i] = result.get(i);
        }

        return realResult;
    }

private static List<Short> compri(int input){

        List<Short> result = new ArrayList<>();
            while (input > 0) {
                if (input % 2 == 1) {
                    result.add((short) RLEA);
                } else {
                    result.add((short) RLEB);
                }
                input--;
                input /= 2;
            }

        return result;
    }

    /**
     * Transform the given input according to the algorithm given above for retransformation
     */
    public static short[] retransform(short[] input) {

        List<Short> result = new ArrayList<>();
        List<Short> countzero = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if(input[i] <= 1){
                countzero.add(input[i]);
            }
            else{
                for(int c = 0, l = extrakt(countzero); c < l; c++){
                    result.add((short) 0);
                }
                countzero.clear();

                result.add((short)(input[i] - 1));
            }
        }
        for(int c = 0, l = extrakt(countzero); c < l; c++){
            result.add((short) 0);
        }

        short realResult[] = new short[result.size()];
        for (int i = 0; i< realResult.length; i++){
            realResult[i] = result.get(i);
        }

        return realResult;
    }

    private static short extrakt(List<Short> input){
        System.out.println("extrakt");
        short bit = 1;
        short result = 0;

        for(short s: input){
            if( s == RLEA){
                result += bit;
            }
            else{
                result += 2*bit;
            }
            bit <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        short[] input = new short[]{3,8,1, 0,0,0,0, 6, 5, 0,0, 7,2,9,0,0,0,0, 1, 0};
        var sss = transform(input);
        var ret = retransform(sss);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(ret));
    }
}

