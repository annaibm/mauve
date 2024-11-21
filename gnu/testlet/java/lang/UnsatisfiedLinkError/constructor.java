/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsatisfiedLinkError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsatisfiedLinkError object1 = new UnsatisfiedLinkError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.UnsatisfiedLinkError");
        UnsatisfiedLinkError object2 = new UnsatisfiedLinkError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.UnsatisfiedLinkError: nothing happens");
        UnsatisfiedLinkError object3 = new UnsatisfiedLinkError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.UnsatisfiedLinkError");
    }
}

