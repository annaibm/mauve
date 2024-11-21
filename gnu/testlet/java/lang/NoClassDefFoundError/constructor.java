/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.NoClassDefFoundError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        NoClassDefFoundError object1 = new NoClassDefFoundError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.NoClassDefFoundError");
        NoClassDefFoundError object2 = new NoClassDefFoundError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.NoClassDefFoundError: nothing happens");
        NoClassDefFoundError object3 = new NoClassDefFoundError(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.NoClassDefFoundError");
    }
}

