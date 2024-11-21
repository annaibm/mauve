/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InheritableThreadLocal.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InheritableThreadLocal o = new InheritableThreadLocal();
        Class<InheritableThreadLocal> c = o.getClass();
        harness.check(c.isAssignableFrom(InheritableThreadLocal.class));
    }
}

