/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
        this.testConstructor6(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        JInternalFrame f = new JInternalFrame();
        harness.check(f.getTitle(), (Object)"");
        harness.check(f.getDesktopPane(), null);
        harness.check(f.getDefaultCloseOperation(), 2);
        harness.check(f.getLayer(), JLayeredPane.DEFAULT_LAYER);
        harness.check(!f.isResizable());
        harness.check(!f.isClosable());
        harness.check(!f.isMaximizable());
        harness.check(!f.isIconifiable());
        f.putClientProperty("layeredContainerLayer", JLayeredPane.PALETTE_LAYER);
        harness.check(f.getLayer(), JLayeredPane.PALETTE_LAYER);
        harness.check(f.getClientProperty("layeredContainerLayer"), JLayeredPane.PALETTE_LAYER);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(String)");
        JInternalFrame f = new JInternalFrame("Title");
        harness.check(f.getTitle(), (Object)"Title");
        harness.check(f.getDesktopPane(), null);
        harness.check(f.getDefaultCloseOperation(), 2);
        harness.check(f.getLayer(), JLayeredPane.DEFAULT_LAYER);
        harness.check(!f.isResizable());
        harness.check(!f.isClosable());
        harness.check(!f.isMaximizable());
        harness.check(!f.isIconifiable());
        f = new JInternalFrame(null);
        harness.check(f.getTitle(), null);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("(String, boolean)");
        JInternalFrame f = new JInternalFrame("Title", true);
        harness.check(f.getTitle(), (Object)"Title");
        harness.check(f.getDesktopPane(), null);
        harness.check(f.getDefaultCloseOperation(), 2);
        harness.check(f.getLayer(), JLayeredPane.DEFAULT_LAYER);
        harness.check(f.isResizable());
        harness.check(!f.isClosable());
        harness.check(!f.isMaximizable());
        harness.check(!f.isIconifiable());
        f = new JInternalFrame(null, false);
        harness.check(f.getTitle(), null);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("(String, boolean, boolean)");
        JInternalFrame f = new JInternalFrame("Title", false, true);
        harness.check(f.getTitle(), (Object)"Title");
        harness.check(f.getDesktopPane(), null);
        harness.check(f.getDefaultCloseOperation(), 2);
        harness.check(f.getLayer(), JLayeredPane.DEFAULT_LAYER);
        harness.check(!f.isResizable());
        harness.check(f.isClosable());
        harness.check(!f.isMaximizable());
        harness.check(!f.isIconifiable());
        f = new JInternalFrame(null, false, false);
        harness.check(f.getTitle(), null);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String, boolean, boolean, boolean)");
        JInternalFrame f = new JInternalFrame("Title", false, false, true);
        harness.check(f.getTitle(), (Object)"Title");
        harness.check(f.getDesktopPane(), null);
        harness.check(f.getDefaultCloseOperation(), 2);
        harness.check(f.getLayer(), JLayeredPane.DEFAULT_LAYER);
        harness.check(!f.isResizable());
        harness.check(!f.isClosable());
        harness.check(f.isMaximizable());
        harness.check(!f.isIconifiable());
        f = new JInternalFrame(null, false, false, false);
        harness.check(f.getTitle(), null);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("(String, boolean, boolean, boolean, boolean)");
        JInternalFrame f = new JInternalFrame("Title", false, false, false, true);
        harness.check(f.getTitle(), (Object)"Title");
        harness.check(f.getDesktopPane(), null);
        harness.check(f.getDefaultCloseOperation(), 2);
        harness.check(f.getLayer(), JLayeredPane.DEFAULT_LAYER);
        harness.check(!f.isResizable());
        harness.check(!f.isClosable());
        harness.check(!f.isMaximizable());
        harness.check(f.isIconifiable());
        f = new JInternalFrame(null, false, false, false, false);
        harness.check(f.getTitle(), null);
    }
}

