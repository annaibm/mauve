/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class modPow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger ten = BigInteger.valueOf(10L);
        BigInteger three = BigInteger.valueOf(3L);
        BigInteger five = BigInteger.valueOf(5L);
        BigInteger minusFive = five.negate();
        BigInteger seven = BigInteger.valueOf(7L);
        harness.check(three.modPow(five, ten), three);
        harness.check(three.modPow(minusFive, ten), seven);
        harness.check(three.modPow(three.negate(), ten), three);
    }
}

