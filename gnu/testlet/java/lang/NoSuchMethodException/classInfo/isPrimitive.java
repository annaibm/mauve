/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchMethodException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isPrimitive
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchMethodException o = new NoSuchMethodException("java.lang.NoSuchMethodException");
        Class<?> c = o.getClass();
        harness.check(!c.isPrimitive());
    }
}

