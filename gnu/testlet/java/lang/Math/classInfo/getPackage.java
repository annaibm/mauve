/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Math.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getPackage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Math> c = Math.class;
        Package p = c.getPackage();
        harness.check(p.getName(), (Object)"java.lang");
    }
}

