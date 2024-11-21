/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class longValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0L == new BigDecimal("0").longValue());
        harness.check(1L == new BigDecimal("1").longValue());
        harness.check(99L == new BigDecimal("99").longValue());
        harness.check(100L == new BigDecimal("100").longValue());
        harness.check(127L == new BigDecimal("127").longValue());
        harness.check(-127L == new BigDecimal("-127").longValue());
        harness.check(128L == new BigDecimal("128").longValue());
        harness.check(-128L == new BigDecimal("-128").longValue());
        harness.check(32767L == new BigDecimal("32767").longValue());
        harness.check(-32768L == new BigDecimal("-32768").longValue());
        harness.check(Integer.MAX_VALUE == new BigDecimal("2147483647").longValue());
        harness.check(-2147483647L == new BigDecimal("-2147483647").longValue());
        harness.check(0x100000000L == new BigDecimal("4294967296").longValue());
        harness.check(0xFFFFFFFFL == new BigDecimal("4294967295").longValue());
        harness.check(0xFFFFFFFEL == new BigDecimal("4294967294").longValue());
        harness.check(100L == new BigDecimal("100.0").longValue());
        harness.check(100L == new BigDecimal("100.1").longValue());
        harness.check(100L == new BigDecimal("100.9").longValue());
    }
}

