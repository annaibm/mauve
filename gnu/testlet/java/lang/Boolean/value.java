/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class value
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Boolean a = new Boolean("true");
        Boolean b = new Boolean("false");
        harness.check(a);
        harness.check(b == false);
        harness.check(a.equals(Boolean.valueOf("TrUE")));
        harness.check(!b.equals(Boolean.valueOf("TrUE")));
    }
}

