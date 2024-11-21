/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Double.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Double o = new Double(42.0);
        Class<Double> c = o.getClass();
        harness.check(c.isAssignableFrom(Double.class));
    }
}

