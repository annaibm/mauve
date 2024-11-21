/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchMethodException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchMethodException object1 = new NoSuchMethodException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NoSuchMethodException");
        NoSuchMethodException object2 = new NoSuchMethodException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NoSuchMethodException: nothing happens");
        NoSuchMethodException object3 = new NoSuchMethodException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NoSuchMethodException");
    }
}

