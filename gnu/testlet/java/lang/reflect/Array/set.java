/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Array;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Array;

public class set
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Throwable[] x = new Throwable[5];
        Array.set(x, 0, null);
        harness.check(x[0], null);
        Throwable t = new Throwable();
        Array.set(x, 1, t);
        harness.check(x[1], t);
        Exception e = new Exception();
        Array.set(x, 2, e);
        harness.check(x[2], e);
        Object o = new Object();
        boolean exception_thrown = false;
        try {
            Array.set(x, 3, o);
        }
        catch (IllegalArgumentException iae) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
        harness.check(x[3], null);
        String s = "string";
        exception_thrown = false;
        try {
            Array.set(x, 4, s);
        }
        catch (IllegalArgumentException iae) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
        harness.check(x[4], null);
        exception_thrown = false;
        try {
            Array.set(x, 5, t);
        }
        catch (ArrayIndexOutOfBoundsException aioobe) {
            exception_thrown = true;
        }
        harness.check(exception_thrown);
    }
}

