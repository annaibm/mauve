/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedOperationException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isEnum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedOperationException o = new UnsupportedOperationException("java.lang.UnsupportedOperationException");
        Class<?> c = o.getClass();
        harness.check(!c.isEnum());
    }
}

