/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.IOError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.IOError;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IOError object1 = new IOError(new Throwable("e"));
        harness.check(object1 != null);
        harness.check(object1.toString().contains("java.io.IOError"));
        harness.check(object1.toString().contains("Throwable"));
        IOError object2 = new IOError(null);
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.IOError");
    }
}

