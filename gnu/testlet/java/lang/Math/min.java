/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class min
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("Small doubles");
        harness.check(Double.toString(Math.min(0.0, -0.0)), (Object)"-0.0");
        harness.check(Double.toString(Math.min(-0.0, -0.0)), (Object)"-0.0");
        harness.check(Double.toString(Math.min(-0.0, 0.0)), (Object)"-0.0");
        harness.check(Double.toString(Math.min(0.0, 0.0)), (Object)"0.0");
        harness.check(Double.toString(Math.min(1.0, 2.0)), (Object)"1.0");
        harness.check(Double.toString(Math.min(2.0, 1.0)), (Object)"1.0");
        harness.check(Double.toString(Math.min(-1.0, -2.0)), (Object)"-2.0");
        harness.check(Double.toString(Math.min(-2.0, 1.0)), (Object)"-2.0");
        harness.check(Double.toString(Math.min(1.0, -2.0)), (Object)"-2.0");
        harness.checkPoint("Double NaNs");
        harness.check(Double.isNaN(Double.NaN));
        harness.check(Double.isNaN(Double.NaN));
        harness.checkPoint("Double NaN comparisons");
        harness.check(Double.toString(Math.min(2.0, Double.NaN)), (Object)"NaN");
        harness.check(Double.toString(Math.min(Double.NaN, 2.0)), (Object)"NaN");
        harness.check(Math.min(Double.NaN, 2.0), Double.NaN);
        harness.checkPoint("Double infinities");
        harness.check(Double.toString(Math.min(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)), (Object)"-Infinity");
        harness.check(Math.min(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY), Double.NEGATIVE_INFINITY);
        harness.check(Double.toString(Math.min(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)), (Object)"Infinity");
        harness.check(Double.toString(Math.min(Double.NEGATIVE_INFINITY, 0.0)), (Object)"-Infinity");
        harness.check(Double.toString(Math.min(Double.POSITIVE_INFINITY, 0.0)), (Object)"0.0");
        harness.checkPoint("Double pi");
        harness.check(Double.toString(Math.max(Math.PI, 0.0)), (Object)Double.toString(Math.PI));
        harness.checkPoint("Small floats");
        harness.check(Float.toString(Math.min(0.0f, -0.0f)), (Object)"-0.0");
        harness.check(Float.toString(Math.min(-0.0f, -0.0f)), (Object)"-0.0");
        harness.check(Float.toString(Math.min(-0.0f, 0.0f)), (Object)"-0.0");
        harness.check(Float.toString(Math.min(0.0f, 0.0f)), (Object)"0.0");
        harness.check(Float.toString(Math.min(1.0f, 2.0f)), (Object)"1.0");
        harness.check(Float.toString(Math.min(2.0f, 1.0f)), (Object)"1.0");
        harness.check(Float.toString(Math.min(-1.0f, -2.0f)), (Object)"-2.0");
        harness.check(Math.min(-1.0f, -2.0f), -2.0);
        harness.check(Float.toString(Math.min(-2.0f, 1.0f)), (Object)"-2.0");
        harness.check(Float.toString(Math.min(1.0f, -2.0f)), (Object)"-2.0");
        harness.checkPoint("Float NaNs");
        harness.check(Float.toString(Math.min(2.0f, Float.NaN)), (Object)"NaN");
        harness.check(Math.min(2.0f, Float.NaN), Double.NaN);
        harness.check(Float.toString(Math.min(Float.NaN, 2.0f)), (Object)"NaN");
        harness.check(Math.min(Float.NaN, 2.0f), Double.NaN);
        harness.checkPoint("Float infinities");
        harness.check(Float.toString(Math.min(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY)), (Object)"-Infinity");
        harness.check(Math.min(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY), Double.NEGATIVE_INFINITY);
        harness.check(Float.toString(Math.min(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)), (Object)"Infinity");
        harness.check(Float.toString(Math.min(Float.NEGATIVE_INFINITY, 0.0f)), (Object)"-Infinity");
        harness.check(Math.min(Float.NEGATIVE_INFINITY, 0.0f), Double.NEGATIVE_INFINITY);
        harness.check(Float.toString(Math.min(Float.POSITIVE_INFINITY, 0.0f)), (Object)"0.0");
        harness.checkPoint("Float pi");
        harness.check(Float.toString(Math.max((float)Math.PI, 0.0f)), (Object)Float.toString((float)Math.PI));
    }
}

