/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArithmeticException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArithmeticException object1 = new ArithmeticException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ArithmeticException");
        ArithmeticException object2 = new ArithmeticException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ArithmeticException: nothing happens");
        ArithmeticException object3 = new ArithmeticException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ArithmeticException");
    }
}

