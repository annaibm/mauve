/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigInteger;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigInteger;

public class setBit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigInteger i1 = new BigInteger("0");
        BigInteger i2 = i1.setBit(7);
        harness.check(i2.equals(new BigInteger("128")));
        boolean pass = false;
        try {
            i1.setBit(-1);
        }
        catch (ArithmeticException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

