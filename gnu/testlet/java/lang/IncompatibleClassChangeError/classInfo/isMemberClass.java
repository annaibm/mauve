/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IncompatibleClassChangeError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isMemberClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IncompatibleClassChangeError o = new IncompatibleClassChangeError("IncompatibleClassChangeError");
        Class<?> c = o.getClass();
        harness.check(!c.isMemberClass());
    }
}

