/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NumberFormatException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NumberFormatException object1 = new NumberFormatException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NumberFormatException");
        NumberFormatException object2 = new NumberFormatException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NumberFormatException: nothing happens");
        NumberFormatException object3 = new NumberFormatException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NumberFormatException");
    }
}

