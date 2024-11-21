/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class maxLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTextField ftf = new JTextField("HELLO WORLD");
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(ftf);
        LayoutManager2 lm = (LayoutManager2)borderPanel.getLayout();
        Dimension max2 = new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
        harness.check(lm.maximumLayoutSize(borderPanel), max2);
        borderPanel.setBorder(new TitledBorder("HELLO WORLD"));
        harness.check(lm.maximumLayoutSize(borderPanel), max2);
        ftf.setMaximumSize(new Dimension(0, 0));
        harness.check(lm.maximumLayoutSize(borderPanel), max2);
        harness.check(lm.maximumLayoutSize(null), max2);
        BorderLayout bl = new BorderLayout();
        harness.check(bl.maximumLayoutSize(null), max2);
    }
}

