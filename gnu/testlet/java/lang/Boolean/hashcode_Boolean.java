/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class hashcode_Boolean
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Boolean a = new Boolean("true");
        Boolean b = new Boolean("false");
        harness.check(a.hashCode(), 1231);
        harness.check(b.hashCode(), 1237);
    }
}

