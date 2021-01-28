package de.hft_stuttgart.ip1;

public class HuffmanDistribution {
    public static int[] getDistribution(byte[] input) {
        int [] ergebniss = new int[256];
        for(int i = 0;i<input.length;i++){
            ergebniss[Byte.toUnsignedInt(input[i])]++;
        }
        return ergebniss;
    }
}
