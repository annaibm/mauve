/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class new_String
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] cstr = new char[]{'a', 'b', 'c', '\t', 'A', 'B', 'C', ' ', '1', '2', '3'};
        String a = new String();
        String b = new String(" abc\tABC 123\t");
        String c = new String(new StringBuffer("abc\tABC 123"));
        String d = new String(cstr);
        String e = new String(cstr, 3, 3);
        harness.check(a, (Object)"");
        harness.check(b, (Object)" abc\tABC 123\t");
        harness.check(c, (Object)"abc\tABC 123");
        harness.check(d, (Object)"abc\tABC 123");
        harness.check(e, (Object)"\tAB");
    }
}

