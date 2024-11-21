/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRegular(harness);
        this.testInfinities(harness);
        this.testNaN(harness);
    }

    public void testRegular(TestHarness harness) {
        harness.check(Double.valueOf("1.0"), new Double(1.0));
        harness.check(Double.valueOf("+1.0"), new Double(1.0));
        harness.check(Double.valueOf("-1.0"), new Double(-1.0));
        harness.check(Double.valueOf(" 1.0 "), new Double(1.0));
        harness.check(Double.valueOf(" -1.0 "), new Double(-1.0));
        harness.check(Double.valueOf("2."), new Double(2.0));
        harness.check(Double.valueOf(".3"), new Double(0.3));
        harness.check(Double.valueOf("1e-9"), new Double(1.0E-9));
        harness.check(Double.valueOf("1e137"), new Double(1.0E137));
        try {
            Double.valueOf("");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Double.valueOf("X");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Double.valueOf("e");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Double.valueOf("+ 1.0");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Double.valueOf("- 1.0");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Double.valueOf(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    public void testInfinities(TestHarness harness) {
        try {
            harness.check(Double.valueOf("Infinity"), new Double(Double.POSITIVE_INFINITY));
            harness.check(Double.valueOf("+Infinity"), new Double(Double.POSITIVE_INFINITY));
            harness.check(Double.valueOf("-Infinity"), new Double(Double.NEGATIVE_INFINITY));
            harness.check(Double.valueOf(" +Infinity "), new Double(Double.POSITIVE_INFINITY));
            harness.check(Double.valueOf(" -Infinity "), new Double(Double.NEGATIVE_INFINITY));
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
        harness.check(Double.valueOf("1e1000"), new Double(Double.POSITIVE_INFINITY));
        harness.check(Double.valueOf("-1e1000"), new Double(Double.NEGATIVE_INFINITY));
    }

    public void testNaN(TestHarness harness) {
        try {
            harness.check(Double.isNaN(Double.valueOf("NaN")));
            harness.check(Double.isNaN(Double.valueOf("+NaN")));
            harness.check(Double.isNaN(Double.valueOf("-NaN")));
            harness.check(Double.isNaN(Double.valueOf(" +NaN ")));
            harness.check(Double.isNaN(Double.valueOf(" -NaN ")));
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
    }
}

