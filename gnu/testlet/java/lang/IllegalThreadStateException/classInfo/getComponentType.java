/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalThreadStateException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getComponentType
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalThreadStateException o = new IllegalThreadStateException("java.lang.IllegalThreadStateException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getComponentType();
        harness.check(cls == null);
    }
}

