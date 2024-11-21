/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class InstanceOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Class> o = Class.class;
        harness.check(o instanceof Class);
        harness.check(o instanceof Object);
    }
}

