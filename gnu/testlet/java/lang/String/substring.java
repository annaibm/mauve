/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class substring
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String b = new String(" abc\tABC 123\t");
        harness.check(b.substring(4), (Object)"\tABC 123\t");
        harness.check(b.substring(4, b.length() - 5), (Object)"\tABC");
        boolean ok = false;
        try {
            b.substring(-1);
        }
        catch (StringIndexOutOfBoundsException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = true;
        try {
            b.substring(b.length());
        }
        catch (StringIndexOutOfBoundsException ex) {
            ok = false;
        }
        harness.check(ok);
        ok = false;
        try {
            b.substring(4, -1);
        }
        catch (StringIndexOutOfBoundsException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            b.substring(4, b.length() + 1);
        }
        catch (StringIndexOutOfBoundsException ex) {
            ok = true;
        }
        harness.check(ok);
    }
}

