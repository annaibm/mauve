/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FlowLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FlowLayout;

public class setVgap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FlowLayout layout2 = new FlowLayout();
        layout2.setVgap(42);
        harness.check(layout2.getVgap(), 42);
        layout2.setVgap(-42);
        harness.check(layout2.getVgap(), -42);
        layout2.setVgap(0);
        harness.check(layout2.getVgap(), 0);
    }
}

