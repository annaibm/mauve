/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class hash
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] cstr = new char[]{'a', 'b', 'c', '\t', 'A', 'B', 'C', ' ', '1', '2', '3'};
        String a = new String();
        String b = new String(" abc\tABC 123\t");
        String c = new String(new StringBuffer("abc\tABC 123"));
        harness.check(a.hashCode(), 0);
        harness.check(b.hashCode(), -524164548);
        harness.check(c.hashCode(), -822419571);
    }
}

