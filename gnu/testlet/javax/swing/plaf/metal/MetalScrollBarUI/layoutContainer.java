/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalScrollBarUI.MyMetalScrollBarUI;
import java.awt.Rectangle;
import javax.swing.JScrollBar;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class layoutContainer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.testHorizontal(harness);
        this.testHorizontalFreeStanding(harness);
        this.testVertical(harness);
        this.testVerticalFreeStanding(harness);
    }

    public void testHorizontal(TestHarness harness) {
        harness.checkPoint("testHorizontal()");
        MyMetalScrollBarUI ui = new MyMetalScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(0);
        scrollBar.putClientProperty("JScrollBar.isFreeStanding", Boolean.FALSE);
        scrollBar.setUI(ui);
        scrollBar.setBounds(0, 0, 100, 20);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(15, 0, 70, 20));
        harness.check(ui.getThumbBounds(), new Rectangle(15, 0, 15, 20));
        scrollBar.setBounds(40, 50, 250, 37);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(15, 0, 220, 37));
        harness.check(ui.getThumbBounds(), new Rectangle(15, 0, 22, 37));
    }

    public void testHorizontalFreeStanding(TestHarness harness) {
        harness.checkPoint("testHorizontalFreeStanding()");
        MyMetalScrollBarUI ui = new MyMetalScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(0);
        scrollBar.putClientProperty("JScrollBar.isFreeStanding", Boolean.TRUE);
        scrollBar.setUI(ui);
        scrollBar.setBounds(0, 0, 100, 20);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(15, 0, 69, 20));
        harness.check(ui.getThumbBounds(), new Rectangle(15, 0, 17, 20));
        scrollBar.setBounds(40, 50, 250, 37);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(15, 0, 219, 37));
        harness.check(ui.getThumbBounds(), new Rectangle(15, 0, 21, 37));
    }

    public void testVertical(TestHarness harness) {
        harness.checkPoint("testVertical()");
        MyMetalScrollBarUI ui = new MyMetalScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(1);
        scrollBar.putClientProperty("JScrollBar.isFreeStanding", Boolean.FALSE);
        scrollBar.setUI(ui);
        scrollBar.setBounds(0, 0, 20, 100);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 15, 20, 70));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 15, 20, 15));
        scrollBar.setBounds(40, 50, 37, 250);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 15, 37, 220));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 15, 37, 22));
    }

    public void testVerticalFreeStanding(TestHarness harness) {
        harness.checkPoint("testVerticalFreeStanding()");
        MyMetalScrollBarUI ui = new MyMetalScrollBarUI();
        JScrollBar scrollBar = new JScrollBar(1);
        scrollBar.putClientProperty("JScrollBar.isFreeStanding", Boolean.TRUE);
        scrollBar.setUI(ui);
        scrollBar.setBounds(0, 0, 20, 100);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 15, 20, 69));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 15, 20, 17));
        scrollBar.setBounds(40, 50, 37, 250);
        ui.layoutContainer(scrollBar);
        harness.check(ui.getTrackBounds(), new Rectangle(0, 15, 37, 219));
        harness.check(ui.getThumbBounds(), new Rectangle(0, 15, 37, 21));
    }
}

