/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.RuntimeException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;

public class getEnclosingMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RuntimeException o = new RuntimeException("java.lang.RuntimeException");
        Class<?> c = o.getClass();
        Method m = c.getEnclosingMethod();
        harness.check(m == null);
    }
}

