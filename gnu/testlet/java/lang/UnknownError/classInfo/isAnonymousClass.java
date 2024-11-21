/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnknownError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAnonymousClass
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnknownError o = new UnknownError("UnknownError");
        Class<?> c = o.getClass();
        harness.check(!c.isAnonymousClass());
    }
}

