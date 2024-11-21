/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.SecurityException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getComponentType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SecurityException o = new SecurityException("java.lang.SecurityException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getComponentType();
        harness.check(cls == null);
    }
}

