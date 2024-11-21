/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferInt;

public class getOffset
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt b1 = new DataBufferInt(new int[]{1, 2, 3}, 3, 1);
        harness.check(b1.getOffset() == 1);
        DataBufferInt b2 = new DataBufferInt(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}, 2, new int[]{1, 2});
        harness.check(b2.getOffset() == 1);
    }
}

