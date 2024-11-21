/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.AssertionError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AssertionError o = new AssertionError();
        Class<?> c = o.getClass();
        harness.check(c.getName(), (Object)"java.lang.AssertionError");
    }
}

