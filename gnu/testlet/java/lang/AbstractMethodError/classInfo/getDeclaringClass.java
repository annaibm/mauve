/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.AbstractMethodError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getDeclaringClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AbstractMethodError o = new AbstractMethodError("AbstractMethodError");
        Class<?> c = o.getClass();
        Class<?> cls = c.getDeclaringClass();
        harness.check(cls == null);
    }
}

