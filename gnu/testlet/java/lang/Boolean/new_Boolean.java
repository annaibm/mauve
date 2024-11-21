/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Boolean;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class new_Boolean
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Boolean a = new Boolean("true");
        Boolean b = new Boolean("TRUE");
        Boolean c = new Boolean("tRuE");
        Boolean d = new Boolean("false");
        Boolean e = new Boolean("foo");
        Boolean f = new Boolean("");
        Boolean g = new Boolean(true);
        Boolean h = new Boolean(false);
        harness.check(a);
        harness.check(b);
        harness.check(c);
        harness.check(d == false);
        harness.check(e == false);
        harness.check(f == false);
        harness.check(g);
        harness.check(h == false);
    }
}

