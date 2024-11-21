/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.math.BigDecimal;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.math.BigDecimal;

public class setScale
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("newScale");
        BigDecimal amount = new BigDecimal("12.34");
        BigDecimal rate = new BigDecimal("0.06");
        BigDecimal result = amount.multiply(rate);
        try {
            BigDecimal foo = result.setScale(-1, 7);
            harness.fail("Failed to catch ArithmeticException");
        }
        catch (ArithmeticException e) {
            harness.check(true);
        }
        harness.check(result.setScale(0, 4), new BigDecimal("1"));
        harness.check(result.setScale(1, 4), new BigDecimal("0.7"));
        harness.check(result.setScale(2, 4), new BigDecimal("0.74"));
        harness.check(result.setScale(3, 4), new BigDecimal("0.740"));
        harness.check(result.setScale(4, 4), new BigDecimal("0.7404"));
        harness.checkPoint("quinn");
        BigDecimal x = new BigDecimal("0.20562");
        harness.check(x.toString(), (Object)"0.20562");
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"0.21");
        x = new BigDecimal("0.20499");
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"0.20");
        x = new BigDecimal("0.20500");
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"0.20");
        x = new BigDecimal("0.20501");
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"0.21");
        x = new BigDecimal("0.21499");
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"0.21");
        x = new BigDecimal("0.21500");
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"0.22");
        x = new BigDecimal("0.21501");
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"0.22");
        harness.checkPoint("quinneg");
        x = new BigDecimal("-0.20562");
        harness.verbose(x.toString());
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"-0.21");
        x = new BigDecimal("-0.20499");
        harness.verbose(x.toString());
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"-0.20");
        x = new BigDecimal("-0.20500");
        harness.verbose(x.toString());
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"-0.20");
        x = new BigDecimal("-0.20501");
        harness.verbose(x.toString());
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"-0.21");
        x = new BigDecimal("-0.21499");
        harness.verbose(x.toString());
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"-0.21");
        x = new BigDecimal("-0.21500");
        harness.verbose(x.toString());
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"-0.22");
        x = new BigDecimal("-0.21501");
        harness.verbose(x.toString());
        x = x.setScale(2, 6);
        harness.check(x.toString(), (Object)"-0.22");
    }
}

