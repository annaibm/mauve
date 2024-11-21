/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class FishString
extends Base {
    @Override
    protected void doTest() {
        int i;
        String input = "1 fish 2 fish red fish blue fish";
        String delimiter = "\\s*fish\\s*";
        String[] values2 = new String[]{null, "1", "2", "red", "blue"};
        this.myHarness.checkPoint("Fisch String [" + input + "]");
        Scanner s1 = new Scanner(input);
        s1.useDelimiter(delimiter);
        String tmpStr = s1.delimiter().pattern();
        this.myHarness.check(tmpStr, delimiter, "get / setDelimiter fail (\"" + tmpStr + "\" != \"" + delimiter);
        this.myHarness.check(s1.hasNext(), true, "first hasNext()");
        this.myHarness.check(s1.hasNextInt(), true, "first hasNextInt()");
        this.myHarness.check(s1.nextInt(), 1, "nextInt()");
        this.myHarness.check(s1.hasNextInt(), true, "hasNextInt()");
        this.myHarness.check(s1.hasNextBoolean(), false, "hasNextBoolean()");
        this.myHarness.check(s1.hasNextByte(), true, "hasNextByte()");
        this.myHarness.check(s1.nextInt(), 2, "2. nextInt()");
        this.myHarness.check(s1.hasNext(), true, "3. hasNext()");
        this.myHarness.check(s1.hasNextBigInteger(), false, "hasNextBigInteger()");
        this.myHarness.check(s1.next(), "red", "3. next()");
        this.myHarness.check(s1.next(), "blue", "4. next()");
        this.myHarness.check(s1.hasNext(), false, "letztes hasNext()");
        s1.close();
        Scanner s2 = new Scanner(input);
        s2.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
        MatchResult mResult = s2.match();
        for (i = 1; i <= mResult.groupCount(); ++i) {
            this.myHarness.check(mResult.group(i), values2[i], "wrong result : \"" + mResult.group(i) + "\" != \"" + values2[i] + "\"");
        }
        if (i != values2.length) {
            this.myHarness.fail("not all results... (" + i + " != " + values2.length + ")");
        }
        s2.close();
    }
}

