/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.String;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class charAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        String b = new String(" abc\tABC 123\t");
        boolean ok = false;
        try {
            b.charAt(b.length());
        }
        catch (StringIndexOutOfBoundsException ex) {
            ok = true;
        }
        harness.check(ok);
        ok = false;
        try {
            b.charAt(-1);
        }
        catch (StringIndexOutOfBoundsException ex) {
            ok = true;
        }
        harness.check(ok);
    }
}

