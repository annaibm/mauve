/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JSlider;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.constructor1(harness);
        this.constructor2(harness);
        this.constructor3(harness);
        this.constructor4(harness);
        this.constructor5(harness);
        this.constructor6(harness);
    }

    public void constructor1(TestHarness harness) {
        harness.checkPoint("JSlider()");
        JSlider slider = new JSlider();
        harness.check(slider.getOrientation(), 0);
        harness.check(slider.getMinimum(), 0);
        harness.check(slider.getMaximum(), 100);
        harness.check(slider.getMajorTickSpacing(), 0);
        harness.check(slider.getMinorTickSpacing(), 0);
        harness.check(slider.getPaintLabels(), false);
        harness.check(slider.getPaintTicks(), false);
        harness.check(slider.getSnapToTicks(), false);
        harness.check(slider.getValue(), 50);
        harness.check(slider.getExtent(), 0);
    }

    public void constructor2(TestHarness harness) {
        harness.checkPoint("JSlider(BoundedRangeModel)");
        DefaultBoundedRangeModel m = new DefaultBoundedRangeModel(5, 0, 2, 9);
        JSlider slider = new JSlider(m);
        harness.check(slider.getMinimum(), 2);
        harness.check(slider.getMaximum(), 9);
        harness.check(slider.getMajorTickSpacing(), 0);
        harness.check(slider.getMinorTickSpacing(), 0);
        harness.check(slider.getPaintLabels(), false);
        harness.check(slider.getPaintTicks(), false);
        harness.check(slider.getSnapToTicks(), false);
        harness.check(slider.getValue(), 5);
        harness.check(slider.getExtent(), 0);
        boolean pass = false;
        try {
            new JSlider(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void constructor3(TestHarness harness) {
        harness.checkPoint("JSlider(int)");
        JSlider slider = new JSlider(0);
        harness.check(slider.getOrientation(), 0);
        harness.check(slider.getMinimum(), 0);
        harness.check(slider.getMaximum(), 100);
        harness.check(slider.getMajorTickSpacing(), 0);
        harness.check(slider.getMinorTickSpacing(), 0);
        harness.check(slider.getPaintLabels(), false);
        harness.check(slider.getPaintTicks(), false);
        harness.check(slider.getSnapToTicks(), false);
        harness.check(slider.getValue(), 50);
        harness.check(slider.getExtent(), 0);
        slider = new JSlider(1);
        harness.check(slider.getOrientation(), 1);
        harness.check(slider.getMinimum(), 0);
        harness.check(slider.getMaximum(), 100);
        harness.check(slider.getMajorTickSpacing(), 0);
        harness.check(slider.getMinorTickSpacing(), 0);
        harness.check(slider.getPaintLabels(), false);
        harness.check(slider.getPaintTicks(), false);
        harness.check(slider.getSnapToTicks(), false);
        harness.check(slider.getValue(), 50);
        harness.check(slider.getExtent(), 0);
        boolean pass = false;
        try {
            slider = new JSlider(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void constructor4(TestHarness harness) {
        harness.checkPoint("JSlider(int, int)");
        JSlider slider = new JSlider(23, 34);
        harness.check(slider.getOrientation(), 0);
        harness.check(slider.getMinimum(), 23);
        harness.check(slider.getMaximum(), 34);
        harness.check(slider.getMajorTickSpacing(), 0);
        harness.check(slider.getMinorTickSpacing(), 0);
        harness.check(slider.getPaintLabels(), false);
        harness.check(slider.getPaintTicks(), false);
        harness.check(slider.getSnapToTicks(), false);
        harness.check(slider.getValue(), 28);
        harness.check(slider.getExtent(), 0);
        boolean pass = false;
        try {
            slider = new JSlider(20, 10);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void constructor5(TestHarness harness) {
        harness.checkPoint("JSlider(int, int, int)");
        JSlider slider = new JSlider(23, 34, 33);
        harness.check(slider.getOrientation(), 0);
        harness.check(slider.getMinimum(), 23);
        harness.check(slider.getMaximum(), 34);
        harness.check(slider.getMajorTickSpacing(), 0);
        harness.check(slider.getMinorTickSpacing(), 0);
        harness.check(slider.getPaintLabels(), false);
        harness.check(slider.getPaintTicks(), false);
        harness.check(slider.getSnapToTicks(), false);
        harness.check(slider.getValue(), 33);
        harness.check(slider.getExtent(), 0);
        boolean pass = false;
        try {
            slider = new JSlider(1, 2, 3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider = new JSlider(1, 2, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider = new JSlider(20, 10, 15);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void constructor6(TestHarness harness) {
        harness.checkPoint("JSlider(int, int, int, int)");
        JSlider slider = new JSlider(1, 23, 34, 33);
        harness.check(slider.getOrientation(), 1);
        harness.check(slider.getMinimum(), 23);
        harness.check(slider.getMaximum(), 34);
        harness.check(slider.getMajorTickSpacing(), 0);
        harness.check(slider.getMinorTickSpacing(), 0);
        harness.check(slider.getPaintLabels(), false);
        harness.check(slider.getPaintTicks(), false);
        harness.check(slider.getSnapToTicks(), false);
        harness.check(slider.getValue(), 33);
        harness.check(slider.getExtent(), 0);
        boolean pass = false;
        try {
            slider = new JSlider(1, 1, 2, 3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider = new JSlider(1, 1, 2, 0);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            slider = new JSlider(1, 20, 10, 15);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

