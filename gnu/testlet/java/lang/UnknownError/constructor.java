/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnknownError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnknownError object1 = new UnknownError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.UnknownError");
        UnknownError object2 = new UnknownError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.UnknownError: nothing happens");
        UnknownError object3 = new UnknownError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.UnknownError");
    }
}

