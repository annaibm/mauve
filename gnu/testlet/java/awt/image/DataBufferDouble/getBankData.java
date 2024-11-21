/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferDouble;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferDouble;
import java.util.Arrays;

public class getBankData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        double[][] data = new double[][]{{1.0, 2.0}};
        DataBufferDouble b = new DataBufferDouble(data, 2);
        double[][] banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data[0][0] = 3.0;
        harness.check(banks[0][0] == 3.0);
        data = new double[][]{{1.0, 2.0, 3.0}};
        b = new DataBufferDouble(data, 2);
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0, 7.0}};
        b = new DataBufferDouble(data, 2, new int[]{0, 1});
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        DataBufferDouble b2 = new DataBufferDouble(new double[]{1.0, 2.0}, 2);
        banks = b2.getBankData();
        harness.check(banks.length == 1);
        harness.check(banks[0][0] == 1.0);
        harness.check(banks[0][1] == 2.0);
        DataBufferDouble b3 = new DataBufferDouble(new double[][]{{1.0}, {2.0}}, 1);
        banks = b3.getBankData();
        harness.check(banks.length == 2);
        harness.check(banks[0][0] == 1.0);
        harness.check(banks[1][0] == 2.0);
    }
}

