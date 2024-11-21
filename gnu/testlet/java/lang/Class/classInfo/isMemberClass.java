/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Class.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isMemberClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Class<Class> c = Class.class;
        harness.check(!c.isMemberClass());
    }
}

