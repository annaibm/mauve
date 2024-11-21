/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StackOverflowError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StackOverflowError object1 = new StackOverflowError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.StackOverflowError");
        StackOverflowError object2 = new StackOverflowError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.StackOverflowError: nothing happens");
        StackOverflowError object3 = new StackOverflowError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.StackOverflowError");
    }
}

