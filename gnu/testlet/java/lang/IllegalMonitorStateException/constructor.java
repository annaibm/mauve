/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IllegalMonitorStateException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IllegalMonitorStateException object1 = new IllegalMonitorStateException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IllegalMonitorStateException");
        IllegalMonitorStateException object2 = new IllegalMonitorStateException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IllegalMonitorStateException: nothing happens");
        IllegalMonitorStateException object3 = new IllegalMonitorStateException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IllegalMonitorStateException");
    }
}

