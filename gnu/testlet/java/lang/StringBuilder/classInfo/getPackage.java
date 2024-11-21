/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuilder.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringBuilder o = new StringBuilder("xyzzy");
        Class<?> c = o.getClass();
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.lang");
    }
}

