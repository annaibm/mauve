/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.SecurityException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SecurityException object1 = new SecurityException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.SecurityException");
        SecurityException object2 = new SecurityException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.SecurityException: nothing happens");
        SecurityException object3 = new SecurityException((String)null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.SecurityException");
        SecurityException object4 = new SecurityException(new Throwable());
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.SecurityException: java.lang.Throwable");
        SecurityException object5 = new SecurityException((Throwable)null);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.SecurityException");
        SecurityException object6 = new SecurityException("nothing", new Throwable());
        harness.check(object6 != null);
        harness.check(object6.toString(), (Object)"java.lang.SecurityException: nothing");
    }
}

