/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.GridLayout;

public class getColumns
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        GridLayout layout2 = new GridLayout();
        harness.check(layout2.getColumns(), 0);
        layout2.setColumns(10);
        harness.check(layout2.getColumns(), 10);
        layout2.setColumns(0);
        harness.check(layout2.getColumns(), 0);
        layout2.setColumns(-10);
        harness.check(layout2.getColumns(), -10);
        layout2 = new GridLayout(10, 20);
        harness.check(layout2.getColumns(), 20);
    }
}

