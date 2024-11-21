/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaringClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Class> c = Class.class;
        Class<?> cls = c.getDeclaringClass();
        harness.check(cls == null);
    }
}

