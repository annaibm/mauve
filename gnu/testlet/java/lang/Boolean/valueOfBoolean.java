/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOfBoolean
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check((Object)true, Boolean.TRUE);
        harness.check((Object)false, Boolean.FALSE);
    }
}

