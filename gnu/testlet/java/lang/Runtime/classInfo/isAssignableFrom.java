/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Runtime.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Runtime o = Runtime.getRuntime();
        Class<Runtime> c = o.getClass();
        harness.check(c.isAssignableFrom(Runtime.class));
    }
}

