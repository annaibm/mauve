/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.AssertionError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AssertionError error1 = new AssertionError();
        harness.check(error1 != null);
        harness.check(((Throwable)((Object)error1)).toString(), (Object)"java.lang.AssertionError");
        AssertionError error2 = new AssertionError(true);
        harness.check(error2 != null);
        harness.check(((Throwable)((Object)error2)).toString(), (Object)"java.lang.AssertionError: true");
        AssertionError error3 = new AssertionError(false);
        harness.check(error3 != null);
        harness.check(((Throwable)((Object)error3)).toString(), (Object)"java.lang.AssertionError: false");
        AssertionError error4 = new AssertionError('*');
        harness.check(error4 != null);
        harness.check(((Throwable)((Object)error4)).toString(), (Object)"java.lang.AssertionError: *");
        AssertionError error5 = new AssertionError(42);
        harness.check(error5 != null);
        harness.check(((Throwable)((Object)error5)).toString(), (Object)"java.lang.AssertionError: 42");
        AssertionError error6 = new AssertionError(42L);
        harness.check(error6 != null);
        harness.check(((Throwable)((Object)error6)).toString(), (Object)"java.lang.AssertionError: 42");
        AssertionError error7 = new AssertionError(42.0);
        harness.check(error7 != null);
        harness.check(((Throwable)((Object)error7)).toString(), (Object)"java.lang.AssertionError: 42.0");
        AssertionError error8 = new AssertionError(42.0f);
        harness.check(error8 != null);
        harness.check(((Throwable)((Object)error8)).toString(), (Object)"java.lang.AssertionError: 42.0");
        AssertionError error9 = new AssertionError((Object)"xyzzy");
        harness.check(error9 != null);
        harness.check(((Throwable)((Object)error9)).toString(), (Object)"java.lang.AssertionError: xyzzy");
    }
}

