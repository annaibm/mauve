/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.GridLayout;

public class setVgap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GridLayout layout2 = new GridLayout();
        layout2.setVgap(42);
        harness.check(layout2.getVgap(), 42);
        layout2.setVgap(-42);
        harness.check(layout2.getVgap(), -42);
        layout2.setVgap(0);
        harness.check(layout2.getVgap(), 0);
    }
}

