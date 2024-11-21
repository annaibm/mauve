/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.CardLayout;

public class getVgap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CardLayout b = new CardLayout();
        b.setHgap(0);
        harness.check(b.getHgap(), 0);
        b.setHgap(42);
        harness.check(b.getHgap(), 42);
        b.setHgap(-42);
        harness.check(b.getHgap(), -42);
    }
}

