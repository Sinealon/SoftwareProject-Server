package Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class HuffmanTree {
    int [] distribution;
    HuffmanEntry entry;

    public HuffmanTree(int[] distribution) {
            LinkedList<HuffmanEntry> liste = new LinkedList<>();
            this.distribution = distribution;
            for (int i = 0;i<distribution.length;i++) {
            liste.add(new HuffmanEntry(Integer.valueOf(i).byteValue(),distribution[i]));
            }
            while (liste.size()>1) {
            liste.sort(HuffmanEntry::compareTo);
            HuffmanEntry links = liste.getFirst();
            liste.removeFirst();
            HuffmanEntry right = liste.getFirst();
            liste.removeFirst();
            liste.add(new HuffmanEntry(right,links));
            }
            entry = liste.getFirst();
        }

    public byte[] encode(byte [] input) {
            HuffmanEntry position = entry;
            LinkedList<Boolean> liste = new LinkedList<>();
            for (byte in:input) {
            while(position.data.length>1){
            liste.add((position.isLeft(in))? false:true);
            position = (liste.getLast())? position.right:position.left;
            }
            position = entry;
            }
            byte [] ergebniss = new byte[(liste.size()/8)+1];
            for(int i = 0;i<liste.size();i++){
            set(ergebniss,i,liste.get(i));
            }
            set(ergebniss,liste.size(),true);
            return ergebniss;
        }

    public byte[] decode(byte[] input) {
            HuffmanEntry position = entry;
            LinkedList <Byte> ergebnisse = new  LinkedList();
            LinkedList<Boolean> liste = new LinkedList<>();
            for(int i = 0;i<input.length*8;i++){
            liste.add(get(input,i));
            }
            for(int i = 0;i<liste.size();i++){
            position = (liste.get(i))? position.right:position.left;
            if(position.data.length == 1){
            ergebnisse.add(position.data[0]);
            position = entry;
            }
            }
            byte [] ergebnissArray = new byte[ergebnisse.size()];
            for(int i = 0; i<ergebnissArray.length;i++){
            ergebnissArray[i] = ergebnisse.get(i);
            }
            return ergebnissArray;
        }

    static private boolean get(byte [] buffer, int index) {
            int b = index >> 3;
            int m = 128 >> index%8;
            return (buffer[b]&m)!=0;
        }

    static private void set(byte [] buffer, int index, boolean value) {
            int b = index >> 3;
            int m = 128 >> index % 8;
            buffer[b] =(byte) (value? buffer[b]|m: buffer[b]&~m);
        }
}
