/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class valueOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(BigInteger.valueOf(0L).equals(new BigInteger("0")));
        harness.check(BigInteger.valueOf(1L).equals(new BigInteger("1")));
        harness.check(BigInteger.valueOf(-1L).equals(new BigInteger("-1")));
        harness.check(BigInteger.valueOf(Long.MAX_VALUE).equals(new BigInteger("9223372036854775807")));
        harness.check(BigInteger.valueOf(Long.MIN_VALUE).equals(new BigInteger("-9223372036854775808")));
    }
}

