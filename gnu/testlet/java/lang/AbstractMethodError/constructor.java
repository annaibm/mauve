/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.AbstractMethodError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AbstractMethodError error1 = new AbstractMethodError();
        harness.check(error1 != null);
        harness.check(error1.toString(), (Object)"java.lang.AbstractMethodError");
        AbstractMethodError error2 = new AbstractMethodError("nothing happens");
        harness.check(error2 != null);
        harness.check(error2.toString(), (Object)"java.lang.AbstractMethodError: nothing happens");
        AbstractMethodError error3 = new AbstractMethodError(null);
        harness.check(error3 != null);
        harness.check(error3.toString(), (Object)"java.lang.AbstractMethodError");
    }
}

