/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassCastException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isPrimitive
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassCastException o = new ClassCastException("java.lang.ClassCastException");
        Class<?> c = o.getClass();
        harness.check(!c.isPrimitive());
    }
}

