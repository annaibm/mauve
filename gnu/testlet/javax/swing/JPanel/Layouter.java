/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JPanel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class Layouter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPanel panel = new JPanel(null);
        harness.check(panel.getLayout() == null);
        panel = new JPanel();
        harness.check(panel.getLayout() instanceof FlowLayout);
        panel.setLayout(null);
        harness.check(panel.getLayout() == null);
    }
}

