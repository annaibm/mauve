/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.TestLookAndFeel;
import gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI.MyBasicScrollBarUI;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getMinimumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new TestLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        MyBasicScrollBarUI ui = new MyBasicScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(0);
        scrollBar.setUI(ui);
        harness.check(ui.getMinimumSize(scrollBar), new Dimension(48, 16));
        MyBasicScrollBarUI ui2 = new MyBasicScrollBarUI();
        JScrollBar scrollBar2 = new JScrollBar(1);
        scrollBar2.setUI(ui2);
        harness.check(ui2.getMinimumSize(scrollBar2), new Dimension(16, 48));
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

