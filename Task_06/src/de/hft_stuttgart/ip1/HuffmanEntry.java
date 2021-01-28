package de.hft_stuttgart.ip1;

import java.util.Arrays;

public class HuffmanEntry implements Comparable<HuffmanEntry> {
    HuffmanEntry left;
    HuffmanEntry right;
    byte data[];
    int count;

    public HuffmanEntry(HuffmanEntry left, HuffmanEntry right)
    {
        data = new byte[left.data.length + right.data.length];
        System.arraycopy(left.data, 0, data, 0, left.data.length);
        System.arraycopy(right.data, 0, data, left.data.length, right.data.length);
        Arrays.sort(this.data);

        //letze überprüfung ob alles stimmt
        if(left.compareTo(right) > 0){
            this.left = right;
            this.right = left;
        }
        else{
            this.left = left;
            this.right = right;
        }

        count = left.count + right.count;
    }

    public HuffmanEntry(byte data, int count)
    {
        this.data = new byte[]{data};
        this.count = count;
    }

    public boolean isLeft(byte value)
    {
        return Contains(left.data, value);
    }

    public boolean isRight(byte value)
    {
        return Contains(right.data, value);
    }

    public int compareTo(HuffmanEntry other)
    {
        int result = this.count - other.count;

        if(result != 0){
            return result;
        }

        result = this.data.length - other.data.length;

        if(result != 0){
            return result;
        }

        return this.data[0] - other.data[0];
    }

    public static boolean Contains(final byte[] array, final byte v)
    {
        boolean result = false;

        for(int i : array){
            if(i == v){
                result = true;
                break;
            }
        }

        return result;
    }

}
