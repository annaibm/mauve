/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IncompatibleClassChangeError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IncompatibleClassChangeError object1 = new IncompatibleClassChangeError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IncompatibleClassChangeError");
        IncompatibleClassChangeError object2 = new IncompatibleClassChangeError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IncompatibleClassChangeError: nothing happens");
        IncompatibleClassChangeError object3 = new IncompatibleClassChangeError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IncompatibleClassChangeError");
    }
}

