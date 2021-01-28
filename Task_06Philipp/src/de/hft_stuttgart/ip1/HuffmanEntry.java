package de.hft_stuttgart.ip1;

public class HuffmanEntry implements Comparable<HuffmanEntry> {
    HuffmanEntry left;
    HuffmanEntry right;
    byte[] data;
    int count;


    public HuffmanEntry(HuffmanEntry left, HuffmanEntry right) {
        throw new UnsupportedOperationException("This is your homework");
    }

    public HuffmanEntry(byte data, int count) {

        throw new UnsupportedOperationException("This is your homework");
    }

    public boolean isLeft(byte value) {

        throw new UnsupportedOperationException("This is your homework");
    }

    public boolean isRight(byte value) {

        throw new UnsupportedOperationException("This is your homework");
    }

    /**
     * Method to compare two HuffmanEntries according to count and then
     * value of first element in data.
     * @param other
     * @return Either negative or zero or positive
     */
    public int compareTo(HuffmanEntry other) {

        throw new UnsupportedOperationException("This is your homework");
    }

}
