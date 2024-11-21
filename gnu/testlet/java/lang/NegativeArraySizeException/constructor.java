/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NegativeArraySizeException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NegativeArraySizeException object1 = new NegativeArraySizeException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NegativeArraySizeException");
        NegativeArraySizeException object2 = new NegativeArraySizeException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NegativeArraySizeException: nothing happens");
        NegativeArraySizeException object3 = new NegativeArraySizeException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NegativeArraySizeException");
    }
}

