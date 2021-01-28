package de.hft_stuttgart.ip1;

import java.util.ArrayList;
import java.util.List;

public class AtFront {
    /**
     Transform the given input according to the algorithm given above for transformation
     */
    public static short[] transform(byte []input) {
        List<Byte> ascii = new ArrayList<>();

        for (int c=0; c<128; c++) {
            ascii.add((byte) c);
        }

        short[] result = new short[input.length];
        for (int i = 0; i < input.length; i++){
            for (int w = 0; w < ascii.size(); w++){
                if(input[i] == ascii.get(w)){
                    result[i] = (byte) w;
                    ascii.remove(w);
                    ascii.add(0, input[i]);
                }
            }
        }

        return result;
    }

    /**
     Transform the given input according to the algorithm given above for retransformation
     */
    public static byte[] retransform(short [] input) {
        List<Byte> ascii = new ArrayList<>();

        for (int c=0; c<128; c++) {
            ascii.add((byte) c);
        }

        byte[] result = new byte[input.length];
        for (int i = 0; i < input.length; i++){
            result[i] = ascii.get(input[i]);
            ascii.add(0, ascii.get(input[i]));
            ascii.remove(input[i] + 1);
        }

        return result;
    }
}
