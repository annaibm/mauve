/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.CardLayout;

public class setVgap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CardLayout b = new CardLayout();
        b.setVgap(0);
        harness.check(b.getVgap(), 0);
        b.setVgap(42);
        harness.check(b.getVgap(), 42);
        b.setVgap(-42);
        harness.check(b.getVgap(), -42);
    }
}

