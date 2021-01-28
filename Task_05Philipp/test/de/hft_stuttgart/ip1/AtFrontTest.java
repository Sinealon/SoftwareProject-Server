package de.hft_stuttgart.ip1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

@ExtendWith(TestResultLoggerExtension.class)
class AtFrontTest {

    @Test
    @TestValue(5)
    void transform() throws UnsupportedEncodingException {
        byte [] input = "Bananaan".getBytes("UTF-8");
        short[] output = AtFront.transform(input);
        short[] expect = new short[] {66, 97, 110, 1, 1, 1, 0, 1};
        assertArrayEquals(expect, output);
   }

    @Test
    @TestValue(5)
    void retransform() throws UnsupportedEncodingException {
        short[] input = new short[] {66, 97, 110, 1, 1, 1, 0, 1, 1};
        byte[] output = AtFront.retransform(input);
        byte [] expect = "Bananaana".getBytes("UTF-8");
        assertArrayEquals(expect, output);
    }
}