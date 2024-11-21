/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSlider;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSlider;

public class getPaintTrack
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JSlider slider = new JSlider(5, 10);
        harness.check(slider.getPaintTrack(), true);
        slider.setPaintTrack(false);
        harness.check(slider.getPaintTrack(), false);
    }
}

