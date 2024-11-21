/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class startsWith
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] cstr = new char[]{'a', 'b', 'c', '\t', 'A', 'B', 'C', ' ', '1', '2', '3'};
        String b = new String(" abc\tABC 123\t");
        String d = new String(cstr);
        harness.check(!b.endsWith("123"));
        harness.check(d.endsWith("123"));
        harness.check(!b.startsWith("abc"));
        harness.check(d.startsWith("abc"));
        harness.check(b.startsWith("abc", 1));
        harness.check(!b.startsWith("abc", 2));
        harness.check(!b.startsWith("abc", -1));
        harness.check(!b.startsWith("abc", b.length()));
    }
}

