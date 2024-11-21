/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalAccessError object1 = new IllegalAccessError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IllegalAccessError");
        IllegalAccessError object2 = new IllegalAccessError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IllegalAccessError: nothing happens");
        IllegalAccessError object3 = new IllegalAccessError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IllegalAccessError");
    }
}

