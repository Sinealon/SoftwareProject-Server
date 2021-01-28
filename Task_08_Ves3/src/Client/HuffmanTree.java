package Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {


    int [] distribution;
    HuffmanEntry entry;

    public HuffmanTree(int[] distribution)
    {
        this.distribution = distribution;

        List<HuffmanEntry> inputList = new ArrayList<>();

        for (int i = 0; i < distribution.length; i++) {
            inputList.add(new HuffmanEntry((byte) i, distribution[i]));
        }

        entry = CreateTree(inputList);
    }

    public HuffmanEntry CreateTree(List<HuffmanEntry> inputList)
    {
        while(inputList.size() > 1){
            inputList.add(new HuffmanEntry(inputList.get(0), inputList.get(1)));
            inputList.remove(0);
            inputList.remove(0);
            Collections.sort(inputList);
        }

        return inputList.get(0);
    }
    public byte[] encode(byte [] input)
    {
        String bytes = "";

        for(byte b : input) {
            HuffmanEntry current = entry;

            while(true){
                if (current.data.length <= 1) {
                    break;
                }

                if (Contains(current.left.data, b)) {
                    current = current.left;
                    bytes += 1;
                }

                else {
                    current = current.right;
                    bytes += 0;
                }
            }
        }

        bytes += 1;

        while(bytes.length()%8 != 0) {
            bytes += 0;
        }

        byte[] result = new byte[bytes.length()/8];

        for (int i= 0; i < bytes.length(); i += 8) {
            result[i/8] = (byte)Integer.parseInt(bytes.substring(i, i + 8), 2);
        }

        return result;
    }

    private boolean Contains(byte[] array, byte target)
    {
        for(int i : array) {
            if(i == target) {
                return true;
            }
        }

        return false;
    }

    public byte[] decode(byte[] input)
    {
        String bytes = "";

        for(int i = 0; i < input.length*8; i++) {
            bytes += get(input, i)?'1':'0';
        }

        HuffmanEntry current = entry;
        List<Byte> result = new ArrayList<>();
        for(char c : bytes.toCharArray()){

            if(c == '1'){
                current = current.left;
            }
            else{
                current = current.right;
            }

            if(current.data.length <= 1){
                result.add(current.data[0]);
                current = entry;
            }
        }

        byte[] realResult = new byte[result.size()];
        for(int i = 0; i < realResult.length; i++){
            realResult[i] = result.get(i);
        }

        return realResult;
    }






        static private boolean get(byte [] buffer, int index) {
        int b = index >> 3;
        int n = 128 >> index % 8;
        return (buffer[b] & n) !=0;
    }
}
