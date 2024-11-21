/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.StringBuffer;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class plus
implements Testlet {
    public String s(int x) {
        if (x == 0) {
            return null;
        }
        return "z";
    }

    @Override
    public void test(TestHarness harness) {
        harness.check(this.s(0) + "", (Object)"null");
        harness.check(this.s(1) + "", (Object)"z");
        harness.check("wxy" + this.s(0), (Object)"wxynull");
        harness.check("wxy" + this.s(1), (Object)"wxyz");
        harness.check(5 + this.s(1), (Object)"5z");
        harness.check("0.2" + this.s(0) + 7, (Object)"0.2null7");
    }
}

