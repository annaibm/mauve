/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.UnsupportedClassVersionError;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedClassVersionError object1 = new UnsupportedClassVersionError();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.UnsupportedClassVersionError");
        UnsupportedClassVersionError object2 = new UnsupportedClassVersionError("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.UnsupportedClassVersionError: nothing happens");
    }
}

