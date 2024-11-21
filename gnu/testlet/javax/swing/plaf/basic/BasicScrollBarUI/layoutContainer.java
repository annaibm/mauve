/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.TestLookAndFeel;
import gnu.testlet.javax.swing.plaf.basic.BasicScrollBarUI.MyBasicScrollBarUI;
import java.awt.Rectangle;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class layoutContainer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new TestLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.testHorizontal(harness);
        this.testVertical(harness);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testHorizontal(TestHarness harness) {
        MyBasicScrollBarUI ui = new MyBasicScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(0);
        scrollBar.setUI(ui);
        scrollBar.setBounds(0, 0, 100, 20);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(16, 0, 68, 20));
        harness.check(ui.getThumbBounds(), new Rectangle(16, 0, 8, 20));
        scrollBar.setBounds(40, 50, 250, 37);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(16, 0, 218, 37));
        harness.check(ui.getThumbBounds(), new Rectangle(16, 0, 21, 37));
    }

    public void testVertical(TestHarness harness) {
        MyBasicScrollBarUI ui = new MyBasicScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(1);
        scrollBar.setUI(ui);
        scrollBar.setBounds(0, 0, 20, 100);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 16, 20, 68));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 16, 20, 8));
        scrollBar.setBounds(40, 50, 37, 250);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 16, 37, 218));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 16, 37, 21));
    }
}

