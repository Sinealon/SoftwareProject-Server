package Client;

import java.nio.charset.StandardCharsets;

public class HuffmanDistribution {

    public static int[] getDistribution()
    {
        byte[] input = new byte[256];
        for (byte i=-128;i<127;i++){
            input[i+128] = i;
        }
        input[255] = 127;
        int[] result = new int[256];

        for(byte i : input){
            if(i >= 0){
                result[i]++;
            }
            else{
                result[Math.abs(i) + 127]++;
            }
        }

        return result;
    }
}
