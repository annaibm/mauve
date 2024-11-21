/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferDouble;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferDouble;

public class getData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGetData1(harness);
        this.testGetData2(harness);
    }

    private void testGetData1(TestHarness harness) {
        harness.checkPoint("getData()");
        double[] source = new double[]{1.0, 2.0};
        DataBufferDouble b = new DataBufferDouble(source, 2);
        double[] data = b.getData();
        harness.check(data.length == 2);
        harness.check(data[0] == 1.0);
        harness.check(data[1] == 2.0);
        source = new double[]{1.0, 2.0, 3.0};
        b = new DataBufferDouble(source, 2);
        data = b.getData();
        harness.check(data.length == 3);
        harness.check(data[0] == 1.0);
        harness.check(data[1] == 2.0);
        harness.check(data[2] == 3.0);
        source = new double[]{1.0, 2.0, 3.0, 4.0};
        b = new DataBufferDouble(source, 2, 1);
        data = b.getData();
        harness.check(data.length == 4);
        harness.check(data[0] == 1.0);
        harness.check(data[1] == 2.0);
        harness.check(data[2] == 3.0);
        harness.check(data[3] == 4.0);
        source[2] = 99.0;
        harness.check(data[2] == 99.0);
    }

    private void testGetData2(TestHarness harness) {
        harness.checkPoint("getData(int)");
        double[][] source = new double[][]{{1.0, 2.0}, {3.0, 4.0}};
        DataBufferDouble b = new DataBufferDouble(source, 2);
        double[] data = b.getData(1);
        harness.check(data.length == 2);
        harness.check(data[0] == 3.0);
        harness.check(data[1] == 4.0);
        source = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
        b = new DataBufferDouble(source, 2);
        data = b.getData(1);
        harness.check(data.length == 3);
        harness.check(data[0] == 4.0);
        harness.check(data[1] == 5.0);
        harness.check(data[2] == 6.0);
        source = new double[][]{{1.0, 2.0, 3.0, 4.0}, {5.0, 6.0, 7.0, 8.0}};
        b = new DataBufferDouble(source, 2, new int[]{1, 2});
        data = b.getData(1);
        harness.check(data.length == 4);
        harness.check(data[0] == 5.0);
        harness.check(data[1] == 6.0);
        harness.check(data[2] == 7.0);
        harness.check(data[3] == 8.0);
        source[1][2] = 99.0;
        harness.check(data[2] == 99.0);
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

