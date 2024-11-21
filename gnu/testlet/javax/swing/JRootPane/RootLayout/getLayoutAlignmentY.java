/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRootPane.RootLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.LayoutManager2;
import javax.swing.JComponent;
import javax.swing.JRootPane;

public class getLayoutAlignmentY
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JRootPane rp = new JRootPane();
        LayoutManager2 lm2 = (LayoutManager2)rp.getLayout();
        harness.check(lm2.getLayoutAlignmentY(rp), 0.0);
        rp.setAlignmentY(0.5f);
        harness.check(lm2.getLayoutAlignmentY(rp), 0.0);
        ((JComponent)rp.getContentPane()).setAlignmentY(0.5f);
        harness.check(lm2.getLayoutAlignmentY(rp), 0.0);
        ((JComponent)rp.getGlassPane()).setAlignmentY(0.5f);
        harness.check(lm2.getLayoutAlignmentY(rp), 0.0);
        rp.getLayeredPane().setAlignmentY(0.5f);
        harness.check(lm2.getLayoutAlignmentY(rp), 0.0);
    }
}

