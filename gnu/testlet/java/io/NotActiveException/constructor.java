/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.NotActiveException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.NotActiveException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NotActiveException object1 = new NotActiveException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.NotActiveException");
        NotActiveException object2 = new NotActiveException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.NotActiveException: nothing happens");
        NotActiveException object3 = new NotActiveException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.NotActiveException");
    }
}

