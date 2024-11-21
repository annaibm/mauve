/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Arrays;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class sort
implements Testlet {
    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            if (array[i - 1] <= array[i]) continue;
            return false;
        }
        return true;
    }

    private static boolean isSorted(float[] array) {
        for (int i = 1; i < array.length; ++i) {
            if (!(array[i - 1] > array[i])) continue;
            return false;
        }
        return true;
    }

    @Override
    public void test(TestHarness harness) {
        int n = 100;
        int bound = 200;
        int times = 10;
        int[] A2 = new int[n];
        Random rand = new Random();
        for (int i = 0; i < times; ++i) {
            for (int j = 0; j < n; ++j) {
                A2[j] = rand.nextInt(bound);
            }
            Arrays.sort(A2);
            harness.check(sort.isSorted(A2));
        }
        this.test_quicksort(harness);
        this.testByte(harness);
        this.testChar(harness);
        this.testDouble(harness);
        this.testFloat(harness);
        this.testInt(harness);
        this.testLong(harness);
        this.testObject(harness);
        this.testShort(harness);
    }

    public void test_quicksort(TestHarness harness) {
        float[] float_array = new float[]{7.3f, 20000.7f, 343.0f, 24.0f, 4.0E-6f, 1.0E9f, 44.0f, 44.0f, 44.0f, 44.0f, 44.0f, 44.0f, 44.0f, 44.0f};
        Arrays.sort(float_array);
        harness.check(sort.isSorted(float_array));
        float[] float_array2 = new float[]{7.3f, 20000.7f, 21.2f, 343.0f, 24.0f, 4.0E-6f, 1.0E9f};
        Arrays.sort(float_array2);
        harness.check(sort.isSorted(float_array2));
        int[] iarray1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.sort(iarray1);
        harness.check(sort.isSorted(iarray1));
        int[] iarray2 = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        Arrays.sort(iarray2);
        harness.check(sort.isSorted(iarray2));
        int[] iarray3 = new int[]{8, 7, 6, 5, 11, 3, 2, 1};
        Arrays.sort(iarray3);
        harness.check(sort.isSorted(iarray3));
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("Arrays.sort(byte[])");
        byte[] a1 = new byte[]{3, 1, 2};
        Arrays.sort(a1);
        harness.check(a1[0] == 1);
        harness.check(a1[1] == 2);
        harness.check(a1[2] == 3);
        boolean pass = false;
        try {
            Arrays.sort((byte[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(byte[], int, int)");
        byte[] a2 = new byte[]{4, 3, 1, 2, 0};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0] == 4);
        harness.check(a2[1] == 1);
        harness.check(a2[2] == 2);
        harness.check(a2[3] == 3);
        harness.check(a2[4] == 0);
        pass = false;
        try {
            Arrays.sort((byte[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testChar(TestHarness harness) {
        harness.checkPoint("Arrays.sort(char[])");
        char[] a1 = new char[]{'3', '1', '2'};
        Arrays.sort(a1);
        harness.check(a1[0] == '1');
        harness.check(a1[1] == '2');
        harness.check(a1[2] == '3');
        boolean pass = false;
        try {
            Arrays.sort((char[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(char[], int, int)");
        char[] a2 = new char[]{'4', '3', '1', '2', '0'};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0] == '4');
        harness.check(a2[1] == '1');
        harness.check(a2[2] == '2');
        harness.check(a2[3] == '3');
        harness.check(a2[4] == '0');
        pass = false;
        try {
            Arrays.sort((char[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testDouble(TestHarness harness) {
        harness.checkPoint("Arrays.sort(double[])");
        double[] a1 = new double[]{3.0, 1.0, 2.0};
        Arrays.sort(a1);
        harness.check(a1[0] == 1.0);
        harness.check(a1[1] == 2.0);
        harness.check(a1[2] == 3.0);
        boolean pass = false;
        try {
            Arrays.sort((double[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(double[], int, int)");
        double[] a2 = new double[]{4.0, 3.0, 1.0, 2.0, 0.0};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0] == 4.0);
        harness.check(a2[1] == 1.0);
        harness.check(a2[2] == 2.0);
        harness.check(a2[3] == 3.0);
        harness.check(a2[4] == 0.0);
        pass = false;
        try {
            Arrays.sort((double[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testFloat(TestHarness harness) {
        harness.checkPoint("Arrays.sort(float[])");
        float[] a1 = new float[]{3.0f, 1.0f, 2.0f};
        Arrays.sort(a1);
        harness.check(a1[0] == 1.0f);
        harness.check(a1[1] == 2.0f);
        harness.check(a1[2] == 3.0f);
        boolean pass = false;
        try {
            Arrays.sort((float[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(float[], int, int)");
        float[] a2 = new float[]{4.0f, 3.0f, 1.0f, 2.0f, 0.0f};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0] == 4.0f);
        harness.check(a2[1] == 1.0f);
        harness.check(a2[2] == 2.0f);
        harness.check(a2[3] == 3.0f);
        harness.check(a2[4] == 0.0f);
        pass = false;
        try {
            Arrays.sort((float[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("Arrays.sort(int[])");
        int[] a1 = new int[]{3, 1, 2};
        Arrays.sort(a1);
        harness.check(a1[0] == 1);
        harness.check(a1[1] == 2);
        harness.check(a1[2] == 3);
        boolean pass = false;
        try {
            Arrays.sort((int[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(int[], int, int)");
        int[] a2 = new int[]{4, 3, 1, 2, 0};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0] == 4);
        harness.check(a2[1] == 1);
        harness.check(a2[2] == 2);
        harness.check(a2[3] == 3);
        harness.check(a2[4] == 0);
        pass = false;
        try {
            Arrays.sort((int[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testLong(TestHarness harness) {
        harness.checkPoint("Arrays.sort(long[])");
        long[] a1 = new long[]{3L, 1L, 2L};
        Arrays.sort(a1);
        harness.check(a1[0] == 1L);
        harness.check(a1[1] == 2L);
        harness.check(a1[2] == 3L);
        boolean pass = false;
        try {
            Arrays.sort((long[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(long[], int, int)");
        long[] a2 = new long[]{4L, 3L, 1L, 2L, 0L};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0] == 4L);
        harness.check(a2[1] == 1L);
        harness.check(a2[2] == 2L);
        harness.check(a2[3] == 3L);
        harness.check(a2[4] == 0L);
        pass = false;
        try {
            Arrays.sort((long[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testObject(TestHarness harness) {
        harness.checkPoint("Arrays.sort(Object[])");
        Object[] a1 = new Object[]{"3", "1", "2"};
        Arrays.sort(a1);
        harness.check(a1[0].equals("1"));
        harness.check(a1[1].equals("2"));
        harness.check(a1[2].equals("3"));
        boolean pass = false;
        try {
            Arrays.sort((Object[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(Object[], int, int)");
        Object[] a2 = new Object[]{"4", "3", "1", "2", "0"};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0].equals("4"));
        harness.check(a2[1].equals("1"));
        harness.check(a2[2].equals("2"));
        harness.check(a2[3].equals("3"));
        harness.check(a2[4].equals("0"));
        pass = false;
        try {
            Arrays.sort((Object[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(Object[], Comparator)");
        Object[] a3 = new Object[]{"4", "5", "3", "1", "2"};
        Arrays.sort(a3, null);
        harness.check(a3[0].equals("1"));
        harness.check(a3[1].equals("2"));
        harness.check(a3[2].equals("3"));
        harness.check(a3[3].equals("4"));
        harness.check(a3[4].equals("5"));
        Arrays.sort(a3, new ReverseComparator());
        harness.check(a3[0].equals("5"));
        harness.check(a3[1].equals("4"));
        harness.check(a3[2].equals("3"));
        harness.check(a3[3].equals("2"));
        harness.check(a3[4].equals("1"));
        harness.checkPoint("Arrays.sort(Object[], int, int, Comparator)");
        Object[] a4 = new Object[]{"4", "5", "3", "1", "2"};
        Arrays.sort(a4, 1, 4, null);
        harness.check(a4[0].equals("4"));
        harness.check(a4[1].equals("1"));
        harness.check(a4[2].equals("3"));
        harness.check(a4[3].equals("5"));
        harness.check(a4[4].equals("2"));
        Arrays.sort(a4, 1, 4, new ReverseComparator());
        harness.check(a4[0].equals("4"));
        harness.check(a4[1].equals("5"));
        harness.check(a4[2].equals("3"));
        harness.check(a4[3].equals("1"));
        harness.check(a4[4].equals("2"));
    }

    private void testShort(TestHarness harness) {
        harness.checkPoint("Arrays.sort(short[])");
        short[] a1 = new short[]{3, 1, 2};
        Arrays.sort(a1);
        harness.check(a1[0] == 1);
        harness.check(a1[1] == 2);
        harness.check(a1[2] == 3);
        boolean pass = false;
        try {
            Arrays.sort((short[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        harness.checkPoint("Arrays.sort(short[], int, int)");
        short[] a2 = new short[]{4, 3, 1, 2, 0};
        Arrays.sort(a2, 1, 4);
        harness.check(a2[0] == 4);
        harness.check(a2[1] == 1);
        harness.check(a2[2] == 2);
        harness.check(a2[3] == 3);
        harness.check(a2[4] == 0);
        pass = false;
        try {
            Arrays.sort((short[])null, 1, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 1, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, -1, 0);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Arrays.sort(a2, 0, 6);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
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

