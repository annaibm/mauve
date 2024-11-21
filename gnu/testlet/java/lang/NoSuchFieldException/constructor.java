/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoSuchFieldException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoSuchFieldException object1 = new NoSuchFieldException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NoSuchFieldException");
        NoSuchFieldException object2 = new NoSuchFieldException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NoSuchFieldException: nothing happens");
        NoSuchFieldException object3 = new NoSuchFieldException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NoSuchFieldException");
    }
}

