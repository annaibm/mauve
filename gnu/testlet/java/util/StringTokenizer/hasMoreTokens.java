/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.StringTokenizer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.StringTokenizer;

public class hasMoreTokens
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringTokenizer t1 = new StringTokenizer("one two");
        harness.check(t1.hasMoreTokens());
        t1.nextToken();
        harness.check(t1.hasMoreTokens());
        t1.nextToken();
        harness.check(!t1.hasMoreTokens());
        StringTokenizer t2 = new StringTokenizer("");
        harness.check(!t2.hasMoreTokens());
    }
}

