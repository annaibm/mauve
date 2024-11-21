/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.ArrayIndexOutOfBoundsException;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ArrayIndexOutOfBoundsException object1 = new ArrayIndexOutOfBoundsException();
        harness.check(object1 != null);
        harness.check(object1.toString(), (Object)"java.lang.ArrayIndexOutOfBoundsException");
        ArrayIndexOutOfBoundsException object2 = new ArrayIndexOutOfBoundsException("nothing happens");
        harness.check(object2 != null);
        harness.check(object2.toString(), (Object)"java.lang.ArrayIndexOutOfBoundsException: nothing happens");
        ArrayIndexOutOfBoundsException object3 = new ArrayIndexOutOfBoundsException(null);
        harness.check(object3 != null);
        harness.check(object3.toString(), (Object)"java.lang.ArrayIndexOutOfBoundsException");
        ArrayIndexOutOfBoundsException object4 = new ArrayIndexOutOfBoundsException(0);
        harness.check(object4 != null);
        harness.check(object4.toString(), (Object)"java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 0");
        ArrayIndexOutOfBoundsException object5 = new ArrayIndexOutOfBoundsException(-1);
        harness.check(object5 != null);
        harness.check(object5.toString(), (Object)"java.lang.ArrayIndexOutOfBoundsException: Array index out of range: -1");
        ArrayIndexOutOfBoundsException object6 = new ArrayIndexOutOfBoundsException(Integer.MAX_VALUE);
        harness.check(object6 != null);
        harness.check(object6.toString(), (Object)"java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 2147483647");
    }
}

