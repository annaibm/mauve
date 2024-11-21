/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnknownError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;

public class getEnclosingMethod
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnknownError o = new UnknownError("UnknownError");
        Class<?> c = o.getClass();
        Method m = c.getEnclosingMethod();
        harness.check(m == null);
    }
}

