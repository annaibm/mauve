/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JPanel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class setBorder
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTextField ftf = new JTextField("HELLO WORLD");
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(ftf);
        Dimension d1 = borderPanel.getMaximumSize();
        borderPanel.setBorder(new TitledBorder("HELLO WORLD"));
        Dimension d2 = borderPanel.getMaximumSize();
        harness.check(d1, d2);
    }
}

