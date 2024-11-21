/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.regex;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSplit
implements Testlet {
    private TestHarness harness;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.test("@", "test@example.com", new String[]{"test", "example.com"});
        this.test("\\.", "192.168.0.1", new String[]{"192", "168", "0", "1"});
        this.test(",", "a,b,c,d,e", new String[]{"a", "b", "c", "d", "e"});
        this.test("-", "a-", new String[]{"a", ""});
        this.test(";", ";b", new String[]{"", "b"});
        this.test(":", ":b:", new String[]{"", "b", ""});
        this.test(" ", " ", new String[]{"", ""});
        this.test("0", "00", new String[]{"", "", ""});
        this.test(",", "a,b,c,d,e", new String[]{"a", "b", "c", "d", "e"});
        this.test("\\w", "a,b,c,d,e", new String[]{"", ",", ",", ",", ",", ""});
        this.test("\\d+", "123,456,789", new String[]{"", ",", ",", ""});
        this.test("[^a-z]", "abc1defZghi", new String[]{"abc", "def", "ghi"});
        this.test("^[a-c]", "abc", new String[]{"", "bc"});
        this.test("[a-c]$", "abc", new String[]{"ab", ""});
        this.test("(?=[a-z])", "123abc", new String[]{"123", "a", "b", "c"});
        this.test(",", "a,,,b", new String[]{"a", "", "", "b"});
        this.test("waku", "", new String[]{""});
        this.test("waku", "wapu", new String[]{"wapu"});
        this.test("\\d+", "abc,def", new String[]{"abc,def"});
    }

    void test(String pat, String str, String[] expected) {
        this.harness.checkPoint("test: " + pat);
        try {
            Object[] expected0;
            int i;
            Pattern pattern = Pattern.compile(pat);
            Object[] result = pattern.split(str, -1);
            this.harness.check(Arrays.equals(expected, result));
            result = pattern.split(str, Integer.MIN_VALUE);
            this.harness.check(Arrays.equals(expected, result));
            result = pattern.split(str);
            Object[] result0 = pattern.split(str, 0);
            this.harness.check(Arrays.equals(result, result0));
            int total_len = expected.length;
            if (pattern.matcher(str).find()) {
                int trailing_empties = 0;
                for (i = 0; i < total_len; ++i) {
                    if ("".equals(expected[i])) {
                        ++trailing_empties;
                        continue;
                    }
                    trailing_empties = 0;
                }
                expected0 = new String[total_len - trailing_empties];
                for (i = 0; i < expected0.length; ++i) {
                    expected0[i] = expected[i];
                }
            } else {
                expected0 = new String[]{str};
            }
            this.harness.check(Arrays.equals(expected0, result0));
            String[] result1 = pattern.split(str, 1);
            this.harness.check(result1.length == 1 && str.equals(result1[0]));
            for (i = 2; i <= total_len; ++i) {
                result = pattern.split(str, i);
                boolean equal = result.length == i;
                for (int j = 0; equal && j < i - 1; ++j) {
                    equal = expected[j].equals(result[j]);
                }
                this.harness.check(equal);
                this.harness.check(result.length > i - 1 && ((String)result[i - 1]).startsWith(expected[i - 1]));
                this.harness.check(result.length > i - 1 && ((String)result[i - 1]).endsWith(expected[total_len - 1]));
            }
            result = pattern.split(str, total_len + 1);
            this.harness.check(Arrays.equals(expected, result));
            result = pattern.split(str, Integer.MAX_VALUE);
            this.harness.check(Arrays.equals(expected, result));
        }
        catch (PatternSyntaxException pse) {
            this.harness.debug(pse);
            this.harness.check(false);
        }
    }
}

