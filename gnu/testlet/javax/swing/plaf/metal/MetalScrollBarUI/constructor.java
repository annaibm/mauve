/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI.MyMetalScrollBarUI;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class constructor
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
        harness.check(ui.getTrackBounds(), null);
        harness.check(ui.getThumbBounds(), null);
        harness.check(ui.getScrollBarWidthField(), 0);
        JScrollBar scrollBar = new JScrollBar(0);
        scrollBar.setUI(ui);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 0, 0, 0));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 0, 0, 0));
        scrollBar.setBounds(0, 0, 100, 20);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 0, 0, 0));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 0, 0, 0));
        JPanel panel = new JPanel(new BorderLayout());
        panel.setSize(100, 20);
        panel.add(scrollBar);
        panel.doLayout();
        harness.check(ui.getTrackBounds(), new Rectangle(0, 0, 0, 0));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 0, 0, 0));
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(15, 0, 69, 20));
        harness.check(ui.getThumbBounds(), new Rectangle(15, 0, 17, 20));
    }
}

