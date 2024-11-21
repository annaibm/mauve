/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class intValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0 == new BigDecimal("0").intValue());
        harness.check(1 == new BigDecimal("1").intValue());
        harness.check(99 == new BigDecimal("99").intValue());
        harness.check(100 == new BigDecimal("100").intValue());
        harness.check(127 == new BigDecimal("127").intValue());
        harness.check(-127 == new BigDecimal("-127").intValue());
        harness.check(128 == new BigDecimal("128").intValue());
        harness.check(-128 == new BigDecimal("-128").intValue());
        harness.check(Short.MAX_VALUE == new BigDecimal("32767").intValue());
        harness.check(Short.MIN_VALUE == new BigDecimal("-32768").intValue());
        harness.check(Integer.MAX_VALUE == new BigDecimal("2147483647").intValue());
        harness.check(-2147483647 == new BigDecimal("-2147483647").intValue());
        harness.check(Integer.MIN_VALUE == new BigDecimal("2147483648").intValue());
        harness.check(-2147483647 == new BigDecimal("2147483649").intValue());
        harness.check(-2147483646 == new BigDecimal("2147483650").intValue());
        harness.check(0 == new BigDecimal("4294967296").intValue());
        harness.check(-1 == new BigDecimal("4294967295").intValue());
        harness.check(-2 == new BigDecimal("4294967294").intValue());
        harness.check(100 == new BigDecimal("100.0").intValue());
        harness.check(100 == new BigDecimal("100.1").intValue());
        harness.check(100 == new BigDecimal("100.9").intValue());
    }
}

