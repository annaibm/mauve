/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.StringTokenizer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.StringTokenizer;

public class countTokens
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        StringTokenizer t1 = new StringTokenizer("one two three");
        harness.check(t1.countTokens(), 3);
        t1.nextToken();
        harness.check(t1.countTokens(), 2);
        t1.nextToken();
        harness.check(t1.countTokens(), 1);
        StringTokenizer t2 = new StringTokenizer("");
        harness.check(t2.countTokens(), 0);
    }
}

