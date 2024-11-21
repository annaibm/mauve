/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(new Boolean(true).toString(), (Object)"true");
        harness.check(new Boolean(false).toString(), (Object)"false");
        harness.check(new Boolean("true").toString(), (Object)"true");
        harness.check(new Boolean("false").toString(), (Object)"false");
        harness.check(Boolean.toString(true), (Object)"true");
        harness.check(Boolean.toString(false), (Object)"false");
        harness.check(Boolean.toString(Boolean.TRUE), (Object)"true");
        harness.check(Boolean.toString(Boolean.FALSE), (Object)"false");
    }
}

