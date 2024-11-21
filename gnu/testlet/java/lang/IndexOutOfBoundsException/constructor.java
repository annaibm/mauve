/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.IndexOutOfBoundsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        IndexOutOfBoundsException object1 = new IndexOutOfBoundsException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.IndexOutOfBoundsException");
        IndexOutOfBoundsException object2 = new IndexOutOfBoundsException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.IndexOutOfBoundsException: nothing happens");
        IndexOutOfBoundsException object3 = new IndexOutOfBoundsException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.IndexOutOfBoundsException");
    }
}

