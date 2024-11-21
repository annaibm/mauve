/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.VerifyError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        VerifyError object1 = new VerifyError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.VerifyError");
        VerifyError object2 = new VerifyError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.VerifyError: nothing happens");
        VerifyError object3 = new VerifyError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.VerifyError");
    }
}

