package de.hft_stuttgart.ip1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(de.hft_stuttgart.ip1.TestResultLoggerExtension.class)
public class HuffmanTreeTest {
    int []distro = TestHelpers.makeData(256, new int[] {32, 3, 72, 1, 83, 1, 84, 1, 97, 1, 99, 3, 101, 2, 102, 1, 103, 1, 104, 3, 105,
            1, 107, 1, 108, 1, 110, 1, 111, 1, 114, 2,115, 1, 116, 4, 117, 2, 188, 1, 195, 1});
    HuffmanTree tree = new HuffmanTree(distro);
    HuffmanEntry entry = new HuffmanEntry(
            new HuffmanEntry(
                    new HuffmanEntry(
                            new HuffmanEntry(
                                    new HuffmanEntry((byte)99,3),
                                    new HuffmanEntry((byte)32,3)),
                            new HuffmanEntry(
                                    new HuffmanEntry(
                                            new HuffmanEntry(
                                                    new HuffmanEntry((byte)-68,1),
                                                    new HuffmanEntry(
                                                            new HuffmanEntry(
                                                                    new HuffmanEntry(
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)91,0),
                                                                                                                    new HuffmanEntry((byte)90,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)89,0),
                                                                                                                    new HuffmanEntry((byte)88,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)87,0),
                                                                                                                    new HuffmanEntry((byte)86,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)85,0),
                                                                                                                    new HuffmanEntry((byte)82,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)81,0),
                                                                                                                    new HuffmanEntry((byte)80,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)79,0),
                                                                                                                    new HuffmanEntry((byte)78,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)77,0),
                                                                                                                    new HuffmanEntry((byte)76,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)75,0),
                                                                                                                    new HuffmanEntry((byte)74,0))))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)73,0),
                                                                                                                    new HuffmanEntry((byte)71,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)70,0),
                                                                                                                    new HuffmanEntry((byte)69,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)68,0),
                                                                                                                    new HuffmanEntry((byte)67,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)66,0),
                                                                                                                    new HuffmanEntry((byte)65,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)64,0),
                                                                                                                    new HuffmanEntry((byte)63,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)62,0),
                                                                                                                    new HuffmanEntry((byte)61,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)60,0),
                                                                                                                    new HuffmanEntry((byte)59,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)58,0),
                                                                                                                    new HuffmanEntry((byte)57,0)))))),
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)56,0),
                                                                                                                    new HuffmanEntry((byte)55,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)54,0),
                                                                                                                    new HuffmanEntry((byte)53,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)52,0),
                                                                                                                    new HuffmanEntry((byte)51,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)50,0),
                                                                                                                    new HuffmanEntry((byte)49,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)48,0),
                                                                                                                    new HuffmanEntry((byte)47,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)46,0),
                                                                                                                    new HuffmanEntry((byte)45,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)44,0),
                                                                                                                    new HuffmanEntry((byte)43,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)42,0),
                                                                                                                    new HuffmanEntry((byte)41,0))))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)40,0),
                                                                                                                    new HuffmanEntry((byte)39,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)38,0),
                                                                                                                    new HuffmanEntry((byte)37,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)36,0),
                                                                                                                    new HuffmanEntry((byte)35,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)34,0),
                                                                                                                    new HuffmanEntry((byte)33,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)31,0),
                                                                                                                    new HuffmanEntry((byte)30,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)29,0),
                                                                                                                    new HuffmanEntry((byte)28,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)27,0),
                                                                                                                    new HuffmanEntry((byte)26,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)25,0),
                                                                                                                    new HuffmanEntry((byte)24,0))))))),
                                                                    new HuffmanEntry(
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)23,0),
                                                                                                                    new HuffmanEntry((byte)22,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)21,0),
                                                                                                                    new HuffmanEntry((byte)20,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)19,0),
                                                                                                                    new HuffmanEntry((byte)18,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)17,0),
                                                                                                                    new HuffmanEntry((byte)16,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)15,0),
                                                                                                                    new HuffmanEntry((byte)14,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)13,0),
                                                                                                                    new HuffmanEntry((byte)12,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)11,0),
                                                                                                                    new HuffmanEntry((byte)10,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)9,0),
                                                                                                                    new HuffmanEntry((byte)8,0))))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)7,0),
                                                                                                                    new HuffmanEntry((byte)6,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)5,0),
                                                                                                                    new HuffmanEntry((byte)4,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)3,0),
                                                                                                                    new HuffmanEntry((byte)2,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)1,0),
                                                                                                                    new HuffmanEntry((byte)0,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-1,0),
                                                                                                                    new HuffmanEntry((byte)-2,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-3,0),
                                                                                                                    new HuffmanEntry((byte)-4,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-5,0),
                                                                                                                    new HuffmanEntry((byte)-6,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-7,0),
                                                                                                                    new HuffmanEntry((byte)-8,0)))))),
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-9,0),
                                                                                                                    new HuffmanEntry((byte)-10,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-11,0),
                                                                                                                    new HuffmanEntry((byte)-12,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-13,0),
                                                                                                                    new HuffmanEntry((byte)-14,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-15,0),
                                                                                                                    new HuffmanEntry((byte)-16,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-17,0),
                                                                                                                    new HuffmanEntry((byte)-18,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-19,0),
                                                                                                                    new HuffmanEntry((byte)-20,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-21,0),
                                                                                                                    new HuffmanEntry((byte)-22,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-23,0),
                                                                                                                    new HuffmanEntry((byte)-24,0))))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-25,0),
                                                                                                                    new HuffmanEntry((byte)-26,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-27,0),
                                                                                                                    new HuffmanEntry((byte)-28,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-29,0),
                                                                                                                    new HuffmanEntry((byte)-30,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-31,0),
                                                                                                                    new HuffmanEntry((byte)-32,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-33,0),
                                                                                                                    new HuffmanEntry((byte)-34,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-35,0),
                                                                                                                    new HuffmanEntry((byte)-36,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-37,0),
                                                                                                                    new HuffmanEntry((byte)-38,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-39,0),
                                                                                                                    new HuffmanEntry((byte)-40,0)))))))),
                                                            new HuffmanEntry(
                                                                    new HuffmanEntry(
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-41,0),
                                                                                                                    new HuffmanEntry((byte)-42,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-43,0),
                                                                                                                    new HuffmanEntry((byte)-44,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-45,0),
                                                                                                                    new HuffmanEntry((byte)-46,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-47,0),
                                                                                                                    new HuffmanEntry((byte)-48,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-49,0),
                                                                                                                    new HuffmanEntry((byte)-50,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-51,0),
                                                                                                                    new HuffmanEntry((byte)-52,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-53,0),
                                                                                                                    new HuffmanEntry((byte)-54,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-55,0),
                                                                                                                    new HuffmanEntry((byte)-56,0))))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-57,0),
                                                                                                                    new HuffmanEntry((byte)-58,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-59,0),
                                                                                                                    new HuffmanEntry((byte)-60,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-62,0),
                                                                                                                    new HuffmanEntry((byte)-63,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-64,0),
                                                                                                                    new HuffmanEntry((byte)-65,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-66,0),
                                                                                                                    new HuffmanEntry((byte)-67,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-69,0),
                                                                                                                    new HuffmanEntry((byte)-70,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-71,0),
                                                                                                                    new HuffmanEntry((byte)-72,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-73,0),
                                                                                                                    new HuffmanEntry((byte)-74,0)))))),
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-75,0),
                                                                                                                    new HuffmanEntry((byte)-76,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-77,0),
                                                                                                                    new HuffmanEntry((byte)-78,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-79,0),
                                                                                                                    new HuffmanEntry((byte)-80,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-81,0),
                                                                                                                    new HuffmanEntry((byte)-82,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-83,0),
                                                                                                                    new HuffmanEntry((byte)-84,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-85,0),
                                                                                                                    new HuffmanEntry((byte)-86,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-87,0),
                                                                                                                    new HuffmanEntry((byte)-88,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-89,0),
                                                                                                                    new HuffmanEntry((byte)-90,0))))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-91,0),
                                                                                                                    new HuffmanEntry((byte)-92,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-93,0),
                                                                                                                    new HuffmanEntry((byte)-94,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-95,0),
                                                                                                                    new HuffmanEntry((byte)-96,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-97,0),
                                                                                                                    new HuffmanEntry((byte)-98,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-99,0),
                                                                                                                    new HuffmanEntry((byte)-100,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-101,0),
                                                                                                                    new HuffmanEntry((byte)-102,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-103,0),
                                                                                                                    new HuffmanEntry((byte)-104,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-105,0),
                                                                                                                    new HuffmanEntry((byte)-106,0))))))),
                                                                    new HuffmanEntry(
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-107,0),
                                                                                                                    new HuffmanEntry((byte)-108,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-109,0),
                                                                                                                    new HuffmanEntry((byte)-110,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-111,0),
                                                                                                                    new HuffmanEntry((byte)-112,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-113,0),
                                                                                                                    new HuffmanEntry((byte)-114,0)))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-115,0),
                                                                                                                    new HuffmanEntry((byte)-116,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-117,0),
                                                                                                                    new HuffmanEntry((byte)-118,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-119,0),
                                                                                                                    new HuffmanEntry((byte)-120,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-121,0),
                                                                                                                    new HuffmanEntry((byte)-122,0))))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-123,0),
                                                                                                                    new HuffmanEntry((byte)-124,0)),
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-125,0),
                                                                                                                    new HuffmanEntry((byte)-126,0))),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry(
                                                                                                                    new HuffmanEntry((byte)-127,0),
                                                                                                                    new HuffmanEntry((byte)-128,0)),
                                                                                                            new HuffmanEntry((byte)127,0))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)126,0),
                                                                                                            new HuffmanEntry((byte)125,0)),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)124,0),
                                                                                                            new HuffmanEntry((byte)123,0))))),
                                                                            new HuffmanEntry(
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)122,0),
                                                                                                            new HuffmanEntry((byte)121,0)),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)120,0),
                                                                                                            new HuffmanEntry((byte)119,0))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)118,0),
                                                                                                            new HuffmanEntry((byte)113,0)),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)112,0),
                                                                                                            new HuffmanEntry((byte)109,0)))),
                                                                                    new HuffmanEntry(
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)106,0),
                                                                                                            new HuffmanEntry((byte)100,0)),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)98,0),
                                                                                                            new HuffmanEntry((byte)96,0))),
                                                                                            new HuffmanEntry(
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)95,0),
                                                                                                            new HuffmanEntry((byte)94,0)),
                                                                                                    new HuffmanEntry(
                                                                                                            new HuffmanEntry((byte)93,0),
                                                                                                            new HuffmanEntry((byte)92,0))))))))),
                                            new HuffmanEntry((byte)115,1)),
                                    new HuffmanEntry(
                                            new HuffmanEntry((byte)111,1),
                                            new HuffmanEntry((byte)110,1)))),
                    new HuffmanEntry(
                            new HuffmanEntry(
                                    new HuffmanEntry(
                                            new HuffmanEntry((byte)108,1),
                                            new HuffmanEntry((byte)107,1)),
                                    new HuffmanEntry(
                                            new HuffmanEntry((byte)105,1),
                                            new HuffmanEntry((byte)103,1))),
                            new HuffmanEntry(
                                    new HuffmanEntry(
                                            new HuffmanEntry((byte)102,1),
                                            new HuffmanEntry((byte)97,1)),
                                    new HuffmanEntry(
                                            new HuffmanEntry((byte)84,1),
                                            new HuffmanEntry((byte)83,1))))),
            new HuffmanEntry(
                    new HuffmanEntry(
                            new HuffmanEntry(
                                    new HuffmanEntry(
                                            new HuffmanEntry((byte)72,1),
                                            new HuffmanEntry((byte)-61,1)),
                                    new HuffmanEntry((byte)117,2)),
                            new HuffmanEntry(
                                    new HuffmanEntry((byte)114,2),
                                    new HuffmanEntry((byte)101,2))),
                    new HuffmanEntry(
                            new HuffmanEntry((byte)116,4),
                            new HuffmanEntry((byte)104,3))));
    @Test
    @TestValue(0)
    void asString() {

        System.out.println(dump(tree));
    }

    @Test
    @TestValue(5)
    void equality() {
        assertTrue(equals(tree.entry, entry));
    }

    @Test
    @TestValue(4)
    void encodeFake() {
        HuffmanTree fake = new HuffmanTree(distro);
        fake.entry = entry;
        byte [] encode = fake.encode("Hochschule für Technik Stuttgart".getBytes(StandardCharsets.UTF_8));
        byte [] expected = new byte[] {-127, -125, -108, 60, -94, -59, -111, 34, -123, -42, 28, -22, 72, -65, 78, -53, 109, 104};
        assertArrayEquals(expected, encode);
    }

    @Test
    @TestValue(8)
    void encodeReal() {
        byte [] encode = tree.encode("Hochschule für Technik Stuttgart".getBytes(StandardCharsets.UTF_8));
        System.out.println(Arrays.toString(encode));
        byte [] expected = new byte[] {-127, -125, -108, 60, -94, -59, -111, 34, -123, -42, 28, -22, 72, -65, 78, -53, 109, 104};
        assertArrayEquals(expected, encode);
    }

    @Test
    @TestValue(4)
    void decodeFake() {
        HuffmanTree fake = new HuffmanTree(distro);
        fake.entry = entry;
        byte [] code = new byte[] {-127, -125, -108, 60, -94, -59, -111, 34, -123, -42, 28, -22, 72, -65, 78, -53, 109, 104};
        byte [] decode = fake.decode(code);
        byte [] expected = "Hochschule für Technik Stuttgart".getBytes(StandardCharsets.UTF_8);
        assertArrayEquals(expected, decode);
    }

    @Test
    @TestValue(8)
    void decode()  {
        byte [] code = new byte[] {-127, -125, -108, 60, -94, -59, -111, 34, -123, -42, 28, -22, 72, -65, 78, -53, 109, 104};
        byte [] decode = tree.decode(code);
        byte [] expected = "Hochschule für Technik Stuttgart".getBytes(StandardCharsets.UTF_8);
        assertArrayEquals(expected, decode);
    }

    private boolean equals(HuffmanEntry item1, HuffmanEntry item2) {
        if (item1 == item2) return true;
        if (item1 == null || item2 == null ) return false;
        if ( item1.getClass() != item2.getClass()) return false;
        return item1.count == item2.count &&
                equals(item1.left, item2.left) &&
                equals(item1.right, item2.right) &&
                Arrays.equals(item1.data, item2.data);
    }

    private String dump(HuffmanTree tree) {
        return dump(tree.entry, "        ");
    }

    private String dump(HuffmanEntry entry, String lead) {
        if ( entry.left == null && entry.right == null ) {
            return String.format("%n%s new HuffmanEntry((byte)%d,%d)", lead, entry.data[0], entry.count);
        }
        else {
            String leftDump = dump(entry.left, lead + "        ");
            String rightDump = dump(entry.right, lead + "        ");
            return String.format("%n%s new HuffmanEntry(%s, %s)", lead, leftDump, rightDump);
        }
    }
}