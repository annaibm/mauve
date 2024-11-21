/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class parseFloat
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testRegular(harness);
        this.testInfinities(harness);
        this.testNaN(harness);
    }

    public void testRegular(TestHarness harness) {
        harness.check(Float.parseFloat("1.0"), 1.0);
        harness.check(Float.parseFloat("+1.0"), 1.0);
        harness.check(Float.parseFloat("-1.0"), -1.0);
        harness.check(Float.parseFloat(" 1.0 "), 1.0);
        harness.check(Float.parseFloat(" -1.0 "), -1.0);
        harness.check(Float.parseFloat("2."), 2.0);
        harness.check(Float.parseFloat(".3"), 0.3f);
        harness.check(Float.parseFloat("1e-9"), 1.0E-9f);
        harness.check(Float.parseFloat("1e37"), 1.0E37f);
        try {
            Float.parseFloat("");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.parseFloat("X");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.parseFloat("e");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.parseFloat("+ 1.0");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.parseFloat("- 1.0");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.parseFloat(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    public void testInfinities(TestHarness harness) {
        try {
            harness.check(Float.parseFloat("Infinity"), Double.POSITIVE_INFINITY);
            harness.check(Float.parseFloat("+Infinity"), Double.POSITIVE_INFINITY);
            harness.check(Float.parseFloat("-Infinity"), Double.NEGATIVE_INFINITY);
            harness.check(Float.parseFloat(" +Infinity "), Double.POSITIVE_INFINITY);
            harness.check(Float.parseFloat(" -Infinity "), Double.NEGATIVE_INFINITY);
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
        harness.check(Float.parseFloat("1e1000"), Double.POSITIVE_INFINITY);
        harness.check(Float.parseFloat("-1e1000"), Double.NEGATIVE_INFINITY);
    }

    public void testNaN(TestHarness harness) {
        try {
            harness.check(Float.isNaN(Float.parseFloat("NaN")));
            harness.check(Float.isNaN(Float.parseFloat("+NaN")));
            harness.check(Float.isNaN(Float.parseFloat("-NaN")));
            harness.check(Float.isNaN(Float.parseFloat(" +NaN ")));
            harness.check(Float.isNaN(Float.parseFloat(" -NaN ")));
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
    }
}

