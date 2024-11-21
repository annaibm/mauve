/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferFloat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferFloat;
import java.util.Arrays;

public class getBankData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        float[][] data = new float[][]{{1.0f, 2.0f}};
        DataBufferFloat b = new DataBufferFloat(data, 2);
        float[][] banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data[0][0] = 3.0f;
        harness.check(banks[0][0] == 3.0f);
        data = new float[][]{{1.0f, 2.0f, 3.0f}};
        b = new DataBufferFloat(data, 2);
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data = new float[][]{{1.0f, 2.0f, 3.0f}, {4.0f, 5.0f, 6.0f, 7.0f}};
        b = new DataBufferFloat(data, 2, new int[]{0, 1});
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        DataBufferFloat b2 = new DataBufferFloat(new float[]{1.0f, 2.0f}, 2);
        banks = b2.getBankData();
        harness.check(banks.length == 1);
        harness.check(banks[0][0] == 1.0f);
        harness.check(banks[0][1] == 2.0f);
        DataBufferFloat b3 = new DataBufferFloat(new float[][]{{1.0f}, {2.0f}}, 1);
        banks = b3.getBankData();
        harness.check(banks.length == 2);
        harness.check(banks[0][0] == 1.0f);
        harness.check(banks[1][0] == 2.0f);
    }
}

