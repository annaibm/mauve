/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.util.Scanner;

public class SkipPattern
extends Base {
    private static final String FISH_STR = "1 fish 2 fish red fish blue fish ";

    @Override
    protected void doTest() {
        Scanner s = new Scanner(FISH_STR);
        String[] values2 = new String[]{"1", "2", "red", "blue"};
        for (int i = 0; i < values2.length; ++i) {
            String tmpStr = s.next();
            this.myHarness.check(tmpStr.equals(values2[i]), tmpStr + " = " + values2[i]);
            s = s.skip(" ").skip("fish");
        }
    }
}

