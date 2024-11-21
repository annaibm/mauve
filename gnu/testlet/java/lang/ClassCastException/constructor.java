/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ClassCastException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ClassCastException object1 = new ClassCastException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ClassCastException");
        ClassCastException object2 = new ClassCastException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ClassCastException: nothing happens");
        ClassCastException object3 = new ClassCastException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ClassCastException");
    }
}

