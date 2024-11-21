/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class divide
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger p1 = new BigInteger("1");
        BigInteger p2 = new BigInteger("2");
        BigInteger p3 = new BigInteger("3");
        BigInteger p4 = new BigInteger("4");
        BigInteger m1 = new BigInteger("-1");
        BigInteger m2 = new BigInteger("-2");
        BigInteger m3 = new BigInteger("-3");
        BigInteger m4 = new BigInteger("-4");
        harness.check(p4.divide(p2).equals(p2));
        harness.check(m4.divide(p2).equals(m2));
        harness.check(p4.divide(m2).equals(m2));
        harness.check(m4.divide(m2).equals(p2));
        harness.check(p1.divide(p2).equals(BigInteger.ZERO));
        harness.check(m1.divide(p2).equals(BigInteger.ZERO));
        harness.check(p1.divide(m2).equals(BigInteger.ZERO));
        harness.check(m1.divide(m2).equals(BigInteger.ZERO));
        harness.check(p3.divide(p2).equals(BigInteger.ONE));
        harness.check(m3.divide(p2).equals(BigInteger.ONE.negate()));
        harness.check(p3.divide(m2).equals(BigInteger.ONE.negate()));
        harness.check(m3.divide(m2).equals(BigInteger.ONE));
        BigInteger bp1 = new BigInteger("12345678901234567890123456789012345678901234567890");
        BigInteger bp2 = new BigInteger("987654321098765432198765");
        BigInteger bm1 = new BigInteger("-12345678901234567890123456789012345678901234567890");
        BigInteger bm2 = new BigInteger("-987654321098765432198765");
        BigInteger resultp = new BigInteger("12499999886093750000298833");
        BigInteger resultm = new BigInteger("-12499999886093750000298833");
        harness.check(bp1.divide(bp2).equals(resultp));
        harness.check(bm1.divide(bp2).equals(resultm));
        harness.check(bp1.divide(bm2).equals(resultm));
        harness.check(bm1.divide(bm2).equals(resultp));
        boolean pass = false;
        try {
            p1.divide(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            p1.divide(BigInteger.ZERO);
        }
        catch (ArithmeticException e) {
            pass = true;
        }
    }
}

