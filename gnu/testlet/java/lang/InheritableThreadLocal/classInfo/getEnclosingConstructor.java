/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InheritableThreadLocal.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Constructor;

public class getEnclosingConstructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InheritableThreadLocal o = new InheritableThreadLocal();
        Class<?> c = o.getClass();
        Constructor<?> cons = c.getEnclosingConstructor();
        harness.check(cons == null);
    }
}

