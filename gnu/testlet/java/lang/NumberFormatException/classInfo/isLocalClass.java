/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NumberFormatException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isLocalClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NumberFormatException o = new NumberFormatException("java.lang.NumberFormatException");
        Class<?> c = o.getClass();
        harness.check(!c.isLocalClass());
    }
}

