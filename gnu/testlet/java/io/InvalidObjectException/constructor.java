/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InvalidObjectException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InvalidObjectException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InvalidObjectException object1 = new InvalidObjectException("nothing happens");
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.InvalidObjectException: nothing happens");
        InvalidObjectException object2 = new InvalidObjectException(null);
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.InvalidObjectException");
    }
}

