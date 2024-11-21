/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class shortValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0 == new BigDecimal("0").shortValue());
        harness.check(1 == new BigDecimal("1").shortValue());
        harness.check(99 == new BigDecimal("99").shortValue());
        harness.check(100 == new BigDecimal("100").shortValue());
        harness.check(127 == new BigDecimal("127").shortValue());
        harness.check(-127 == new BigDecimal("-127").shortValue());
        harness.check(128 == new BigDecimal("128").shortValue());
        harness.check(-128 == new BigDecimal("-128").shortValue());
        harness.check(Short.MAX_VALUE == new BigDecimal("32767").shortValue());
        harness.check(Short.MIN_VALUE == new BigDecimal("-32768").shortValue());
        harness.check(Short.MIN_VALUE == new BigDecimal("32768").shortValue());
        harness.check(-1 == new BigDecimal("65535").shortValue());
        harness.check(0 == new BigDecimal("65536").shortValue());
        harness.check(-1 == new BigDecimal("131071").shortValue());
        harness.check(0 == new BigDecimal("131072").shortValue());
        harness.check(100 == new BigDecimal("100.0").shortValue());
        harness.check(100 == new BigDecimal("100.1").shortValue());
        harness.check(100 == new BigDecimal("100.9").shortValue());
    }
}

