/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex.Matcher;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class hitEnd
implements Testlet {
    private TestHarness harness;
    private Pattern pattern;
    private String patternStr;
    private Matcher matcher;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        try {
            this.patternStr = "abcd";
            this.testFind("xyzabcd", false);
            this.testFind("XYZabcdxyz", false);
            this.testFind("xyzabc", true);
            this.testFind("xyzxyz", true);
            this.testMatches("abcd", false);
            this.testMatches("abc", true);
            this.testMatches("abcdxyz", false);
            this.testMatches("xyzabcd", false);
            this.testMatches("xyz", false);
            this.testLookingAt("abcd", false);
            this.testLookingAt("abcdxyz", false);
            this.testLookingAt("abc", true);
            this.testLookingAt("xyzabcd", false);
            this.patternStr = "abcd$";
            this.testFind("xyzabcd", true);
            this.testFind("XYZabcdxyz", true);
            this.testFind("xyzabc", true);
            this.testFind("xyzxyz", true);
            this.testMatches("abcd", true);
            this.testMatches("abc", true);
            this.testMatches("abcdxyz", false);
            this.testMatches("xyzabcd", false);
            this.testMatches("xyz", false);
            this.testLookingAt("abcd", true);
            this.testLookingAt("abcdxyz", false);
            this.testLookingAt("abc", true);
            this.testLookingAt("xyzabcd", false);
            this.patternStr = "a+b";
            this.testFind("xyzaaab", false);
            this.testFind("xyzaaabb", false);
            this.testFind("xyzaaa", true);
            this.testFind("xyzxyz", true);
            this.testMatches("aaab", false);
            this.testMatches("aaaa", true);
            this.testMatches("aaabx", false);
            this.testMatches("xaaab", false);
            this.testLookingAt("aaab", false);
            this.testLookingAt("aaaa", true);
            this.testLookingAt("aaabxyz", false);
            this.testLookingAt("xyzxyz", false);
            this.patternStr = "(?:a+b)|(?:aa)";
            this.testFind("xyzaaab", false);
            this.testFind("xyzaa", true);
            this.testFind("xyzaaa", true);
            this.testFind("xyzaax", false);
            this.testMatches("aaab", false);
            this.testMatches("aaaa", true);
            this.testMatches("aa", true);
            this.testLookingAt("aaab", false);
            this.testLookingAt("aaaa", true);
            this.testLookingAt("aa", true);
            this.testLookingAt("aax", false);
            this.patternStr = "(?:aa)|(?:a+b)";
            this.testFind("xyzaaab", false);
            this.testFind("xyzaa", false);
            this.testFind("xyzaaa", false);
            this.testFind("xyzaax", false);
            this.testMatches("aaab", false);
            this.testMatches("aaaa", true);
            this.testMatches("aa", false);
            this.testLookingAt("aaab", false);
            this.testLookingAt("aaaa", false);
            this.testLookingAt("aa", false);
            this.testLookingAt("aax", false);
        }
        catch (PatternSyntaxException pse) {
            harness.debug(pse);
            harness.check(false, pse.toString());
        }
    }

    private void testFind(String s, boolean expected) {
        this.pattern = Pattern.compile(this.patternStr);
        this.matcher = this.pattern.matcher(s);
        this.matcher.find();
        boolean result = this.matcher.hitEnd();
        if (result != expected) {
            this.debugMsg(s, "find", expected, result);
        }
        this.harness.check(result == expected);
    }

    private void testMatches(String s, boolean expected) {
        this.pattern = Pattern.compile(this.patternStr);
        this.matcher = this.pattern.matcher(s);
        this.matcher.matches();
        boolean result = this.matcher.hitEnd();
        if (result != expected) {
            this.debugMsg(s, "matches", expected, result);
        }
        this.harness.check(result == expected);
    }

    private void testLookingAt(String s, boolean expected) {
        this.pattern = Pattern.compile(this.patternStr);
        this.matcher = this.pattern.matcher(s);
        this.matcher.lookingAt();
        boolean result = this.matcher.hitEnd();
        if (result != expected) {
            this.debugMsg(s, "lookingAt", expected, result);
        }
        this.harness.check(result == expected);
    }

    private void debugMsg(String s, String method, boolean expected, boolean result) {
        this.harness.debug("pattern=" + this.pattern.pattern() + " input=" + s + " method=" + method + " matcher=" + this.matcher + " expected=" + expected + " hitEnd=" + result);
    }
}

