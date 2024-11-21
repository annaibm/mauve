/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class byteValueExact
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(0 == new BigDecimal("0").byteValueExact());
        harness.check(1 == new BigDecimal("1").byteValueExact());
        harness.check(99 == new BigDecimal("99").byteValueExact());
        harness.check(100 == new BigDecimal("100").byteValueExact());
        harness.check(-127 == new BigDecimal("-127").byteValueExact());
        harness.check(127 == new BigDecimal("127").byteValueExact());
        harness.check(-128 == new BigDecimal("-128").byteValueExact());
        harness.check(0 == new BigDecimal(".0").byteValueExact());
        harness.check(1 == new BigDecimal("1.0").byteValueExact());
        harness.check(99 == new BigDecimal("99.0").byteValueExact());
        harness.check(100 == new BigDecimal("100.0").byteValueExact());
        harness.check(-127 == new BigDecimal("-127.0").byteValueExact());
        harness.check(127 == new BigDecimal("127.0").byteValueExact());
        harness.check(-128 == new BigDecimal("-128.0").byteValueExact());
        this.testException(harness, "255");
        this.testException(harness, "256");
        this.testException(harness, "65535");
        this.testException(harness, "65536");
        this.testException(harness, "128");
        this.testException(harness, "129");
        this.testException(harness, "130");
        this.testException(harness, "100.1");
        this.testException(harness, "100.9");
    }

    private void testException(TestHarness harness, String numberStr) {
        try {
            new BigDecimal(numberStr).byteValueExact();
            harness.fail("ArithmeticException not thrown as expected for the number: " + numberStr + "!");
        }
        catch (ArithmeticException arithmeticException) {
            // empty catch block
        }
    }
}

