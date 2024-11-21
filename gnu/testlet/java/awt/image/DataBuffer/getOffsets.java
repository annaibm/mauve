/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferInt;

public class getOffsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DataBufferInt b1 = new DataBufferInt(new int[]{1, 2, 3}, 3, 1);
        int[] offsets = b1.getOffsets();
        harness.check(offsets.length == 1);
        harness.check(offsets[0] == 1);
    }
}

