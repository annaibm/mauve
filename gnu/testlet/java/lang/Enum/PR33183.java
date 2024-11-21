/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.lang.Enum;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;

public class PR33183
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            E e = E.valueOf("A");
            harness.check(e.toString().equals("A"));
        }
        catch (Exception e) {
            harness.debug(e);
            harness.fail(e.toString());
        }
    }

    static enum E {
        A,
        B,
        C;

    }
}

