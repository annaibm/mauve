/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new BigInteger("12345678901234567890").toString().equals("12345678901234567890"));
        harness.check(new BigInteger("-12345678901234567890").toString().equals("-12345678901234567890"));
        harness.check(new BigInteger("0").toString().equals("0"));
    }
}

