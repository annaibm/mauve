/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class max
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Double.toString(Math.max(0.0, -0.0)), (Object)"0.0");
        harness.check(Double.toString(Math.max(-0.0, -0.0)), (Object)"-0.0");
        harness.check(Double.toString(Math.max(-0.0, 0.0)), (Object)"0.0");
        harness.check(Double.toString(Math.max(0.0, 0.0)), (Object)"0.0");
        harness.check(Double.toString(Math.max(1.0, 2.0)), (Object)"2.0");
        harness.check(Double.toString(Math.max(2.0, 1.0)), (Object)"2.0");
        harness.check(Double.toString(Math.max(-1.0, -2.0)), (Object)"-1.0");
        harness.check(Double.toString(Math.max(-2.0, 1.0)), (Object)"1.0");
        harness.check(Double.toString(Math.max(1.0, -2.0)), (Object)"1.0");
        harness.check(Double.toString(Math.max(2.0, Double.NaN)), (Object)"NaN");
        harness.check(Double.toString(Math.max(Double.NaN, 2.0)), (Object)"NaN");
        harness.check(Double.toString(Math.max(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)), (Object)"Infinity");
        harness.check(Double.toString(Math.max(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)), (Object)"Infinity");
        harness.check(Double.toString(Math.max(Double.NEGATIVE_INFINITY, 0.0)), (Object)"0.0");
        harness.check(Double.toString(Math.max(Double.POSITIVE_INFINITY, 0.0)), (Object)"Infinity");
        harness.check(Double.toString(Math.max(Math.PI, 0.0)), (Object)Double.toString(Math.PI));
        harness.check(Float.toString(Math.max(0.0f, -0.0f)), (Object)"0.0");
        harness.check(Float.toString(Math.max(-0.0f, -0.0f)), (Object)"-0.0");
        harness.check(Float.toString(Math.max(-0.0f, 0.0f)), (Object)"0.0");
        harness.check(Float.toString(Math.max(0.0f, 0.0f)), (Object)"0.0");
        harness.check(Float.toString(Math.max(1.0f, 2.0f)), (Object)"2.0");
        harness.check(Float.toString(Math.max(2.0f, 1.0f)), (Object)"2.0");
        harness.check(Float.toString(Math.max(-1.0f, -2.0f)), (Object)"-1.0");
        harness.check(Float.toString(Math.max(-2.0f, 1.0f)), (Object)"1.0");
        harness.check(Float.toString(Math.max(1.0f, -2.0f)), (Object)"1.0");
        harness.check(Float.toString(Math.max(2.0f, Float.NaN)), (Object)"NaN");
        harness.check(Float.toString(Math.max(Float.NaN, 2.0f)), (Object)"NaN");
        harness.check(Float.toString(Math.max(Float.NEGATIVE_INFINITY, Float.POSITIVE_INFINITY)), (Object)"Infinity");
        harness.check(Float.toString(Math.max(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)), (Object)"Infinity");
        harness.check(Float.toString(Math.max(Float.NEGATIVE_INFINITY, 0.0f)), (Object)"0.0");
        harness.check(Float.toString(Math.max(Float.POSITIVE_INFINITY, 0.0f)), (Object)"Infinity");
        harness.check(Float.toString(Math.max((float)Math.PI, 0.0f)), (Object)Float.toString((float)Math.PI));
    }
}

