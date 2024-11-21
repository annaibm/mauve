/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Scrollbar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Scrollbar;

public class testSetUnitIncrement
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Scrollbar bar = new Scrollbar();
        harness.check(bar.getUnitIncrement(), 1);
        bar.setUnitIncrement(0);
        harness.check(bar.getUnitIncrement(), 1);
        bar.setUnitIncrement(5);
        harness.check(bar.getUnitIncrement(), 5);
        bar.setUnitIncrement(0);
        harness.check(bar.getUnitIncrement(), 1);
        bar.setMaximum(10);
        bar.setMinimum(1);
        harness.check(bar.getMaximum(), 10);
        harness.check(bar.getMinimum(), 1);
        harness.check(bar.getUnitIncrement(), 1);
        bar.setUnitIncrement(30);
        harness.check(bar.getUnitIncrement(), 30);
        harness.check(bar.getUnitIncrement() != 9);
        bar.setValues(1, 1, 1, 2);
        harness.check(bar.getValue(), 1);
        harness.check(bar.getVisibleAmount(), 1);
        harness.check(bar.getMinimum(), 1);
        harness.check(bar.getMaximum(), 2);
        bar.setBlockIncrement(4);
        harness.check(bar.getBlockIncrement() > bar.getMaximum() - bar.getMinimum());
        harness.check(bar.getBlockIncrement() == 4);
        harness.check(bar.getBlockIncrement() != bar.getMaximum() - bar.getMinimum());
    }
}

