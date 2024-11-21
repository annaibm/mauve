/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.RuntimeException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        RuntimeException object1 = new RuntimeException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.RuntimeException");
        RuntimeException object2 = new RuntimeException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.RuntimeException: nothing happens");
        RuntimeException object3 = new RuntimeException((String)null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.RuntimeException");
        RuntimeException object4 = new RuntimeException(new Throwable());
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.RuntimeException: java.lang.Throwable");
        RuntimeException object5 = new RuntimeException((Throwable)null);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.RuntimeException");
        RuntimeException object6 = new RuntimeException("nothing", new Throwable());
        harness.check(object6 != null);
        harness.check(object6.toString(), (Object)"java.lang.RuntimeException: nothing");
    }
}

