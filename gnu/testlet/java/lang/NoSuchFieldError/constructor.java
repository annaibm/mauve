/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchFieldError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchFieldError object1 = new NoSuchFieldError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NoSuchFieldError");
        NoSuchFieldError object2 = new NoSuchFieldError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NoSuchFieldError: nothing happens");
        NoSuchFieldError object3 = new NoSuchFieldError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NoSuchFieldError");
    }
}

