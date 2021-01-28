package de.hft_stuttgart.ip1;

import java.util.*;
import java.util.stream.IntStream;

public class Volltext {
    private final static String endMarker = "\uFFED";
    /*
        Class to help implementing rotated String comparison
     */
    private static class Substring implements Comparable<Substring> {
        private final String value;
        private final int from;
        private final int to;

        public Substring(String value, int from, int to) {
            throw new UnsupportedOperationException("This may be your homework");
        }

        @Override
        public int compareTo(Substring other) {
            throw new UnsupportedOperationException("This may be your homework");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("This may be your homework");
        }
    }

    /**
     Transform the given input according to the algorithm given above for transformation
     */
    public static String transform(String input) {
        input += endMarker;
        String[] zirkpermutationen = new String[input.length()];
        zirkpermutationen[0] = input;
        for(int i = 1; i < zirkpermutationen.length; i++)
        {
            zirkpermutationen[i] = NextPermutation(zirkpermutationen[i-1]);
        }

        Arrays.sort(zirkpermutationen);
        String result = "";

        for(String text: zirkpermutationen){
            result += text.toCharArray()[text.length()-1];
        }
        return result;
    }

    private static String NextPermutation(String text){
        return text.substring(1) + text.toCharArray()[0];
    }

    /**
     Transform the given input according to the algorithm given above for retransformation
     */
    public static String retransform(String input) {
        char[] sortarray = input.toCharArray();
        int[] wiederholungen = new int[sortarray.length];

        wiederholungen[0] = 0;

        Arrays.sort(sortarray);

        for(int i = 1; i < sortarray.length; i++){
            if(sortarray[i] == sortarray[i-1]){
                wiederholungen[i] = wiederholungen[i-1] + 1;
            }
            else {
                wiederholungen[i] = 0;
            }
        }

        int index = input.indexOf(endMarker);
        String result = String.valueOf(sortarray[index]);

        while(true)
        {
            index = searchforIndex(wiederholungen[index], sortarray[index], input);

            if(sortarray[index] == endMarker.toCharArray()[0])
            {
                return result;
            }

            result += sortarray[index];
        }
    }

    private static int searchforIndex(int position, char target, String input){
        int curindex = 0;

        int index = 0;
        for(int i = 0; i <= position; i++){
            index = input.indexOf(target, curindex );
            curindex = index + 1;
        }

        return index;
    }
}