/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI.MyMetalScrollBarUI;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getPreferredSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        MyMetalScrollBarUI ui = new MyMetalScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(0);
        scrollBar.setUI(ui);
        harness.check(ui.getPreferredSize(scrollBar), new Dimension(61, 17));
        MyMetalScrollBarUI ui2 = new MyMetalScrollBarUI();
        JScrollBar scrollBar2 = new JScrollBar(1);
        scrollBar2.setUI(ui2);
        harness.check(ui2.getPreferredSize(scrollBar2), new Dimension(17, 61));
    }
}

