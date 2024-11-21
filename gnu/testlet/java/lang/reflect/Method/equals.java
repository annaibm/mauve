/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.reflect.Method;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.lang.reflect.Method;

public class equals
implements Testlet {
    void q() {
    }

    void r() {
    }

    public String toString() {
        return "funny equals class thing";
    }

    public void m() {
    }

    public void m(String s) {
    }

    private Method getMethod(Class c, String n, Class[] ts) {
        try {
            return c.getDeclaredMethod(n, ts);
        }
        catch (NoSuchMethodException nsme) {
            throw new RuntimeException("Warning - no such method: " + c + ", " + n);
        }
    }

    @Override
    public void test(TestHarness harness) {
        Class[] ts = new Class[]{};
        Method m1 = this.getMethod(equals.class, "q", ts);
        Method m2 = this.getMethod(equals.class, "q", ts);
        harness.check(m1.equals(m2), "same method q");
        m2 = this.getMethod(equals.class, "r", ts);
        harness.check(!m1.equals(m2), "different method names q and r");
        m1 = this.getMethod(String.class, "toString", ts);
        m2 = this.getMethod(equals.class, "toString", ts);
        harness.check(!m1.equals(m2), "different declaring classes for toString");
        m1 = this.getMethod(equals.class, "m", ts);
        ts = new Class[]{String.class};
        m2 = this.getMethod(equals.class, "m", ts);
        harness.check(!m1.equals(m2), "different argument types m");
        harness.check(!m1.equals(null), "nothing equals null");
    }
}

