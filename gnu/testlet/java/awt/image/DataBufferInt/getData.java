/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferInt;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferInt;

public class getData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGetData1(harness);
        this.testGetData2(harness);
    }

    private void testGetData1(TestHarness harness) {
        harness.checkPoint("getData()");
        int[] source = new int[]{1, 2};
        DataBufferInt b = new DataBufferInt(source, 2);
        int[] data = b.getData();
        harness.check(data.length == 2);
        harness.check(data[0] == 1);
        harness.check(data[1] == 2);
        source = new int[]{1, 2, 3};
        b = new DataBufferInt(source, 2);
        data = b.getData();
        harness.check(data.length == 3);
        harness.check(data[0] == 1);
        harness.check(data[1] == 2);
        harness.check(data[2] == 3);
        source = new int[]{1, 2, 3, 4};
        b = new DataBufferInt(source, 2, 1);
        data = b.getData();
        harness.check(data.length == 4);
        harness.check(data[0] == 1);
        harness.check(data[1] == 2);
        harness.check(data[2] == 3);
        harness.check(data[3] == 4);
        source[2] = 99;
        harness.check(data[2] == 99);
    }

    private void testGetData2(TestHarness harness) {
        harness.checkPoint("getData(int)");
        int[][] source = new int[][]{{1, 2}, {3, 4}};
        DataBufferInt b = new DataBufferInt(source, 2);
        int[] data = b.getData(1);
        harness.check(data.length == 2);
        harness.check(data[0] == 3);
        harness.check(data[1] == 4);
        source = new int[][]{{1, 2, 3}, {4, 5, 6}};
        b = new DataBufferInt(source, 2);
        data = b.getData(1);
        harness.check(data.length == 3);
        harness.check(data[0] == 4);
        harness.check(data[1] == 5);
        harness.check(data[2] == 6);
        source = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
        b = new DataBufferInt(source, 2, new int[]{1, 2});
        data = b.getData(1);
        harness.check(data.length == 4);
        harness.check(data[0] == 5);
        harness.check(data[1] == 6);
        harness.check(data[2] == 7);
        harness.check(data[3] == 8);
        source[1][2] = 99;
        harness.check(data[2] == 99);
        boolean pass = true;
        try {
            b.getData(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            b.getData(2);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

