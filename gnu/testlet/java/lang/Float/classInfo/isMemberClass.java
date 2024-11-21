/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Float.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isMemberClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Float o = new Float(42.0f);
        Class<?> c = o.getClass();
        harness.check(!c.isMemberClass());
    }
}

