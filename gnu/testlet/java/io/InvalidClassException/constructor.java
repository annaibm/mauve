/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.InvalidClassException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.InvalidClassException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        InvalidClassException object1 = new InvalidClassException("nothing happens");
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.InvalidClassException: nothing happens");
        InvalidClassException object2 = new InvalidClassException(null);
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.InvalidClassException");
    }
}

