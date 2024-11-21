/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Arrays;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object[] a1 = new String[]{"", null};
        Object[] a2 = new String[]{"", null};
        harness.check(Arrays.equals(a1, a2));
        this.testBoolean(harness);
        this.testByte(harness);
        this.testChar(harness);
        this.testDouble(harness);
        this.testFloat(harness);
        this.testInt(harness);
        this.testLong(harness);
        this.testObject(harness);
        this.testShort(harness);
    }

    private void testBoolean(TestHarness harness) {
        harness.checkPoint("Arrays.equals(boolean[], boolean[]");
        harness.check(Arrays.equals((boolean[])null, (boolean[])null));
        boolean[] b1 = new boolean[]{true, false};
        boolean[] b2 = new boolean[]{true, false};
        boolean[] b3 = new boolean[]{false, true};
        boolean[] b4 = new boolean[]{true};
        boolean[] b5 = new boolean[]{true, false, false};
        boolean[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("Arrays.equals(byte[], byte[]");
        harness.check(Arrays.equals((byte[])null, (byte[])null));
        byte[] b1 = new byte[]{1, 0};
        byte[] b2 = new byte[]{1, 0};
        byte[] b3 = new byte[]{0, 1};
        byte[] b4 = new byte[]{1};
        byte[] b5 = new byte[]{1, 0, 0};
        byte[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }

    private void testChar(TestHarness harness) {
        harness.checkPoint("Arrays.equals(char[], char[]");
        harness.check(Arrays.equals((char[])null, (char[])null));
        char[] b1 = new char[]{'1', '0'};
        char[] b2 = new char[]{'1', '0'};
        char[] b3 = new char[]{'0', '1'};
        char[] b4 = new char[]{'1'};
        char[] b5 = new char[]{'1', '0', '0'};
        char[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }

    private void testDouble(TestHarness harness) {
        harness.checkPoint("Arrays.equals(double[], double[]");
        harness.check(Arrays.equals((double[])null, (double[])null));
        double[] b1 = new double[]{1.0, 0.0};
        double[] b2 = new double[]{1.0, 0.0};
        double[] b3 = new double[]{0.0, 1.0};
        double[] b4 = new double[]{1.0};
        double[] b5 = new double[]{1.0, 0.0, 0.0};
        double[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }

    private void testFloat(TestHarness harness) {
        harness.checkPoint("Arrays.equals(float[], float[]");
        harness.check(Arrays.equals((float[])null, (float[])null));
        float[] b1 = new float[]{1.0f, 0.0f};
        float[] b2 = new float[]{1.0f, 0.0f};
        float[] b3 = new float[]{0.0f, 1.0f};
        float[] b4 = new float[]{1.0f};
        float[] b5 = new float[]{1.0f, 0.0f, 0.0f};
        float[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("Arrays.equals(int[], int[]");
        harness.check(Arrays.equals((int[])null, (int[])null));
        int[] b1 = new int[]{1, 0};
        int[] b2 = new int[]{1, 0};
        int[] b3 = new int[]{0, 1};
        int[] b4 = new int[]{1};
        int[] b5 = new int[]{1, 0, 0};
        int[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }

    private void testLong(TestHarness harness) {
        harness.checkPoint("Arrays.equals(long[], long[]");
        harness.check(Arrays.equals((long[])null, (long[])null));
        long[] b1 = new long[]{1L, 0L};
        long[] b2 = new long[]{1L, 0L};
        long[] b3 = new long[]{0L, 1L};
        long[] b4 = new long[]{1L};
        long[] b5 = new long[]{1L, 0L, 0L};
        long[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }

    private void testObject(TestHarness harness) {
        harness.checkPoint("Arrays.equals(Object[], Object[]");
        harness.check(Arrays.equals((Object[])null, (Object[])null));
        Object[] b1 = new Object[]{"1", "0", null};
        Object[] b2 = new Object[]{"1", "0", null};
        Object[] b3 = new Object[]{"0", "1"};
        Object[] b4 = new Object[]{"1"};
        Object[] b5 = new Object[]{"1", "0", "0"};
        Object[] b6 = new Object[]{"1", "0", null, "0"};
        Object[] b7 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
        harness.check(!Arrays.equals(b1, b7));
    }

    private void testShort(TestHarness harness) {
        harness.checkPoint("Arrays.equals(short[], short[]");
        harness.check(Arrays.equals((short[])null, (short[])null));
        short[] b1 = new short[]{1, 0};
        short[] b2 = new short[]{1, 0};
        short[] b3 = new short[]{0, 1};
        short[] b4 = new short[]{1};
        short[] b5 = new short[]{1, 0, 0};
        short[] b6 = null;
        harness.check(Arrays.equals(b1, b2));
        harness.check(!Arrays.equals(b1, b3));
        harness.check(!Arrays.equals(b1, b4));
        harness.check(!Arrays.equals(b1, b5));
        harness.check(!Arrays.equals(b1, b6));
    }
}

