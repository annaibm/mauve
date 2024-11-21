/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Boolean o = new Boolean(true);
        Class<Boolean> c = o.getClass();
        harness.check(c.isAssignableFrom(Boolean.class));
    }
}

