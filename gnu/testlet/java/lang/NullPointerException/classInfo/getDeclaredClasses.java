/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NullPointerException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaredClasses
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NullPointerException o = new NullPointerException("java.lang.NullPointerException");
        Class<?> c = o.getClass();
        Class<?>[] cls = c.getDeclaredClasses();
        harness.check(cls != null);
        harness.check(cls.length, 0);
    }
}

