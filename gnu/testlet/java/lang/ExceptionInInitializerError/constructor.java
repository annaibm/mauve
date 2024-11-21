/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ExceptionInInitializerError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ExceptionInInitializerError object1 = new ExceptionInInitializerError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ExceptionInInitializerError");
        ExceptionInInitializerError object2 = new ExceptionInInitializerError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ExceptionInInitializerError: nothing happens");
        ExceptionInInitializerError object3 = new ExceptionInInitializerError(new Throwable());
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ExceptionInInitializerError");
    }
}

