/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NullPointerException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NullPointerException object1 = new NullPointerException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NullPointerException");
        NullPointerException object2 = new NullPointerException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NullPointerException: nothing happens");
        NullPointerException object3 = new NullPointerException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NullPointerException");
    }
}

