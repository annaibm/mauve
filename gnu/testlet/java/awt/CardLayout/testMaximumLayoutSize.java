/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;

public class testMaximumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CardLayout layout2 = new CardLayout();
        harness.check(layout2.maximumLayoutSize(null), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        Frame frame = new Frame();
        harness.check(frame.getComponentCount(), 0);
        harness.check(layout2.maximumLayoutSize(frame), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
}

