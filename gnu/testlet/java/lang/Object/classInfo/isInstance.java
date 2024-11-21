/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Object.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isInstance
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Object o = new Object();
        Class<?> c = o.getClass();
        harness.check(c.isInstance(new Object()));
    }
}

