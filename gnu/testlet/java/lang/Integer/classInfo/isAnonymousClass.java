/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Integer.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAnonymousClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Integer o = new Integer(42);
        Class<?> c = o.getClass();
        harness.check(!c.isAnonymousClass());
    }
}

