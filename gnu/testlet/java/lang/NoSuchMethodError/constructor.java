/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchMethodError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchMethodError object1 = new NoSuchMethodError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NoSuchMethodError");
        NoSuchMethodError object2 = new NoSuchMethodError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NoSuchMethodError: nothing happens");
        NoSuchMethodError object3 = new NoSuchMethodError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NoSuchMethodError");
    }
}

