/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InterruptedIOException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InterruptedIOException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InterruptedIOException object1 = new InterruptedIOException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.InterruptedIOException");
        InterruptedIOException object2 = new InterruptedIOException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.InterruptedIOException: nothing happens");
        InterruptedIOException object3 = new InterruptedIOException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.InterruptedIOException");
    }
}

