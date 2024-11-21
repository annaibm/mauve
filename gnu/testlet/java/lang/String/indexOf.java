/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class indexOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] cstr = new char[]{'a', 'b', 'c', '\t', 'A', 'B', 'C', ' ', '1', '2', '3'};
        String b = new String(" abc\tABC 123\t");
        String d = new String(cstr);
        harness.check(b.indexOf(32), 0);
        harness.check(b.indexOf(32, 1), 8);
        harness.check(b.indexOf(32, 10), -1);
        harness.check(b.indexOf(32, -1), 0);
        harness.check(b.indexOf(32, b.length()), -1);
        harness.check(b.indexOf("abc"), 1);
        harness.check(b.indexOf("abc", 1), 1);
        harness.check(b.indexOf("abc", 10), -1);
        harness.check("".indexOf(""), 0);
        harness.check(b.indexOf(""), 0);
        harness.check("".indexOf(b), -1);
        harness.check(b.lastIndexOf(32), 8);
        harness.check(b.lastIndexOf(32, 1), 0);
        harness.check(b.lastIndexOf(32, 10), 8);
        harness.check(b.lastIndexOf(32, -1), -1);
        harness.check(b.lastIndexOf(32, b.length()), 8);
        harness.check(b.lastIndexOf("abc"), 1);
        harness.check(b.lastIndexOf("abc", 1), 1);
        harness.check(b.lastIndexOf("abc", 10), 1);
        harness.check("".lastIndexOf(""), 0);
        harness.check(b.lastIndexOf(""), b.length());
        harness.check("".lastIndexOf(b), -1);
    }
}

