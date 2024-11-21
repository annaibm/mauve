/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Byte.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaredClasses
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Byte o = new Byte(42);
        Class<?> c = o.getClass();
        Class<?>[] cls = c.getDeclaredClasses();
        harness.check(cls != null);
        harness.check(cls.length, 1);
    }
}

