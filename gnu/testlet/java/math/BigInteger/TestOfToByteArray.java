/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;
import java.util.Arrays;

public class TestOfToByteArray
implements Testlet {
    private static final byte[] BYTES = new byte[]{32, 33, 34, 35, 36, 37, 0, 0, 0, 0, 0, 0};

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("TestOfToByteArray");
        try {
            BigInteger x = new BigInteger(BYTES);
            harness.verbose("*** x = 0x" + x.toString(16));
            byte[] ba = x.toByteArray();
            harness.check(Arrays.equals(ba, BYTES), true, "Byte arrays MUST be equal");
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("TestOfToByteArray: " + x);
        }
    }
}

