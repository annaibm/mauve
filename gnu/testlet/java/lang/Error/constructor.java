/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Error;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Error error1 = new Error();
        harness.check(error1 != null);
        harness.check(error1.toString(), (Object)"java.lang.Error");
        Error error2 = new Error("nothing happens");
        harness.check(error2 != null);
        harness.check(error2.toString(), (Object)"java.lang.Error: nothing happens");
        Error error3 = new Error(new Throwable());
        harness.check(error3 != null);
        harness.check(error3.toString(), (Object)"java.lang.Error: java.lang.Throwable");
        Error error4 = new Error("nothing happens", new Throwable());
        harness.check(error4 != null);
        harness.check(error4.toString(), (Object)"java.lang.Error: nothing happens");
    }
}

