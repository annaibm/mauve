/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;
import java.util.Random;

public class ctor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testCtorStringInt(harness);
        this.testCtorIntIntRandom(harness);
        this.testCtorIntRandom(harness);
        this.testCtorByteArray(harness);
    }

    private void testCtorStringInt(TestHarness harness) {
        harness.checkPoint("testCtorStringInt");
        try {
            String msg = "MUST throw NumberFormatException for out-of-range radix";
            try {
                new BigInteger("1234567890123", 1);
                harness.fail(msg);
            }
            catch (NumberFormatException x) {
                harness.check(true, msg);
            }
            try {
                new BigInteger("1234567890123", 37);
                harness.fail(msg);
            }
            catch (NumberFormatException x) {
                harness.check(true, msg);
            }
            msg = "MUST throw NumberFormatException for malformed string values";
            try {
                new BigInteger("  1234567890123", 32);
                harness.fail(msg);
            }
            catch (NumberFormatException x) {
                harness.check(true, msg);
            }
            try {
                new BigInteger("1234567890123  ", 32);
                harness.fail(msg);
            }
            catch (NumberFormatException x) {
                harness.check(true, msg);
            }
            try {
                new BigInteger("123456789-0123  ", 10);
                harness.fail(msg);
            }
            catch (NumberFormatException x) {
                harness.check(true, msg);
            }
            msg = "MUST throw NumberFormatException for invalid string values";
            try {
                new BigInteger("1ifbyland2ifbysea", 24);
                harness.fail(msg);
            }
            catch (NumberFormatException x) {
                harness.check(true, msg);
            }
        }
        catch (Exception x) {
            harness.verbose(x.getMessage());
            harness.fail("testCtorStringInt: " + x);
        }
    }

    private void testCtorIntIntRandom(TestHarness harness) {
        harness.checkPoint("testCtorIntIntRandom");
        Random prng = new Random();
        try {
            BigInteger bi = new BigInteger(25, 80, prng);
            harness.check(bi.bitLength(), 25, "Constructed BigInteger MUST be 25-bit long");
            bi = new BigInteger(2, 80, prng);
            harness.check(bi.bitLength(), 2, "Constructed BigInteger MUST be 2-bit long");
            int val = bi.intValue();
            harness.check(val == 2 || val == 3, "Constructed BigInteger MUST be 2 or 3");
        }
        catch (Exception x) {
            harness.verbose(x.getMessage());
            harness.fail("testCtorIntIntRandom: " + x);
        }
    }

    private void testCtorIntRandom(TestHarness harness) {
        harness.checkPoint("testCtorIntRandom");
        Random prng = new Random();
        try {
            for (int numBits = 8; numBits < 2048; ++numBits) {
                BigInteger bi = new BigInteger(numBits, prng);
                int realNumBits = bi.bitLength();
                if (realNumBits <= numBits) continue;
                harness.fail("Constructed BigInteger has " + realNumBits + " bits when it SHOULD be <= " + numBits);
            }
        }
        catch (Exception x) {
            harness.verbose(x.getMessage());
            harness.fail("testCtorIntRandom: " + x);
        }
        harness.check(true, "BigInteger(numBits, prng) MUST generate MPIs shorter than numBits bits");
    }

    private void testCtorByteArray(TestHarness harness) {
        harness.checkPoint("testCtorByteArray");
        try {
            for (int nValue = Short.MIN_VALUE; nValue < 32768; nValue += 8) {
                BigInteger b1 = BigInteger.valueOf(nValue);
                byte[] ba = b1.toByteArray();
                BigInteger b2 = new BigInteger(ba);
                long val = b2.longValue();
                if (val == (long)nValue) continue;
                harness.fail("Re-constructed BigInteger long value was expected to be " + nValue + " but was found to be " + val);
            }
        }
        catch (Exception x) {
            harness.verbose(x.getMessage());
            harness.fail("testCtorByteArray: " + x);
        }
        harness.check(true, "Re-constructed BigIntegers have expected long values");
    }
}

