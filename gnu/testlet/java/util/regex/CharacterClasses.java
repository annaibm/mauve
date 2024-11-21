/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.util.regex.TestHelper;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CharacterClasses
implements Testlet {
    private TestHarness harness;
    private TestHelper helper;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.helper = new TestHelper(harness);
        this.test("a", 'a', 'b');
        this.test("ab", 'b', 'c');
        this.test("ba", 'a', 'c');
        this.test("abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVW", 'a', '*');
        this.test("abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVW", '1', '*');
        this.test("abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVW", 'A', '*');
        this.test("a-z", 'a', 'A');
        this.test("A-Z", 'Z', 'z');
        this.test("a-zA-Z", 'a', '1');
        this.test("1-9a-zA-Z", 'A', ' ');
        this.test("-", '-', '*');
        this.test(".", '.', '^');
        this.test("*", '*', '$');
        this.test("$", '$', '*');
        this.test("\\[", '[', ']');
        this.test("\\]", ']', '[');
        this.helper.testNotPattern("[]");
        this.helper.testNotPattern("[^]");
    }

    void test(String range2, char c, char nc) {
        Pattern pattern;
        String pat = '[' + range2 + ']';
        this.harness.checkPoint("test: " + pat);
        try {
            pattern = Pattern.compile(pat);
            this.harness.check(pat, (Object)pattern.pattern());
            this.helper.testEmpty(pattern, false);
            this.helper.testMatchComplete(pattern, Character.toString(c));
        }
        catch (PatternSyntaxException pse) {
            this.harness.debug(pse);
            this.harness.check(false);
        }
        pat = "[^" + range2 + ']';
        this.harness.checkPoint("test: " + pat);
        try {
            pattern = Pattern.compile(pat);
            this.harness.check(pat, (Object)pattern.pattern());
            this.helper.testEmpty(pattern, false);
            this.helper.testMatchComplete(pattern, Character.toString(nc));
        }
        catch (PatternSyntaxException pse) {
            this.harness.debug(pse);
            this.harness.check(false);
        }
    }
}

