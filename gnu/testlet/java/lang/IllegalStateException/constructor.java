/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalStateException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalStateException object1 = new IllegalStateException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IllegalStateException");
        IllegalStateException object2 = new IllegalStateException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IllegalStateException: nothing happens");
        IllegalStateException object3 = new IllegalStateException((String)null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IllegalStateException");
        IllegalStateException object4 = new IllegalStateException(new Throwable());
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.IllegalStateException: java.lang.Throwable");
        IllegalStateException object5 = new IllegalStateException((Throwable)null);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.IllegalStateException");
        IllegalStateException object6 = new IllegalStateException("nothing", new Throwable());
        harness.check(object6 != null);
        harness.check(object6.toString(), (Object)"java.lang.IllegalStateException: nothing");
    }
}

