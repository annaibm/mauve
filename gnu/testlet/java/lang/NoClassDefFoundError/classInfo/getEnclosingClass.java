/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoClassDefFoundError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getEnclosingClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoClassDefFoundError o = new NoClassDefFoundError("NoClassDefFoundError");
        Class<?> c = o.getClass();
        Class<?> cls = c.getEnclosingClass();
        harness.check(cls == null);
    }
}

