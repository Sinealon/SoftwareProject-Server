package Client;

public class HuffmanDistribution {

    public static int[] getDistribution(byte[] input)
    {
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
