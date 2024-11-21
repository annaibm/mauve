/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferInt;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferInt;
import java.util.Arrays;

public class getBankData
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int[][] data = new int[][]{{1, 2}};
        DataBufferInt b = new DataBufferInt(data, 2);
        int[][] banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data[0][0] = 3;
        harness.check(banks[0][0] == 3);
        data = new int[][]{{1, 2, 3}};
        b = new DataBufferInt(data, 2);
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        data = new int[][]{{1, 2, 3}, {4, 5, 6, 7}};
        b = new DataBufferInt(data, 2, new int[]{0, 1});
        banks = b.getBankData();
        harness.check(Arrays.equals((Object[])b.getBankData(), (Object[])data));
        DataBufferInt b2 = new DataBufferInt(new int[]{1, 2}, 2);
        banks = b2.getBankData();
        harness.check(banks.length == 1);
        harness.check(banks[0][0] == 1);
        harness.check(banks[0][1] == 2);
        DataBufferInt b3 = new DataBufferInt(new int[][]{{1}, {2}}, 1);
        banks = b3.getBankData();
        harness.check(banks.length == 2);
        harness.check(banks[0][0] == 1);
        harness.check(banks[1][0] == 2);
    }
}

