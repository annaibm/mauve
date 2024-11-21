/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class toEngineeringString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("constructor BigDecimal(BigInteger)");
        try {
            harness.check(BigDecimal.ZERO.toEngineeringString(), (Object)"0");
            harness.check(BigDecimal.ONE.toEngineeringString(), (Object)"1");
            harness.check(BigDecimal.TEN.toEngineeringString(), (Object)"10");
            harness.check(new BigDecimal(1).toEngineeringString(), (Object)"1");
            harness.check(new BigDecimal("1").toEngineeringString(), (Object)"1");
            harness.check(new BigDecimal(10).toEngineeringString(), (Object)"10");
            harness.check(new BigDecimal(100).toEngineeringString(), (Object)"100");
            harness.check(new BigDecimal(1000).toEngineeringString(), (Object)"1000");
            harness.check(new BigDecimal(10000).toEngineeringString(), (Object)"10000");
            harness.check(new BigDecimal(100000).toEngineeringString(), (Object)"100000");
            harness.check(new BigDecimal(1).toEngineeringString(), (Object)"1");
            harness.check(new BigDecimal("-1").toEngineeringString(), (Object)"-1");
            harness.check(new BigDecimal(-10).toEngineeringString(), (Object)"-10");
            harness.check(new BigDecimal(-100).toEngineeringString(), (Object)"-100");
            harness.check(new BigDecimal(-1000).toEngineeringString(), (Object)"-1000");
            harness.check(new BigDecimal(-10000).toEngineeringString(), (Object)"-10000");
            harness.check(new BigDecimal(-100000).toEngineeringString(), (Object)"-100000");
            harness.check(new BigDecimal("1e8").toEngineeringString(), (Object)"100E+6");
            harness.check(new BigDecimal("1e9").toEngineeringString(), (Object)"1E+9");
            harness.check(new BigDecimal("1e10").toEngineeringString(), (Object)"10E+9");
            harness.check(new BigDecimal("1e11").toEngineeringString(), (Object)"100E+9");
            harness.check(new BigDecimal("1e12").toEngineeringString(), (Object)"1E+12");
            harness.check(new BigDecimal("-1e8").toEngineeringString(), (Object)"-100E+6");
            harness.check(new BigDecimal("-1e9").toEngineeringString(), (Object)"-1E+9");
            harness.check(new BigDecimal("-1e10").toEngineeringString(), (Object)"-10E+9");
            harness.check(new BigDecimal("-1e11").toEngineeringString(), (Object)"-100E+9");
            harness.check(new BigDecimal("-1e12").toEngineeringString(), (Object)"-1E+12");
            harness.check(new BigDecimal("1e-8").toEngineeringString(), (Object)"10E-9");
            harness.check(new BigDecimal("1e-9").toEngineeringString(), (Object)"1E-9");
            harness.check(new BigDecimal("1e-10").toEngineeringString(), (Object)"100E-12");
            harness.check(new BigDecimal("1e-11").toEngineeringString(), (Object)"10E-12");
            harness.check(new BigDecimal("1e-12").toEngineeringString(), (Object)"1E-12");
            harness.check(new BigDecimal("-1e-8").toEngineeringString(), (Object)"-10E-9");
            harness.check(new BigDecimal("-1e-9").toEngineeringString(), (Object)"-1E-9");
            harness.check(new BigDecimal("-1e-10").toEngineeringString(), (Object)"-100E-12");
            harness.check(new BigDecimal("-1e-11").toEngineeringString(), (Object)"-10E-12");
            harness.check(new BigDecimal("-1e-12").toEngineeringString(), (Object)"-1E-12");
        }
        catch (Exception e) {
            harness.fail("Exception should not be thrown here." + e);
        }
    }
}

