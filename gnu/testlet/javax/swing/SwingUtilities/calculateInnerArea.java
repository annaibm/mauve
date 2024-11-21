/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SwingUtilities;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class calculateInnerArea
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPanel c = new JPanel();
        c.setBorder(new EmptyBorder(1, 2, 3, 4));
        c.setSize(new Dimension(100, 200));
        Rectangle r = SwingUtilities.calculateInnerArea(c, null);
        harness.check(r, new Rectangle(2, 1, 94, 196));
        Rectangle rr = new Rectangle();
        r = SwingUtilities.calculateInnerArea(c, rr);
        harness.check(r == rr);
        harness.check(r, new Rectangle(2, 1, 94, 196));
        rr = SwingUtilities.calculateInnerArea(null, r);
        harness.check(rr, null);
        harness.check(r, new Rectangle(2, 1, 94, 196));
    }
}

