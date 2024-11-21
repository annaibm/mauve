/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalArgumentException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalArgumentException object1 = new IllegalArgumentException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IllegalArgumentException");
        IllegalArgumentException object2 = new IllegalArgumentException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IllegalArgumentException: nothing happens");
        IllegalArgumentException object3 = new IllegalArgumentException((String)null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IllegalArgumentException");
        IllegalArgumentException object4 = new IllegalArgumentException(new Throwable());
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.IllegalArgumentException: java.lang.Throwable");
        IllegalArgumentException object5 = new IllegalArgumentException((Throwable)null);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.IllegalArgumentException");
        IllegalArgumentException object6 = new IllegalArgumentException("nothing", new Throwable());
        harness.check(object6 != null);
        harness.check(object6.toString(), (Object)"java.lang.IllegalArgumentException: nothing");
    }
}

