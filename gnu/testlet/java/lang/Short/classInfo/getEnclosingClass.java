/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Short.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getEnclosingClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Short o = new Short("42");
        Class<?> c = o.getClass();
        Class<?> cls = c.getEnclosingClass();
        harness.check(cls == null);
    }
}

