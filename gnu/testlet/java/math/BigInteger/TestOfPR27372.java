/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Arrays;

public class TestOfPR27372
implements Testlet {
    private static final byte[] BYTES = new byte[]{18, 52, 86, 120};
    private boolean usingNativeImpl = Arrays.equals(BYTES, new BigInteger(BYTES).toByteArray());

    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("TestOfPR27372");
        try {
            SecureRandom prng1 = SecureRandom.getInstance("SHA1PRNG");
            prng1.setSeed(98243647L);
            SecureRandom prng2 = SecureRandom.getInstance("SHA1PRNG");
            prng2.setSeed(98243647L);
            for (int numBytes = 1; numBytes < 10; ++numBytes) {
                byte[] ba = new BigInteger(8 * numBytes, prng1).toByteArray();
                byte[] bb = new byte[numBytes];
                prng2.nextBytes(bb);
                harness.check(this.areEqual(ba, bb), "BigInteger(int, Random) SHOULD consume as little bytes as possible from Random (and SecureRandom): " + numBytes);
            }
        }
        catch (Exception x) {
            harness.debug(x);
            harness.fail("TestOfPR27372: " + x);
        }
    }

    private boolean areEqual(byte[] a, byte[] b) {
        int offset2 = 0;
        switch (a.length - b.length) {
            case 0: {
                break;
            }
            case 1: {
                if (a[0] != 0) {
                    return false;
                }
                offset2 = 1;
                break;
            }
            default: {
                return false;
            }
        }
        if (this.usingNativeImpl) {
            return this.areEqualNativeBI(a, offset2, b);
        }
        return this.areEqualJavaBI(a, offset2, b);
    }

    private boolean areEqualJavaBI(byte[] a, int offset2, byte[] b) {
        int i = b.length - 1;
        block0: while (i >= 0) {
            int j = i - 3;
            if (j < 0) {
                j = 0;
            }
            for (int k = 0; k < 4; ++k) {
                if (a[offset2 + j++] != b[i--]) {
                    return false;
                }
                if (i < 0) continue block0;
            }
        }
        return true;
    }

    private boolean areEqualNativeBI(byte[] a, int offset2, byte[] b) {
        for (int i = 0; i < b.length; ++i) {
            if (a[offset2 + i] == b[i]) continue;
            return false;
        }
        return true;
    }
}

