/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NumberFormatException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getEnclosingClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NumberFormatException o = new NumberFormatException("java.lang.NumberFormatException");
        Class<?> c = o.getClass();
        Class<?> cls = c.getEnclosingClass();
        harness.check(cls == null);
    }
}

