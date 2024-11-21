/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArrayStoreException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayStoreException object1 = new ArrayStoreException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ArrayStoreException");
        ArrayStoreException object2 = new ArrayStoreException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ArrayStoreException: nothing happens");
        ArrayStoreException object3 = new ArrayStoreException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ArrayStoreException");
    }
}

