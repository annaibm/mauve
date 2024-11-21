/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalThreadStateException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalThreadStateException object1 = new IllegalThreadStateException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IllegalThreadStateException");
        IllegalThreadStateException object2 = new IllegalThreadStateException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IllegalThreadStateException: nothing happens");
        IllegalThreadStateException object3 = new IllegalThreadStateException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IllegalThreadStateException");
    }
}

