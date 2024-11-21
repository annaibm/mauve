/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class getName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Class> o = Class.class;
        Class<?> c = o.getClass();
        harness.check(c.getName(), (Object)"java.lang.Class");
    }
}

