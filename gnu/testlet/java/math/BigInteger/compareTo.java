/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class compareTo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger a = new BigInteger("-987654321098765432109876543210");
        BigInteger b = new BigInteger("-1");
        BigInteger c = new BigInteger("0");
        BigInteger d = new BigInteger("1");
        BigInteger e = new BigInteger("987654321098765432109876543210");
        harness.check(a.compareTo(a) == 0);
        harness.check(a.compareTo(b) < 0);
        harness.check(a.compareTo(c) < 0);
        harness.check(a.compareTo(d) < 0);
        harness.check(a.compareTo(e) < 0);
        harness.check(b.compareTo(a) > 0);
        harness.check(b.compareTo(b) == 0);
        harness.check(b.compareTo(c) < 0);
        harness.check(b.compareTo(d) < 0);
        harness.check(b.compareTo(e) < 0);
        harness.check(c.compareTo(a) > 0);
        harness.check(c.compareTo(b) > 0);
        harness.check(c.compareTo(c) == 0);
        harness.check(c.compareTo(d) < 0);
        harness.check(c.compareTo(e) < 0);
        harness.check(d.compareTo(a) > 0);
        harness.check(d.compareTo(b) > 0);
        harness.check(d.compareTo(c) > 0);
        harness.check(d.compareTo(d) == 0);
        harness.check(d.compareTo(e) < 0);
        harness.check(e.compareTo(a) > 0);
        harness.check(e.compareTo(b) > 0);
        harness.check(e.compareTo(c) > 0);
        harness.check(e.compareTo(d) > 0);
        harness.check(e.compareTo(e) == 0);
        boolean pass = false;
        try {
            a.compareTo(new Integer(1));
        }
        catch (ClassCastException ee) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            a.compareTo(null);
        }
        catch (NullPointerException ee) {
            pass = true;
        }
        harness.check(pass);
    }
}

