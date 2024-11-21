/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class equals_Boolean
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Boolean a = new Boolean("true");
        Boolean b = new Boolean("false");
        Integer i = new Integer(123);
        harness.check(!a.equals(null));
        harness.check(!a.equals(b));
        harness.check(a.equals(Boolean.TRUE));
        harness.check(!a.equals(Boolean.FALSE));
        harness.check(b.equals(Boolean.FALSE));
        harness.check(!b.equals(i));
    }
}

