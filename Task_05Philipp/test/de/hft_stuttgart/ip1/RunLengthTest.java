package de.hft_stuttgart.ip1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestResultLoggerExtension.class)
class RunLengthTest {

    @Test
    @TestValue(8)
    void transform() {
        short[] input = new short[] {66, 97, 110, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1};
        short[] expect = new short[] {67, 98, 111, 2, 2, 1, 0, 2, 0, 2, 2};
        short[] output = RunLength.transform(input);
        assertArrayEquals(expect, output);
    }

    @Test
    @TestValue(8)
    void retransform() {
        short[] input = new short[] {67, 98, 111, 2, 2, 1, 0, 2, 0, 2, 2};
        short[] expect = new short[] {66, 97, 110, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1};
        short[] output = RunLength.retransform(input);
        assertArrayEquals(expect, output);
    }
}