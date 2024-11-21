/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchFieldError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getClasses
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchFieldError o = new NoSuchFieldError("NoSuchFieldError");
        Class<?> c = o.getClass();
        Class<?>[] cls = c.getClasses();
        harness.check(cls != null);
        harness.check(cls.length, 0);
    }
}

