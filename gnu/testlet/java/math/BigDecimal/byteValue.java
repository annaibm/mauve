/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class byteValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0 == new BigDecimal("0").byteValue());
        harness.check(1 == new BigDecimal("1").byteValue());
        harness.check(99 == new BigDecimal("99").byteValue());
        harness.check(100 == new BigDecimal("100").byteValue());
        harness.check(127 == new BigDecimal("127").byteValue());
        harness.check(-127 == new BigDecimal("-127").byteValue());
        harness.check(-128 == new BigDecimal("128").byteValue());
        harness.check(-128 == new BigDecimal("-128").byteValue());
        harness.check(-1 == new BigDecimal("255").byteValue());
        harness.check(0 == new BigDecimal("256").byteValue());
        harness.check(-1 == new BigDecimal("65535").byteValue());
        harness.check(0 == new BigDecimal("65536").byteValue());
        harness.check(-127 == new BigDecimal("129").byteValue());
        harness.check(-126 == new BigDecimal("130").byteValue());
        harness.check(100 == new BigDecimal("100.0").byteValue());
        harness.check(100 == new BigDecimal("100.1").byteValue());
        harness.check(100 == new BigDecimal("100.9").byteValue());
    }
}

