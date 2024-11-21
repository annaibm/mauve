/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class longValueExact
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0L == new BigDecimal("0").longValueExact());
        harness.check(1L == new BigDecimal("1").longValueExact());
        harness.check(99L == new BigDecimal("99").longValueExact());
        harness.check(100L == new BigDecimal("100").longValueExact());
        harness.check(127L == new BigDecimal("127").longValueExact());
        harness.check(-127L == new BigDecimal("-127").longValueExact());
        harness.check(128L == new BigDecimal("128").longValueExact());
        harness.check(-128L == new BigDecimal("-128").longValueExact());
        harness.check(32767L == new BigDecimal("32767").longValueExact());
        harness.check(-32768L == new BigDecimal("-32768").longValueExact());
        harness.check(Integer.MAX_VALUE == new BigDecimal("2147483647").longValueExact());
        harness.check(-2147483647L == new BigDecimal("-2147483647").longValueExact());
        this.testException(harness, "18446744073709551615");
        this.testException(harness, "18446744073709551616");
        this.testException(harness, "100.1");
        this.testException(harness, "100.9");
    }

    private void testException(TestHarness harness, String numberStr) {
        try {
            new BigDecimal(numberStr).longValueExact();
            harness.fail("ArithmeticException not thrown as expected for the number: " + numberStr + "!");
        }
        catch (ArithmeticException arithmeticException) {
            // empty catch block
        }
    }
}

