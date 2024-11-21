/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float;

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
        harness.check(Float.valueOf("1.0"), new Float(1.0f));
        harness.check(Float.valueOf("+1.0"), new Float(1.0f));
        harness.check(Float.valueOf("-1.0"), new Float(-1.0f));
        harness.check(Float.valueOf(" 1.0 "), new Float(1.0f));
        harness.check(Float.valueOf(" -1.0 "), new Float(-1.0f));
        harness.check(Float.valueOf("2."), new Float(2.0f));
        harness.check(Float.valueOf(".3"), new Float(0.3f));
        harness.check(Float.valueOf("1e-9"), new Float(1.0E-9f));
        harness.check(Float.valueOf("1e37"), new Float(1.0E37f));
        try {
            Float.valueOf("");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.valueOf("X");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.valueOf("e");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.valueOf("+ 1.0");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.valueOf("- 1.0");
            harness.check(false);
        }
        catch (NumberFormatException e) {
            harness.check(true);
        }
        try {
            Float.valueOf(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    public void testInfinities(TestHarness harness) {
        try {
            harness.check(Float.valueOf("Infinity"), new Float(Float.POSITIVE_INFINITY));
            harness.check(Float.valueOf("+Infinity"), new Float(Float.POSITIVE_INFINITY));
            harness.check(Float.valueOf("-Infinity"), new Float(Float.NEGATIVE_INFINITY));
            harness.check(Float.valueOf(" +Infinity "), new Float(Float.POSITIVE_INFINITY));
            harness.check(Float.valueOf(" -Infinity "), new Float(Float.NEGATIVE_INFINITY));
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
        harness.check(Float.valueOf("1e1000"), new Float(Float.POSITIVE_INFINITY));
        harness.check(Float.valueOf("-1e1000"), new Float(Float.NEGATIVE_INFINITY));
    }

    public void testNaN(TestHarness harness) {
        try {
            harness.check(Float.isNaN(Float.valueOf("NaN").floatValue()));
            harness.check(Float.isNaN(Float.valueOf("+NaN").floatValue()));
            harness.check(Float.isNaN(Float.valueOf("-NaN").floatValue()));
            harness.check(Float.isNaN(Float.valueOf(" +NaN ").floatValue()));
            harness.check(Float.isNaN(Float.valueOf(" -NaN ").floatValue()));
        }
        catch (Exception e) {
            harness.check(false);
            harness.debug(e);
        }
    }
}

