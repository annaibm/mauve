/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringIndexOutOfBoundsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringIndexOutOfBoundsException object1 = new StringIndexOutOfBoundsException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.StringIndexOutOfBoundsException");
        StringIndexOutOfBoundsException object2 = new StringIndexOutOfBoundsException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.StringIndexOutOfBoundsException: nothing happens");
        StringIndexOutOfBoundsException object3 = new StringIndexOutOfBoundsException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.StringIndexOutOfBoundsException");
        StringIndexOutOfBoundsException object4 = new StringIndexOutOfBoundsException(1);
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.StringIndexOutOfBoundsException: String index out of range: 1");
        StringIndexOutOfBoundsException object5 = new StringIndexOutOfBoundsException(Integer.MAX_VALUE);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.StringIndexOutOfBoundsException: String index out of range: 2147483647");
        StringIndexOutOfBoundsException object6 = new StringIndexOutOfBoundsException(Integer.MIN_VALUE);
        harness.check(object6 != null);
        harness.check(object6.toString(), (Object)"java.lang.StringIndexOutOfBoundsException: String index out of range: -2147483648");
    }
}

