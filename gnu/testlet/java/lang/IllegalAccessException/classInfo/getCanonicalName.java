/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getCanonicalName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalAccessException o = new IllegalAccessException("java.lang.IllegalAccessException");
        Class<?> c = o.getClass();
        harness.check(c.getCanonicalName(), (Object)"java.lang.IllegalAccessException");
    }
}

