/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.OutOfMemoryError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        OutOfMemoryError object1 = new OutOfMemoryError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.OutOfMemoryError");
        OutOfMemoryError object2 = new OutOfMemoryError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.OutOfMemoryError: nothing happens");
        OutOfMemoryError object3 = new OutOfMemoryError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.OutOfMemoryError");
    }
}

