/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class compareTo
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.01");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("10.1");
        b = new BigDecimal("10.01");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("10.10");
        b = new BigDecimal("10.01");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("10.10");
        b = new BigDecimal("10.010");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("10.100");
        b = new BigDecimal("10.010");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("10.100");
        b = new BigDecimal("10.01");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("010.100");
        b = new BigDecimal("10.01");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("010.100");
        b = new BigDecimal("010.01");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("10.100");
        b = new BigDecimal("010.01");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("0.10");
        b = new BigDecimal("0.10");
        harness.check(a.compareTo(b), 0);
        harness.check(b.compareTo(a), 0);
        a = new BigDecimal("0.1");
        b = new BigDecimal("0.10");
        harness.check(a.compareTo(b), 0);
        harness.check(b.compareTo(a), 0);
        a = new BigDecimal("0.1");
        b = new BigDecimal("0.100");
        harness.check(a.compareTo(b), 0);
        harness.check(b.compareTo(a), 0);
        a = new BigDecimal("0.10");
        b = new BigDecimal("0.100");
        harness.check(a.compareTo(b), 0);
        harness.check(b.compareTo(a), 0);
        a = new BigDecimal("10.10");
        b = new BigDecimal("10.10");
        harness.check(a.compareTo(b), 0);
        harness.check(b.compareTo(a), 0);
        a = new BigDecimal("10.100");
        b = new BigDecimal("10.10");
        harness.check(a.compareTo(b), 0);
        harness.check(b.compareTo(a), 0);
        a = new BigDecimal("10.101");
        b = new BigDecimal("10.10");
        harness.check(a.compareTo(b), 1);
        harness.check(b.compareTo(a), -1);
        a = new BigDecimal("10.001");
        b = new BigDecimal("10.10");
        harness.check(a.compareTo(b), -1);
        harness.check(b.compareTo(a), 1);
        a = new BigDecimal("10.001");
        b = new BigDecimal("10.010");
        harness.check(a.compareTo(b), -1);
        harness.check(b.compareTo(a), 1);
        a = new BigDecimal("10.0010");
        b = new BigDecimal("10.010");
        harness.check(a.compareTo(b), -1);
        harness.check(b.compareTo(a), 1);
        a = new BigDecimal("10.0010");
        b = new BigDecimal("10.0100");
        harness.check(a.compareTo(b), -1);
        harness.check(b.compareTo(a), 1);
        a = new BigDecimal("10.0010");
        b = new BigDecimal("10.01000");
        harness.check(a.compareTo(b), -1);
        harness.check(b.compareTo(a), 1);
    }
}

