/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;

public class setRangeProperties
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        dbrm.setRangeProperties(5, 2, 1, 8, false);
        setRangeProperties.check(harness, dbrm, 5, 2, 1, 8, false);
        dbrm.setRangeProperties(5, 2, 1, 8, true);
        setRangeProperties.check(harness, dbrm, 5, 2, 1, 8, true);
        dbrm.setRangeProperties(4, -2, -4, 9, false);
        setRangeProperties.check(harness, dbrm, 4, 0, -4, 9, false);
        dbrm.setRangeProperties(14, 0, 1, 8, false);
        setRangeProperties.check(harness, dbrm, 14, 0, 1, 14, false);
        dbrm.setRangeProperties(5, 4, 1, 8, false);
        setRangeProperties.check(harness, dbrm, 5, 3, 1, 8, false);
        dbrm.setRangeProperties(-3, 1, 0, 8, false);
        setRangeProperties.check(harness, dbrm, -3, 1, -3, 8, false);
    }

    public static void check(TestHarness harness, DefaultBoundedRangeModel brm, int value2, int extent, int minimum, int maximum, boolean adjusting) {
        int a = brm.getValue();
        if (a != value2) {
            harness.check(false);
            harness.debug("got value " + a + " but expected " + value2);
            return;
        }
        a = brm.getExtent();
        if (a != extent) {
            harness.check(false);
            harness.debug("got extent " + a + " but expected " + extent);
            return;
        }
        a = brm.getMinimum();
        if (a != minimum) {
            harness.check(false);
            harness.debug("got minimum " + a + " but expected " + minimum);
            return;
        }
        a = brm.getMaximum();
        if (a != maximum) {
            harness.check(false);
            harness.debug("got maximum " + a + " but expected " + maximum);
            return;
        }
        boolean b = brm.getValueIsAdjusting();
        if (b != adjusting) {
            harness.check(false);
            harness.debug("got adjusting " + b + " but expected " + adjusting);
            return;
        }
        harness.check(true);
    }
}

