/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.VerifyError.classInfo;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class isAssignableFrom
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        VerifyError o = new VerifyError("VerifyError");
        Class<VerifyError> c = o.getClass();
        harness.check(c.isAssignableFrom(VerifyError.class));
    }
}

