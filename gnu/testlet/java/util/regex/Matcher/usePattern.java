/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex.Matcher;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class usePattern
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Pattern pattern = Pattern.compile("^h");
        Pattern pattern2 = Pattern.compile(".*o$");
        Matcher matcher = pattern.matcher("hello");
        harness.check(matcher.lookingAt(), "Match ^h with original pattern");
        harness.check(!matcher.hitEnd(), "Matcher has not hit the end");
        try {
            matcher.usePattern(null);
            harness.check(false, "Failed to throw IllegalArgumentException");
        }
        catch (IllegalArgumentException e) {
            harness.check(true, "Threw IllegalArgumentException");
        }
        harness.check(matcher.usePattern(pattern2) == matcher, "usePattern returns same matcher");
        harness.check(matcher.lookingAt(), "Match .*o$ with new pattern");
        harness.check(matcher.hitEnd(), "Matcher has hit end");
    }
}

