/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchFieldException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getSuperclass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchFieldException o = new NoSuchFieldException("java.lang.NoSuchFieldException");
        Class<?> c = o.getClass();
        Class<?> superClass = c.getSuperclass();
        harness.check(superClass.getName().equals("java.lang.Exception") || superClass.getName().equals("java.lang.ReflectiveOperationException"));
    }
}

