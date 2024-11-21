/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MultiLine
extends Base {
    @Override
    protected void doTest() {
        int i;
        this.myHarness.checkPoint("Multi line read - linewise");
        String[] lines = new String[]{"1. Line: aaa bbb ccc", "2. line: aaa bbb aaa", "3. line: bbb aaa"};
        String newLine = System.getProperty("line.separator");
        String tmp = lines[0];
        for (i = 1; i < lines.length; ++i) {
            tmp = tmp + newLine + lines[i];
        }
        tmp = tmp + newLine;
        byte[] buffer = tmp.getBytes();
        ByteArrayInputStream inStr = new ByteArrayInputStream(buffer);
        Scanner s = new Scanner(inStr);
        for (i = 0; i < lines.length; ++i) {
            this.myHarness.check(s.hasNextLine(), true, i + 1 + ". hasNextLine()");
            String result = s.nextLine();
            this.myHarness.check(result, lines[i], i + 1 + ". nextLine() [" + result + "]");
        }
    }
}

