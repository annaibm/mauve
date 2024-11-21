/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.InterruptedException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InterruptedException object1 = new InterruptedException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.InterruptedException");
        InterruptedException object2 = new InterruptedException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.InterruptedException: nothing happens");
        InterruptedException object3 = new InterruptedException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.InterruptedException");
    }
}

