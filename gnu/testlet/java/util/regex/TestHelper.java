/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex;

import gnu.testlet.TestHarness;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class TestHelper {
    private final TestHarness harness;

    TestHelper(TestHarness harness) {
        this.harness = harness;
    }

    void testEmpty(Pattern pattern, boolean matches2) {
        this.harness.checkPoint("testEmpty static Pattern.matches(" + pattern.pattern() + ")");
        try {
            this.harness.check(matches2 == Pattern.matches(pattern.pattern(), ""));
        }
        catch (PatternSyntaxException pse) {
            this.harness.debug(pse);
            this.harness.check(false);
        }
        this.harness.checkPoint("testEmpty '" + pattern.pattern() + "' flags " + pattern.flags());
        Matcher matcher = pattern.matcher("");
        this.testEmpty(matcher, matches2);
        this.harness.checkPoint("testEmpty '" + pattern.pattern() + "' flags " + pattern.flags() + " (reset)");
        matcher.reset(CharBuffer.wrap(new StringBuffer()));
        this.testEmpty(matcher, matches2);
        this.harness.checkPoint("testEmpty split '" + pattern.pattern() + "' flags " + pattern.flags());
        Object[] expected = new String[]{""};
        this.harness.check(Arrays.equals(expected, pattern.split("")));
        this.harness.check(Arrays.equals(expected, pattern.split("", 1)));
    }

    void testEmpty(Matcher matcher, boolean matches2) {
        this.harness.check(matches2 == matcher.matches());
        this.harness.check(matches2 == matcher.lookingAt());
        this.harness.check(!matcher.find());
        matcher.reset();
        this.harness.check(matches2 == matcher.find());
        if (matches2) {
            this.harness.check(matcher.start() == 0);
            this.harness.check(matcher.end() == 0);
            this.harness.check("", (Object)matcher.group());
            int groups = matcher.groupCount();
            this.harness.check(groups >= 0);
            for (int i = 0; i < groups; ++i) {
                this.harness.check(matcher.start(i) == 0);
                this.harness.check(matcher.end(i) == 0);
                this.harness.check("", (Object)matcher.group(0));
            }
            this.harness.check("cat", (Object)matcher.replaceAll("cat"));
            this.harness.check("dog", (Object)matcher.replaceFirst("dog"));
            matcher.reset();
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, "blue");
            }
            matcher.appendTail(sb);
            this.harness.check("blue", (Object)sb.toString());
        }
    }

    void testMatchComplete(Pattern pattern, String string) {
        this.harness.checkPoint("testMatchComplete static Pattern.matches(" + pattern.pattern() + ")");
        try {
            this.harness.check(Pattern.matches(pattern.pattern(), string));
        }
        catch (PatternSyntaxException pse) {
            this.harness.debug(pse);
            this.harness.check(false);
        }
        this.harness.checkPoint("testMatchComplete '" + pattern.pattern() + "' flags " + pattern.flags());
        Matcher matcher = pattern.matcher(string);
        this.testMatchComplete(matcher, string);
        this.harness.checkPoint("testComplete '" + pattern.pattern() + "' flags " + pattern.flags() + " (reset)");
        matcher.reset(CharBuffer.wrap(new StringBuffer(string)));
        this.testMatchComplete(matcher, string);
        this.harness.checkPoint("testComplete split '" + pattern.pattern() + "' flags " + pattern.flags());
        Object[] expected = new String[]{};
        Object[] split2 = pattern.split(string);
        this.harness.check(Arrays.equals(expected, split2));
        split2 = pattern.split(string, 0);
        this.harness.check(Arrays.equals(expected, split2));
        expected = new String[]{string};
        split2 = pattern.split(string, 1);
        this.harness.check(Arrays.equals(expected, split2));
        expected = new String[]{"", ""};
        split2 = pattern.split(string, -1);
        this.harness.check(Arrays.equals(expected, split2));
        split2 = pattern.split(string, 2);
        this.harness.check(Arrays.equals(expected, split2));
        split2 = pattern.split(string, 3);
        this.harness.check(Arrays.equals(expected, split2));
    }

    void testMatchComplete(Matcher matcher, String string) {
        try {
            this.harness.check(matcher.matches());
            this.harness.check(matcher.lookingAt());
            this.harness.check(!matcher.find());
            matcher.reset();
            this.harness.check(matcher.find());
            Pattern pattern = Pattern.compile("(" + matcher.pattern().pattern() + ")");
            matcher = pattern.matcher(string);
            this.harness.check(matcher.matches());
            this.harness.check(matcher.lookingAt());
            this.harness.check(!matcher.find());
            matcher.reset();
            this.harness.check(matcher.find());
            this.harness.check(matcher.start() == 0);
            this.harness.check(matcher.end() == string.length());
            this.harness.check(string, (Object)matcher.group());
            int groups = matcher.groupCount();
            this.harness.check(groups >= 1);
            this.harness.check(matcher.start(0) == 0);
            this.harness.check(matcher.start(1) == 0);
            this.harness.check(matcher.end(0) == string.length());
            this.harness.check(matcher.end(1) == string.length());
            this.harness.check(string, (Object)matcher.group(0));
            this.harness.check(string, (Object)matcher.group(1));
            this.harness.check("cat", (Object)matcher.replaceAll("cat"));
            this.harness.check("dog", (Object)matcher.replaceFirst("dog"));
            this.harness.check("cat" + string + "dog", (Object)matcher.replaceAll("cat$0dog"));
            this.harness.check("dog" + string + "cat", (Object)matcher.replaceFirst("dog$1cat"));
            matcher.reset();
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, "blue");
            }
            matcher.appendTail(sb);
            this.harness.check("blue", (Object)sb.toString());
        }
        catch (PatternSyntaxException pse) {
            this.harness.debug(pse);
            this.harness.check(false);
        }
        catch (IllegalStateException ise) {
            this.harness.debug(ise);
            this.harness.check(false);
        }
    }

    void testNotPattern(String pat) {
        this.harness.checkPoint("testNotPattern: " + pat);
        boolean exception = false;
        try {
            Pattern pattern = Pattern.compile(pat);
        }
        catch (PatternSyntaxException pse) {
            exception = true;
        }
        this.harness.check(exception);
    }
}

