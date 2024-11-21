/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.nio.ByteBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.nio.ByteBuffer;

public class TestAllocateDirect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ByteBuffer direct2 = ByteBuffer.allocateDirect(32);
        harness.checkPoint("PR 28608");
        ByteBuffer duplicate = null;
        try {
            duplicate = direct2.duplicate();
        }
        catch (Exception x) {
            harness.debug(x);
        }
        harness.check(duplicate != null);
        harness.checkPoint("initial data");
        boolean result = true;
        boolean sawData = false;
        while (direct2.hasRemaining()) {
            result = result && direct2.get() == 0;
            sawData = true;
        }
        harness.check(result && sawData);
    }
}

