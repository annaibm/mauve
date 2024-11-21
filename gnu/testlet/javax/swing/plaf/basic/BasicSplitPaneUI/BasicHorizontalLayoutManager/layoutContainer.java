/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicSplitPaneUI.BasicHorizontalLayoutManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class layoutContainer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testMinimumSize(harness);
    }

    private void testMinimumSize(TestHarness h) {
        JPanel c1 = new JPanel();
        c1.setMinimumSize(new Dimension(100, 100));
        JPanel c2 = new JPanel();
        JSplitPane sp = new JSplitPane(1, c1, c2);
        sp.setSize(200, 200);
        h.check(sp.getLayout() instanceof BasicSplitPaneUI.BasicHorizontalLayoutManager);
        sp.getLayout().layoutContainer(sp);
        h.check(c1.getWidth(), 100);
        c1 = new JPanel();
        c1.setMinimumSize(new Dimension(100, 100));
        c2 = new JPanel();
        sp = new JSplitPane(1, c1, c2);
        sp.setDividerLocation(0);
        sp.setSize(200, 200);
        h.check(sp.getLayout() instanceof BasicSplitPaneUI.BasicHorizontalLayoutManager);
        sp.getLayout().layoutContainer(sp);
        h.check(c1.getWidth(), 0);
    }
}

