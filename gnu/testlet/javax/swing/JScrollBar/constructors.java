/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.constructor1(harness);
        this.constructor2(harness);
        this.constructor3(harness);
    }

    public void constructor1(TestHarness harness) {
        harness.checkPoint("JScrollBar()");
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            harness.debug(e);
        }
        JScrollBar bar = new JScrollBar();
        harness.check(bar.getOrientation(), 1);
        harness.check(bar.getValue(), 0);
        harness.check(bar.getMinimum(), 0);
        harness.check(bar.getMaximum(), 100);
        harness.check(bar.getClientProperty("JScrollBar.isFreeStanding"), null);
    }

    public void constructor2(TestHarness harness) {
        harness.checkPoint("JScrollBar(int)");
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            harness.debug(e);
        }
        JScrollBar bar = new JScrollBar(0);
        harness.check(bar.getOrientation(), 0);
        harness.check(bar.getValue(), 0);
        harness.check(bar.getMinimum(), 0);
        harness.check(bar.getMaximum(), 100);
        harness.check(bar.getClientProperty("JScrollBar.isFreeStanding"), null);
        bar = new JScrollBar(1);
        harness.check(bar.getOrientation(), 1);
        boolean pass = false;
        try {
            bar = new JScrollBar(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void constructor3(TestHarness harness) {
        harness.checkPoint("JScrollBar(int, int, int, int, int)");
        JScrollBar bar = new JScrollBar(1, 50, 5, 0, 100);
        harness.check(bar.getOrientation(), 1);
        harness.check(bar.getValue(), 50);
        harness.check(bar.getMinimum(), 0);
        harness.check(bar.getMaximum(), 100);
        harness.check(bar.getClientProperty("JScrollBar.isFreeStanding"), null);
        boolean pass = false;
        try {
            bar = new JScrollBar(99, 50, 5, 0, 100);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

