/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Arrays;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.Comparator;

public class binarySearch
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testByte(harness);
        this.testChar(harness);
        this.testDouble(harness);
        this.testFloat(harness);
        this.testInt(harness);
        this.testLong(harness);
        this.testObject(harness);
        this.testShort(harness);
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(byte[], byte)");
        byte[] b1 = new byte[]{1, 2, 3};
        harness.check(Arrays.binarySearch(b1, (byte)0) == -1);
        harness.check(Arrays.binarySearch(b1, (byte)1) == 0);
        harness.check(Arrays.binarySearch(b1, (byte)2) == 1);
        harness.check(Arrays.binarySearch(b1, (byte)3) == 2);
        harness.check(Arrays.binarySearch(b1, (byte)4) == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch((byte[])null, (byte)0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b1 = new byte[]{};
        harness.check(Arrays.binarySearch(b1, (byte)0), -1);
    }

    private void testChar(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(char[], char)");
        char[] b1 = new char[]{'1', '2', '3'};
        harness.check(Arrays.binarySearch(b1, '0') == -1);
        harness.check(Arrays.binarySearch(b1, '1') == 0);
        harness.check(Arrays.binarySearch(b1, '2') == 1);
        harness.check(Arrays.binarySearch(b1, '3') == 2);
        harness.check(Arrays.binarySearch(b1, '4') == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch((char[])null, '0');
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b1 = new char[]{};
        harness.check(Arrays.binarySearch(b1, '0'), -1);
    }

    private void testDouble(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(double[], double)");
        double[] b1 = new double[]{1.0, 2.0, 3.0};
        harness.check(Arrays.binarySearch(b1, 0.0) == -1);
        harness.check(Arrays.binarySearch(b1, 1.0) == 0);
        harness.check(Arrays.binarySearch(b1, 2.0) == 1);
        harness.check(Arrays.binarySearch(b1, 3.0) == 2);
        harness.check(Arrays.binarySearch(b1, 4.0) == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch((double[])null, 0.0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b1 = new double[]{};
        harness.check(Arrays.binarySearch(b1, 0.0), -1);
    }

    private void testFloat(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(float[], float)");
        float[] b1 = new float[]{1.0f, 2.0f, 3.0f};
        harness.check(Arrays.binarySearch(b1, 0.0f) == -1);
        harness.check(Arrays.binarySearch(b1, 1.0f) == 0);
        harness.check(Arrays.binarySearch(b1, 2.0f) == 1);
        harness.check(Arrays.binarySearch(b1, 3.0f) == 2);
        harness.check(Arrays.binarySearch(b1, 4.0f) == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch((float[])null, 0.0f);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b1 = new float[]{};
        harness.check(Arrays.binarySearch(b1, 0.0f), -1);
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(int[], int)");
        int[] b1 = new int[]{1, 2, 3};
        harness.check(Arrays.binarySearch(b1, 0) == -1);
        harness.check(Arrays.binarySearch(b1, 1) == 0);
        harness.check(Arrays.binarySearch(b1, 2) == 1);
        harness.check(Arrays.binarySearch(b1, 3) == 2);
        harness.check(Arrays.binarySearch(b1, 4) == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch((int[])null, 0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b1 = new int[]{};
        harness.check(Arrays.binarySearch(b1, 0), -1);
    }

    private void testLong(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(long[], long)");
        long[] b1 = new long[]{1L, 2L, 3L};
        harness.check(Arrays.binarySearch(b1, 0L) == -1);
        harness.check(Arrays.binarySearch(b1, 1L) == 0);
        harness.check(Arrays.binarySearch(b1, 2L) == 1);
        harness.check(Arrays.binarySearch(b1, 3L) == 2);
        harness.check(Arrays.binarySearch(b1, 4L) == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch((long[])null, 0L);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b1 = new long[]{};
        harness.check(Arrays.binarySearch(b1, 0L), -1);
    }

    private void testObject(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(Object[], Object)");
        Object[] b1 = new Object[]{"1", "2", "3"};
        harness.check(Arrays.binarySearch(b1, "0") == -1);
        harness.check(Arrays.binarySearch(b1, "1") == 0);
        harness.check(Arrays.binarySearch(b1, "2") == 1);
        harness.check(Arrays.binarySearch(b1, "3") == 2);
        harness.check(Arrays.binarySearch(b1, "4") == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch(b1, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.binarySearch((Object[])null, "0");
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.binarySearch(Object[], Object, Comparator)");
        harness.check(Arrays.binarySearch(b1, "0", null) == -1);
        harness.check(Arrays.binarySearch(b1, "1", null) == 0);
        harness.check(Arrays.binarySearch(b1, "2", null) == 1);
        harness.check(Arrays.binarySearch(b1, "3", null) == 2);
        harness.check(Arrays.binarySearch(b1, "4", null) == -4);
        Arrays.sort(b1, new ReverseComparator());
        harness.check(Arrays.binarySearch(b1, "0", new ReverseComparator()) == -4);
        harness.check(Arrays.binarySearch(b1, "1", new ReverseComparator()) == 2);
        harness.check(Arrays.binarySearch(b1, "2", new ReverseComparator()) == 1);
        harness.check(Arrays.binarySearch(b1, "3", new ReverseComparator()) == 0);
        harness.check(Arrays.binarySearch(b1, "4", new ReverseComparator()) == -1);
        b1 = new Object[]{};
        harness.check(Arrays.binarySearch(b1, ""), -1);
    }

    private void testShort(TestHarness harness) {
        harness.checkPoint("Arrays.binarySearch(short[], short)");
        short[] b1 = new short[]{1, 2, 3};
        harness.check(Arrays.binarySearch(b1, (short)0) == -1);
        harness.check(Arrays.binarySearch(b1, (short)1) == 0);
        harness.check(Arrays.binarySearch(b1, (short)2) == 1);
        harness.check(Arrays.binarySearch(b1, (short)3) == 2);
        harness.check(Arrays.binarySearch(b1, (short)4) == -4);
        boolean pass = false;
        try {
            Arrays.binarySearch((short[])null, (short)0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        b1 = new short[]{};
        harness.check(Arrays.binarySearch(b1, (short)0), -1);
    }

    static class ReverseComparator
    implements Comparator {
        ReverseComparator() {
        }

        public int compare(Object o1, Object o2) {
            int i1 = Integer.valueOf(o1.toString());
            int i2 = Integer.valueOf(o2.toString());
            return i2 - i1;
        }
    }
}

