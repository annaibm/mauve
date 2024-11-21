/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class add
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger i1 = new BigInteger("-1");
        BigInteger i2 = new BigInteger("0");
        BigInteger i3 = new BigInteger("1");
        BigInteger i4 = new BigInteger("2");
        harness.check(i1.add(i2).equals(i1));
        harness.check(i1.add(i3).equals(i2));
        harness.check(i1.add(i4).equals(i3));
        harness.check(i3.add(i3).equals(i4));
        BigInteger x = new BigInteger("123456789012345678901234567890");
        BigInteger y = new BigInteger("987654321098765432109876543210");
        harness.check(x.add(y).equals(new BigInteger("1111111110111111111011111111100")));
        boolean pass = false;
        try {
            i1.add(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

