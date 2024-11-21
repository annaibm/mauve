/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.imageio.plugins.jpeg;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.imageio.plugins.jpeg.JPEGHuffmanTable;

public class TestJPEGHuffmanTable
implements Testlet {
    @Override
    public void test(TestHarness h) {
        JPEGHuffmanTable t = null;
        boolean constructionFailed = false;
        short[] ACChrominanceLengths = new short[]{0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119};
        short[] ACChrominanceValues = new short[]{0, 1, 2, 3, 17, 4, 5, 33, 49, 6, 18, 65, 81, 7, 97, 113, 19, 34, 50, 129, 8, 20, 66, 145, 161, 177, 193, 9, 35, 51, 82, 240, 21, 98, 114, 209, 10, 22, 36, 52, 225, 37, 241, 23, 24, 25, 26, 38, 39, 40, 41, 42, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 130, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 226, 227, 228, 229, 230, 231, 232, 233, 234, 242, 243, 244, 245, 246, 247, 248, 249, 250};
        short[] ACLuminanceLengths = new short[]{0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125};
        short[] ACLuminanceValues = new short[]{1, 2, 3, 0, 4, 17, 5, 18, 33, 49, 65, 6, 19, 81, 97, 7, 34, 113, 20, 50, 129, 145, 161, 8, 35, 66, 177, 193, 21, 82, 209, 240, 36, 51, 98, 114, 130, 9, 10, 22, 23, 24, 25, 26, 37, 38, 39, 40, 41, 42, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, 131, 132, 133, 134, 135, 136, 137, 138, 146, 147, 148, 149, 150, 151, 152, 153, 154, 162, 163, 164, 165, 166, 167, 168, 169, 170, 178, 179, 180, 181, 182, 183, 184, 185, 186, 194, 195, 196, 197, 198, 199, 200, 201, 202, 210, 211, 212, 213, 214, 215, 216, 217, 218, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250};
        short[] DCChrominanceLengths = new short[]{0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        short[] DCChrominanceValues = new short[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        short[] DCLuminanceLengths = new short[]{0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        short[] DCLuminanceValues = new short[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        try {
            t = new JPEGHuffmanTable(null, null);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        constructionFailed = false;
        try {
            t = new JPEGHuffmanTable(ACLuminanceLengths, null);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        constructionFailed = false;
        try {
            t = new JPEGHuffmanTable(null, ACLuminanceValues);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        short[] boguslengths = new short[]{0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 5};
        constructionFailed = false;
        try {
            t = new JPEGHuffmanTable(boguslengths, ACLuminanceValues);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        short[] bogusvalues = new short[257];
        System.arraycopy(ACLuminanceValues, 0, bogusvalues, 0, 128);
        System.arraycopy(ACLuminanceValues, 0, bogusvalues, 128, 128);
        bogusvalues[256] = 74;
        constructionFailed = false;
        try {
            t = new JPEGHuffmanTable(ACLuminanceLengths, bogusvalues);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        ACLuminanceLengths[3] = 16;
        constructionFailed = false;
        try {
            t = new JPEGHuffmanTable(ACLuminanceLengths, ACLuminanceValues);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        ACLuminanceLengths[3] = 3;
        ACLuminanceLengths[9] = 6;
        constructionFailed = false;
        try {
            t = new JPEGHuffmanTable(ACLuminanceLengths, ACLuminanceValues);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        ACLuminanceLengths[9] = 5;
        short[] valueslessone = new short[ACLuminanceValues.length - 1];
        System.arraycopy(ACLuminanceValues, 0, valueslessone, 0, ACLuminanceValues.length - 1);
        constructionFailed = false;
        try {
            t = new JPEGHuffmanTable(ACLuminanceLengths, valueslessone);
        }
        catch (IllegalArgumentException e) {
            constructionFailed = true;
        }
        h.check(constructionFailed);
        short[] lengths = JPEGHuffmanTable.StdACChrominance.getLengths();
        h.check(Arrays.equals(lengths, ACChrominanceLengths));
        short[] values2 = JPEGHuffmanTable.StdACChrominance.getValues();
        h.check(Arrays.equals(values2, ACChrominanceValues));
        lengths = JPEGHuffmanTable.StdACLuminance.getLengths();
        h.check(Arrays.equals(lengths, ACLuminanceLengths));
        values2 = JPEGHuffmanTable.StdACLuminance.getValues();
        h.check(Arrays.equals(values2, ACLuminanceValues));
        lengths = JPEGHuffmanTable.StdDCChrominance.getLengths();
        h.check(Arrays.equals(lengths, DCChrominanceLengths));
        values2 = JPEGHuffmanTable.StdDCChrominance.getValues();
        h.check(Arrays.equals(values2, DCChrominanceValues));
        lengths = JPEGHuffmanTable.StdDCLuminance.getLengths();
        h.check(Arrays.equals(lengths, DCLuminanceLengths));
        values2 = JPEGHuffmanTable.StdDCLuminance.getValues();
        h.check(Arrays.equals(values2, DCLuminanceValues));
    }
}

