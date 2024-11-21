/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.GridLayout;

public class getRows
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GridLayout layout2 = new GridLayout();
        harness.check(layout2.getRows(), 1);
        layout2.setRows(10);
        harness.check(layout2.getRows(), 10);
        try {
            layout2.setRows(0);
            harness.check(false);
        }
        catch (IllegalArgumentException e) {
            harness.check(true);
        }
        harness.check(layout2.getRows(), 10);
        layout2.setRows(-10);
        harness.check(layout2.getRows(), -10);
        layout2 = new GridLayout(10, 20);
        harness.check(layout2.getRows(), 10);
    }
}

