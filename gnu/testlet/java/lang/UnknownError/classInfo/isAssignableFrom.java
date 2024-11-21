/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnknownError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnknownError o = new UnknownError("UnknownError");
        Class<UnknownError> c = o.getClass();
        harness.check(c.isAssignableFrom(UnknownError.class));
    }
}

