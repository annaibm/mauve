/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.RuntimeException.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RuntimeException o = new RuntimeException("java.lang.RuntimeException");
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.lang");
    }
}

