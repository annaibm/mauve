/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaringClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalStateException o = new IllegalStateException("java.lang.IllegalStateException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getDeclaringClass();
        harness.check(cls == null);
    }
}

