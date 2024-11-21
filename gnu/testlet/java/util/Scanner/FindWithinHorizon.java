/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.Scanner;

import gnu.testlet.java.util.Scanner.Base;
import java.util.Scanner;

public class FindWithinHorizon
extends Base {
    @Override
    protected void doTest() {
        String fishString = "1 fish 2 fish red fish blue fish";
        Scanner s = new Scanner(fishString);
        String tmpStr = "";
        for (int i = 0; i < fishString.length(); ++i) {
            tmpStr = tmpStr + s.findWithinHorizon("(?s).", 1);
        }
        this.myHarness.check(tmpStr.equals(fishString), "\"" + tmpStr + "\" == \"" + fishString + "\"");
        if (s.hasNext()) {
            this.myHarness.fail("should not has next...");
        }
    }
}

