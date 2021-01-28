package de.hft_stuttgart.ip1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(de.hft_stuttgart.ip1.TestResultLoggerExtension.class)
public class HuffmanEntryTest {
    private HuffmanEntry left = new HuffmanEntry(new HuffmanEntry((byte) 0x31, 12), new HuffmanEntry((byte) 0x32, 13));
    private HuffmanEntry right = new HuffmanEntry(new HuffmanEntry((byte) 0x43, 14), new HuffmanEntry((byte) 0x42, 15));
    private HuffmanEntry entry = new HuffmanEntry(left, right);
    private HuffmanEntry yrtne = new HuffmanEntry(right, left);

    private HuffmanEntry range [] = new HuffmanEntry[]{
            new HuffmanEntry((byte) 0x10, 10),
            new HuffmanEntry(new HuffmanEntry((byte) 0x10, 8), new HuffmanEntry((byte) 0x12, 2)),
            new HuffmanEntry(new HuffmanEntry((byte) 0x13, 8), new HuffmanEntry((byte) 0x14, 2)),
            new HuffmanEntry((byte) 0x0, 12),
            new HuffmanEntry(new HuffmanEntry((byte) 0x1, 8), new HuffmanEntry((byte) 0x2, 4)),
            new HuffmanEntry(new HuffmanEntry((byte) 0x3, 8), new HuffmanEntry((byte) 0x4, 4)),
    };

    @Test
    @TestValue(2)
    void checkRange() {
        for (int i = 0; i < range.length - 1; i++) {
            for (int j = i+1; j < range.length; j++) {
                assertTrue(range[i].compareTo(range[j])<0, "Range requirements not met");
            }
        }
        HuffmanEntry[] copy = Arrays.copyOf(range, range.length);
        Arrays.sort(copy);
        assertArrayEquals(range, copy);
    }

    @Test
    @TestValue(2)
    void checkCount() {
        assertEquals(left.count, 25);
        assertEquals(right.count, 29);
        assertEquals(entry.count, 54);
        assertEquals(yrtne.count, 54);
    }

    @Test
    @TestValue(2)
    void checkData() {
        assertArrayEquals(left.data, new byte[]{0x31, 0x32});
        assertArrayEquals(right.data, new byte[]{0x42, 0x43});
        assertArrayEquals(entry.data, new byte[]{0x31, 0x32, 0x42, 0x43});
        assertArrayEquals(yrtne.data, new byte[]{0x31, 0x32, 0x42, 0x43});
    }

    @Test
    @TestValue(3)
    void isLeft() {
        assertTrue(left.isLeft((byte) 0x31));
        assertFalse(left.isLeft((byte) 0x32));
        assertTrue(right.isLeft((byte) 0x43));
        assertFalse(right.isLeft((byte) 0x42));
        assertTrue(entry.isLeft((byte) 0x31));
        assertTrue(entry.isLeft((byte) 0x32));
        assertFalse(entry.isLeft((byte) 0x42));
        assertFalse(entry.isLeft((byte) 0x43));
    }

    @Test
    @TestValue(3)
    void isRight() {
        assertFalse(left.isRight((byte) 0x31));
        assertTrue(left.isRight((byte) 0x32));
        assertFalse(right.isRight((byte) 0x43));
        assertTrue(right.isRight((byte) 0x42));
        assertFalse(entry.isRight((byte) 0x31));
        assertFalse(entry.isRight((byte) 0x32));
        assertTrue(entry.isRight((byte) 0x42));
        assertTrue(entry.isRight((byte) 0x43));
    }

    @Test
    @TestValue(3)
    void compareTo() {
        assertTrue(left.compareTo(left)==0);
        assertTrue(left.compareTo(right)<0);
        assertTrue(right.compareTo(left)>0);
    }
}