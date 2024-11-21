/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class shortValueExact
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0 == new BigDecimal("0").shortValueExact());
        harness.check(1 == new BigDecimal("1").shortValueExact());
        harness.check(99 == new BigDecimal("99").shortValueExact());
        harness.check(100 == new BigDecimal("100").shortValueExact());
        harness.check(127 == new BigDecimal("127").shortValueExact());
        harness.check(-127 == new BigDecimal("-127").shortValueExact());
        harness.check(128 == new BigDecimal("128").shortValueExact());
        harness.check(-128 == new BigDecimal("-128").shortValueExact());
        harness.check(Short.MAX_VALUE == new BigDecimal("32767").shortValueExact());
        harness.check(Short.MIN_VALUE == new BigDecimal("-32768").shortValueExact());
        this.testException(harness, "32768");
        this.testException(harness, "32769");
        this.testException(harness, "32770");
        this.testException(harness, "65535");
        this.testException(harness, "65536");
        this.testException(harness, "100.1");
        this.testException(harness, "100.9");
    }

    private void testException(TestHarness harness, String numberStr) {
        try {
            new BigDecimal(numberStr).shortValueExact();
            harness.fail("ArithmeticException not thrown as expected for the number: " + numberStr + "!");
        }
        catch (ArithmeticException arithmeticException) {
            // empty catch block
        }
    }
}

