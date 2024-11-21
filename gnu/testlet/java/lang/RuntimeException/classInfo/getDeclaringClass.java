/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.RuntimeException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaringClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RuntimeException o = new RuntimeException("java.lang.RuntimeException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getDeclaringClass();
        harness.check(cls == null);
    }
}

