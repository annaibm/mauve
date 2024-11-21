/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class valueOfString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(Boolean.valueOf("true"), Boolean.TRUE);
        harness.check(Boolean.valueOf("false"), Boolean.FALSE);
        harness.check(Boolean.valueOf("TRUE"), Boolean.TRUE);
        harness.check(Boolean.valueOf("FALSE"), Boolean.FALSE);
        harness.check(Boolean.valueOf("tRUE"), Boolean.TRUE);
        harness.check(Boolean.valueOf("fALSE"), Boolean.FALSE);
        harness.check(Boolean.valueOf("tRUe"), Boolean.TRUE);
        harness.check(Boolean.valueOf("fALSe"), Boolean.FALSE);
    }
}

