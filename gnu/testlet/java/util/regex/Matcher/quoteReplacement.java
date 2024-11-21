/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex.Matcher;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.regex.Matcher;

public class quoteReplacement
implements Testlet {
    private Matcher matcher;

    @Override
    public void test(TestHarness harness) {
        try {
            Matcher.quoteReplacement(null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        harness.check(Matcher.quoteReplacement("hello, world"), (Object)"hello, world");
        harness.check(Matcher.quoteReplacement("$"), (Object)"\\$");
        harness.check(Matcher.quoteReplacement("\\"), (Object)"\\\\");
    }
}

