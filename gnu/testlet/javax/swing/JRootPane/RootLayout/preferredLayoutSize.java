/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRootPane.RootLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class preferredLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testInvalidLayout(harness);
    }

    private void testInvalidLayout(TestHarness h) {
        JRootPane rp = new JRootPane();
        LayoutManager l = rp.getLayout();
        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(100, 100));
        rp.setContentPane(p);
        h.check(l.preferredLayoutSize(rp), new Dimension(100, 100));
        p.setPreferredSize(new Dimension(200, 200));
        h.check(l.preferredLayoutSize(rp), new Dimension(200, 200));
    }
}

