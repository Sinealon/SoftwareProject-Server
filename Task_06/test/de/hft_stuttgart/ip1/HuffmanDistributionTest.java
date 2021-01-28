package de.hft_stuttgart.ip1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(de.hft_stuttgart.ip1.TestResultLoggerExtension.class)
class HuffmanDistributionTest {
    @Test
    @TestValue(5)
    void getDistribution() throws UnsupportedEncodingException {
        byte[] input = "Hochschule für Technik Stuttgart".getBytes("UTF-8");
        int[] expected = TestHelpers.makeData(256, new int[] {32, 3,72, 1,83, 1,84, 1,97, 1,99, 3,101, 2,102, 1,103, 1,104, 3,105,
                1,107, 1,108, 1,110, 1,111, 1,114, 2,115, 1,116, 4,117, 2,188, 1,195, 1,});
        assertArrayEquals(expected, HuffmanDistribution.getDistribution(input), "Distribution is unequal");
    }
}