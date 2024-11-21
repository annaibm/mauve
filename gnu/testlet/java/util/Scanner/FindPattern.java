/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.util.Scanner;

public class FindPattern
extends Base {
    private static final String FISH_STR = "1 fish 2 fish red fish blue fish ";

    @Override
    protected void doTest() {
        boolean rc;
        Scanner s3 = new Scanner(FISH_STR);
        String pattern1 = "\\d+";
        String pattern2 = "\\w+";
        String[] patterns = new String[]{null, pattern1, pattern1, pattern2, pattern2};
        String[] values2 = new String[]{null, "1", "2", "red", "blue"};
        int i = 1;
        s3.useDelimiter(" fish ");
        do {
            rc = s3.hasNext(patterns[i]);
            this.myHarness.check(rc, "Next item doesn't match " + patterns[i]);
            if (!rc) {
                this.myHarness.fail("Stopping early; encountered \"" + s3.next() + "\"");
            }
            String tmpStr = s3.next(patterns[i]);
            this.myHarness.check(tmpStr, values2[i], "wrong result : \"" + tmpStr + "\" != \"" + values2[i] + "\"");
        } while (rc && ++i < patterns.length);
    }
}

