/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalAccessException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalAccessException object1 = new IllegalAccessException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IllegalAccessException");
        IllegalAccessException object2 = new IllegalAccessException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IllegalAccessException: nothing happens");
        IllegalAccessException object3 = new IllegalAccessException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IllegalAccessException");
    }
}

