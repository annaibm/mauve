/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InterruptedException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getEnclosingClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InterruptedException o = new InterruptedException("java.lang.InterruptedException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getEnclosingClass();
        harness.check(cls == null);
    }
}

