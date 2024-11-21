/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InstantiationException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InstantiationException object1 = new InstantiationException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.InstantiationException");
        InstantiationException object2 = new InstantiationException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.InstantiationException: nothing happens");
        InstantiationException object3 = new InstantiationException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.InstantiationException");
    }
}

