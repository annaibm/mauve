/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex.Pattern;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class matches
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        try {
            harness.check(!Pattern.matches("b", "ab"));
            harness.check(Pattern.matches("ab", "ab"));
            harness.check(!Pattern.matches("abab", "abababab"));
            harness.check(Pattern.matches("abababab", "abababab"));
            harness.check(!Pattern.matches("(\\w,)+", "a,b,c,d,e"));
            harness.check(Pattern.matches("(\\w,)+", "a,b,c,d,e,"));
            harness.check(!Pattern.matches("\\d+", "123,456"));
            harness.check(Pattern.matches("\\d+,\\d+", "123,456"));
            harness.check(!Pattern.matches("\\d+,\\d+", "123,456,789"));
            harness.check(Pattern.matches("\\d+,\\d+,\\d+", "123,456,789"));
            harness.check(!Pattern.matches("\\d+,\\d+,\\d+,", "123,456,789"));
            harness.check(Pattern.matches("\\d+,\\d+,\\d+,", "123,456,789,"));
            harness.check(!Pattern.matches("[a-c]", "abc"));
            harness.check(!Pattern.matches("[a-c][a-c]", "abc"));
            harness.check(Pattern.matches("[a-c][a-c][a-c]", "abc"));
            harness.check(!Pattern.matches("[a-c][a-c][a-c][a-c]", "abc"));
            harness.check(!Pattern.matches("[a-z]*", "abc1defZghi"));
            harness.check(!Pattern.matches("([a-z]|\\d)*", "abc1defZghi"));
            harness.check(Pattern.matches("([a-z]|\\d|[A-Z])*", "abc1defZghi"));
            harness.check(!Pattern.matches("([a-z]|\\d|[A-Z])*", ",abc1defZghi"));
            harness.check(!Pattern.matches("([a-z]|\\d|[A-Z])*", "abc1defZghi,"));
            harness.check(!Pattern.matches("([a-z]|\\d|[A-Z])*", ",abc1defZghi,"));
            harness.check(Pattern.matches("()*", ""));
            harness.check(!Pattern.matches("()*", "x"));
            harness.check(Pattern.matches("(b*c*)*", ""));
            harness.check(Pattern.matches("(b*c*)*", "cbbcbbb"));
            harness.check(Pattern.matches("(b*c*)+", ""));
            harness.check(Pattern.matches("(b*c*)+", "cbbcbbb"));
            harness.check(Pattern.matches("(b*c*){3,}", "cbbcbbb"));
            harness.check(Pattern.matches("(b*c*){10,}", "cbbcbbb"));
        }
        catch (PatternSyntaxException pse) {
            harness.debug(pse);
            harness.check(false, pse.toString());
        }
    }
}

