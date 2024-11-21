/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferShort;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferShort;
import java.util.Arrays;

public class getBankData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        short[][] data = new short[][]{{1, 2}};
        DataBufferShort b = new DataBufferShort(data, 2);
        short[][] banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data[0][0] = 3;
        harness.check(banks[0][0] == 3);
        data = new short[][]{{1, 2, 3}};
        b = new DataBufferShort(data, 2);
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data = new short[][]{{1, 2, 3}, {4, 5, 6, 7}};
        b = new DataBufferShort(data, 2, new int[]{0, 1});
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        DataBufferShort b2 = new DataBufferShort(new short[]{1, 2}, 2);
        banks = b2.getBankData();
        harness.check(banks.length == 1);
        harness.check(banks[0][0] == 1);
        harness.check(banks[0][1] == 2);
        DataBufferShort b3 = new DataBufferShort(new short[][]{{1}, {2}}, 1);
        banks = b3.getBankData();
        harness.check(banks.length == 2);
        harness.check(banks[0][0] == 1);
        harness.check(banks[1][0] == 2);
    }
}

