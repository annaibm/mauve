/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import javax.accessibility.AccessibleContext;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JRootPane;
import javax.swing.UIManager;

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
        this.testFrameInit1(harness);
        this.testFrameInit2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        JFrame f = new JFrame();
        harness.check(f.getTitle(), (Object)"");
        harness.check(f.isShowing(), false);
    }

    public void testConstructor2(TestHarness harness) {
        JFrame f = new JFrame("JFrameName");
        harness.check(f.getTitle(), (Object)"JFrameName");
    }

    public void testConstructor3(TestHarness harness) {
        JFrame f = new JFrame("");
        harness.check(f.getTitle(), (Object)"");
    }

    public void testConstructor5(TestHarness harness) {
        JFrame f = new JFrame((GraphicsConfiguration)null);
        harness.check(f.getTitle(), (Object)"");
        harness.check(f.isShowing(), false);
    }

    public void testConstructor4(TestHarness harness) {
        JFrame f = new JFrame("JFrameName", null);
        harness.check(f.getTitle(), (Object)"JFrameName");
    }

    public void testConstructor6(TestHarness harness) {
        JFrame f = new JFrame("", null);
        harness.check(f.getTitle(), (Object)"");
    }

    public void testFrameInit1(TestHarness harness) {
        JFrame f = new JFrame();
        harness.check(f.getAccessibleContext() instanceof AccessibleContext);
        harness.check(f.getAccessibleContext() != null);
        harness.check(f.getBackground(), UIManager.getColor("control"));
        harness.check(f.getContentPane() instanceof Container);
        harness.check(f.getContentPane() != null);
        harness.check(f.getDefaultCloseOperation(), 1);
        harness.check(f.getGlassPane() instanceof Component);
        harness.check(f.getGlassPane() != null);
        harness.check(f.getLayeredPane() instanceof JLayeredPane);
        harness.check(f.getLayeredPane() != null);
        harness.check(f.getLayout() instanceof BorderLayout);
        harness.check(((BorderLayout)f.getLayout()).getHgap(), 0);
        harness.check(((BorderLayout)f.getLayout()).getVgap(), 0);
        harness.check(f.getJMenuBar(), null);
        harness.check(f.getRootPane() instanceof JRootPane);
        harness.check(f.getRootPane() != null);
    }

    public void testFrameInit2(TestHarness harness) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame();
        harness.check(f.isUndecorated(), true);
        harness.check(f.getRootPane().getWindowDecorationStyle(), 1);
    }
}

