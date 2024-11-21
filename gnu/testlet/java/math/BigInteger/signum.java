/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class signum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger a = new BigInteger("-123456789012345678901234567890");
        BigInteger b = new BigInteger("-1");
        BigInteger c = new BigInteger("0");
        BigInteger d = new BigInteger("1");
        BigInteger e = new BigInteger("123456789012345678901234567890");
        harness.check(a.signum() == -1);
        harness.check(b.signum() == -1);
        harness.check(c.signum() == 0);
        harness.check(d.signum() == 1);
        harness.check(e.signum() == 1);
    }
}

