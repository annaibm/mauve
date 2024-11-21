/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferFloat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferFloat;

public class getData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testGetData1(harness);
        this.testGetData2(harness);
    }

    private void testGetData1(TestHarness harness) {
        harness.checkPoint("getData()");
        float[] source = new float[]{1.0f, 2.0f};
        DataBufferFloat b = new DataBufferFloat(source, 2);
        float[] data = b.getData();
        harness.check(data.length == 2);
        harness.check(data[0] == 1.0f);
        harness.check(data[1] == 2.0f);
        source = new float[]{1.0f, 2.0f, 3.0f};
        b = new DataBufferFloat(source, 2);
        data = b.getData();
        harness.check(data.length == 3);
        harness.check(data[0] == 1.0f);
        harness.check(data[1] == 2.0f);
        harness.check(data[2] == 3.0f);
        source = new float[]{1.0f, 2.0f, 3.0f, 4.0f};
        b = new DataBufferFloat(source, 2, 1);
        data = b.getData();
        harness.check(data.length == 4);
        harness.check(data[0] == 1.0f);
        harness.check(data[1] == 2.0f);
        harness.check(data[2] == 3.0f);
        harness.check(data[3] == 4.0f);
        source[2] = 99.0f;
        harness.check(data[2] == 99.0f);
    }

    private void testGetData2(TestHarness harness) {
        harness.checkPoint("getData(int)");
        float[][] source = new float[][]{{1.0f, 2.0f}, {3.0f, 4.0f}};
        DataBufferFloat b = new DataBufferFloat(source, 2);
        float[] data = b.getData(1);
        harness.check(data.length == 2);
        harness.check(data[0] == 3.0f);
        harness.check(data[1] == 4.0f);
        source = new float[][]{{1.0f, 2.0f, 3.0f}, {4.0f, 5.0f, 6.0f}};
        b = new DataBufferFloat(source, 2);
        data = b.getData(1);
        harness.check(data.length == 3);
        harness.check(data[0] == 4.0f);
        harness.check(data[1] == 5.0f);
        harness.check(data[2] == 6.0f);
        source = new float[][]{{1.0f, 2.0f, 3.0f, 4.0f}, {5.0f, 6.0f, 7.0f, 8.0f}};
        b = new DataBufferFloat(source, 2, new int[]{1, 2});
        data = b.getData(1);
        harness.check(data.length == 4);
        harness.check(data[0] == 5.0f);
        harness.check(data[1] == 6.0f);
        harness.check(data[2] == 7.0f);
        harness.check(data[3] == 8.0f);
        source[1][2] = 99.0f;
        harness.check(data[2] == 99.0f);
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

