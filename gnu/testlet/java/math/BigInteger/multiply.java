/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class multiply
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger p1 = new BigInteger("1");
        BigInteger p2 = new BigInteger("2");
        BigInteger m1 = new BigInteger("-1");
        BigInteger m2 = new BigInteger("-2");
        harness.check(p1.multiply(p2).equals(p2));
        harness.check(p1.multiply(m2).equals(m2));
        harness.check(m1.multiply(p2).equals(m2));
        harness.check(m1.multiply(m2).equals(p2));
        BigInteger bp1 = new BigInteger("12345678901234567890123456789012345678901234567890");
        BigInteger bp2 = new BigInteger("987654321098765432198765");
        BigInteger bm1 = new BigInteger("-12345678901234567890123456789012345678901234567890");
        BigInteger bm2 = new BigInteger("-987654321098765432198765");
        BigInteger resultp = new BigInteger("12193263113702179523715891618930089161893008916189178958987793067366655850");
        BigInteger resultm = new BigInteger("-12193263113702179523715891618930089161893008916189178958987793067366655850");
        harness.check(bp1.multiply(bp2).equals(resultp));
        harness.check(bp1.multiply(bm2).equals(resultm));
        harness.check(bm1.multiply(bp2).equals(resultm));
        harness.check(bm1.multiply(bm2).equals(resultp));
        boolean pass = false;
        try {
            p1.multiply(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

