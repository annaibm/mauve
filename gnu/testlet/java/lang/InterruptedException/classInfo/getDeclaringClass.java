/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InterruptedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaringClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InterruptedException o = new InterruptedException("java.lang.InterruptedException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getDeclaringClass();
        harness.check(cls == null);
    }
}

