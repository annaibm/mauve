/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FlowLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FlowLayout;

public class setHgap
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FlowLayout layout2 = new FlowLayout();
        layout2.setHgap(42);
        harness.check(layout2.getHgap(), 42);
        layout2.setHgap(-42);
        harness.check(layout2.getHgap(), -42);
        layout2.setHgap(0);
        harness.check(layout2.getHgap(), 0);
    }
}

