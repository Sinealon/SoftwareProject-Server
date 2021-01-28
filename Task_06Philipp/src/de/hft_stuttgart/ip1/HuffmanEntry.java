package de.hft_stuttgart.ip1;

import java.util.Arrays;

public class HuffmanEntry implements Comparable<HuffmanEntry> {
    HuffmanEntry left;
    HuffmanEntry right;
    byte[] data;
    int count;

    public HuffmanEntry(HuffmanEntry left, HuffmanEntry right) {
        this.left = left;
        this.right = right;
        data = new byte[left.data.length+right.data.length];
        count = left.count+right.count;
        for(int i = 0;i<left.data.length+right.data.length;i++){
            if(right.count>=left.count){
                if(i<right.data.length){
                    data[i] = right.data[i];
                }else{
                    data [i] = left.data[i-right.data.length];
                }
            }else {
                if (i < left.data.length) {
                    data[i] = left.data[i];
                } else {
                    data[i] = right.data[i - left.data.length];
                }
            }
        }
        Arrays.sort(data);
    }

    public HuffmanEntry(byte data, int count) {
        this.data = new byte[1];
        this.data[0] = data;
        this.count = count;
        this.left = null;
        this.right = null;
    }

    public boolean isLeft(byte value) {
        if (left == null){
            return false;
        }
        for (byte data2 : left.data) {
            if(data2 == value){
                return true;
            }
        }
        return false;
    }

    public boolean isRight(byte value) {
        if (right == null){
            return false;
        }
        for (byte data2 : right.data) {
            if(data2 == value){
                return true;
            }
        }
        return false;
    }

    public int compareTo(HuffmanEntry other) {
        return (this.count-other.count!=0)? this.count-other.count:(this.data.length-other.data.length==0)? this.data[0]-other.data[0]:this.data.length-other.data.length;
    }
}