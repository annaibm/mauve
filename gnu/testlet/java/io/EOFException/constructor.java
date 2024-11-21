/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.EOFException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.EOFException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        EOFException object1 = new EOFException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.EOFException");
        EOFException object2 = new EOFException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.EOFException: nothing happens");
        EOFException object3 = new EOFException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.EOFException");
    }
}

