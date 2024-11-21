/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InstantiationError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InstantiationError object1 = new InstantiationError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.InstantiationError");
        InstantiationError object2 = new InstantiationError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.InstantiationError: nothing happens");
        InstantiationError object3 = new InstantiationError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.InstantiationError");
    }
}

