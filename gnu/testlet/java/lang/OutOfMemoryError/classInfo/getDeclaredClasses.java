/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.OutOfMemoryError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaredClasses
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        OutOfMemoryError o = new OutOfMemoryError("OutOfMemoryError");
        Class<?> c = o.getClass();
        Class<?>[] cls = c.getDeclaredClasses();
        harness.check(cls != null);
        harness.check(cls.length, 0);
    }
}

