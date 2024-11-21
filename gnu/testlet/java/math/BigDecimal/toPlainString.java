/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class toPlainString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(BigInteger)");
        try {
            harness.check(BigDecimal.ZERO.toPlainString(), (Object)"0");
            harness.check(BigDecimal.ONE.toPlainString(), (Object)"1");
            harness.check(BigDecimal.TEN.toPlainString(), (Object)"10");
            harness.check(new BigDecimal(1).toPlainString(), (Object)"1");
            harness.check(new BigDecimal("1").toPlainString(), (Object)"1");
            harness.check(new BigDecimal(10).toPlainString(), (Object)"10");
            harness.check(new BigDecimal(100).toPlainString(), (Object)"100");
            harness.check(new BigDecimal(1000).toPlainString(), (Object)"1000");
            harness.check(new BigDecimal(10000).toPlainString(), (Object)"10000");
            harness.check(new BigDecimal(100000).toPlainString(), (Object)"100000");
            harness.check(new BigDecimal(1).toPlainString(), (Object)"1");
            harness.check(new BigDecimal("-1").toPlainString(), (Object)"-1");
            harness.check(new BigDecimal(-10).toPlainString(), (Object)"-10");
            harness.check(new BigDecimal(-100).toPlainString(), (Object)"-100");
            harness.check(new BigDecimal(-1000).toPlainString(), (Object)"-1000");
            harness.check(new BigDecimal(-10000).toPlainString(), (Object)"-10000");
            harness.check(new BigDecimal(-100000).toPlainString(), (Object)"-100000");
            harness.check(new BigDecimal("1e8").toPlainString(), (Object)"100000000");
            harness.check(new BigDecimal("1e9").toPlainString(), (Object)"1000000000");
            harness.check(new BigDecimal("1e10").toPlainString(), (Object)"10000000000");
            harness.check(new BigDecimal("1e11").toPlainString(), (Object)"100000000000");
            harness.check(new BigDecimal("1e12").toPlainString(), (Object)"1000000000000");
            harness.check(new BigDecimal("-1e8").toPlainString(), (Object)"-100000000");
            harness.check(new BigDecimal("-1e9").toPlainString(), (Object)"-1000000000");
            harness.check(new BigDecimal("-1e10").toPlainString(), (Object)"-10000000000");
            harness.check(new BigDecimal("-1e11").toPlainString(), (Object)"-100000000000");
            harness.check(new BigDecimal("-1e12").toPlainString(), (Object)"-1000000000000");
            harness.check(new BigDecimal("1e-8").toPlainString(), (Object)"0.00000001");
            harness.check(new BigDecimal("1e-9").toPlainString(), (Object)"0.000000001");
            harness.check(new BigDecimal("1e-10").toPlainString(), (Object)"0.0000000001");
            harness.check(new BigDecimal("1e-11").toPlainString(), (Object)"0.00000000001");
            harness.check(new BigDecimal("1e-12").toPlainString(), (Object)"0.000000000001");
            harness.check(new BigDecimal("-1e-8").toPlainString(), (Object)"-0.00000001");
            harness.check(new BigDecimal("-1e-9").toPlainString(), (Object)"-0.000000001");
            harness.check(new BigDecimal("-1e-10").toPlainString(), (Object)"-0.0000000001");
            harness.check(new BigDecimal("-1e-11").toPlainString(), (Object)"-0.00000000001");
            harness.check(new BigDecimal("-1e-12").toPlainString(), (Object)"-0.000000000001");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }
}

