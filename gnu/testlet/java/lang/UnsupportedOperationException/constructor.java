/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedOperationException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedOperationException object1 = new UnsupportedOperationException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.UnsupportedOperationException");
        UnsupportedOperationException object2 = new UnsupportedOperationException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.UnsupportedOperationException: nothing happens");
        UnsupportedOperationException object3 = new UnsupportedOperationException((String)null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.UnsupportedOperationException");
        UnsupportedOperationException object4 = new UnsupportedOperationException(new Throwable());
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.UnsupportedOperationException: java.lang.Throwable");
        UnsupportedOperationException object5 = new UnsupportedOperationException((Throwable)null);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.UnsupportedOperationException");
        UnsupportedOperationException object6 = new UnsupportedOperationException("nothing", new Throwable());
        harness.check(object6 != null);
        harness.check(object6.toString(), (Object)"java.lang.UnsupportedOperationException: nothing");
    }
}

