/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JProgressBar;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.constructor1(harness);
        this.constructor2(harness);
        this.constructor3(harness);
        this.constructor4(harness);
        this.constructor5(harness);
    }

    public void constructor1(TestHarness harness) {
        harness.checkPoint("JProgressBar()");
        JProgressBar bar = new JProgressBar();
        harness.check(bar.getOrientation(), 0);
        harness.check(bar.getValue(), 0);
        harness.check(bar.getMinimum(), 0);
        harness.check(bar.getMaximum(), 100);
        harness.check(bar.getString(), (Object)"0%");
        harness.check(bar.isStringPainted(), false);
    }

    public void constructor2(TestHarness harness) {
        harness.checkPoint("JProgressBar(BoundedRangeModel)");
        DefaultBoundedRangeModel m = new DefaultBoundedRangeModel(50, 10, 0, 100);
        JProgressBar bar = new JProgressBar(m);
        harness.check(bar.getOrientation(), 0);
        harness.check(bar.getValue(), 50);
        harness.check(bar.getMinimum(), 0);
        harness.check(bar.getMaximum(), 100);
        harness.check(bar.getString(), (Object)"50%");
        harness.check(bar.isStringPainted(), false);
        boolean pass = false;
        try {
            bar = new JProgressBar(null);
        }
        catch (NullPointerException e) {
            harness.check(pass);
        }
    }

    public void constructor3(TestHarness harness) {
        harness.checkPoint("JProgressBar(int)");
        JProgressBar bar = new JProgressBar(0);
        harness.check(bar.getOrientation(), 0);
        harness.check(bar.getValue(), 0);
        harness.check(bar.getMinimum(), 0);
        harness.check(bar.getMaximum(), 100);
        harness.check(bar.getString(), (Object)"0%");
        harness.check(bar.isStringPainted(), false);
        bar = new JProgressBar(1);
        harness.check(bar.getOrientation(), 1);
        boolean pass = false;
        try {
            bar = new JProgressBar(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void constructor4(TestHarness harness) {
        harness.checkPoint("JProgressBar(int, int)");
        JProgressBar bar = new JProgressBar(12, 34);
        harness.check(bar.getOrientation(), 0);
        harness.check(bar.getValue(), 12);
        harness.check(bar.getMinimum(), 12);
        harness.check(bar.getMaximum(), 34);
        harness.check(bar.getString(), (Object)"0%");
        harness.check(bar.isStringPainted(), false);
        boolean pass = false;
        try {
            bar = new JProgressBar(34, 12);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void constructor5(TestHarness harness) {
        harness.checkPoint("JProgressBar(int, int, int)");
        JProgressBar bar = new JProgressBar(1, 12, 34);
        harness.check(bar.getOrientation(), 1);
        harness.check(bar.getValue(), 12);
        harness.check(bar.getMinimum(), 12);
        harness.check(bar.getMaximum(), 34);
        harness.check(bar.getString(), (Object)"0%");
        harness.check(bar.isStringPainted(), false);
    }
}

