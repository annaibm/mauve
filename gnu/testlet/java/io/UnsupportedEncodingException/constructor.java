/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.io.UnsupportedEncodingException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.UnsupportedEncodingException;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UnsupportedEncodingException object1 = new UnsupportedEncodingException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.io.UnsupportedEncodingException");
        UnsupportedEncodingException object2 = new UnsupportedEncodingException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.io.UnsupportedEncodingException: nothing happens");
        UnsupportedEncodingException object3 = new UnsupportedEncodingException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.io.UnsupportedEncodingException");
    }
}

