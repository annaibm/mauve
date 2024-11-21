/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.OverlayLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTError;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;

public class minimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testWithoutChildren(harness);
        this.testWithOneChild(harness);
        this.testWithTwoChildren(harness);
        this.testWithAlignment(harness);
        this.testWrongContainer(harness);
    }

    void testWithoutChildren(TestHarness h) {
        h.checkPoint("withoutChildren");
        JPanel c = new JPanel();
        OverlayLayout l = new OverlayLayout(c);
        h.check(l.minimumLayoutSize((Container)c).width, 0);
        h.check(l.minimumLayoutSize((Container)c).height, 0);
    }

    void testWithOneChild(TestHarness h) {
        h.checkPoint("withOneChild");
        JPanel c = new JPanel();
        JPanel c1 = new JPanel();
        c1.setMinimumSize(new Dimension(10, 10));
        c1.setPreferredSize(new Dimension(20, 20));
        c1.setMaximumSize(new Dimension(30, 30));
        c.add(c1);
        OverlayLayout l = new OverlayLayout(c);
        h.check(l.minimumLayoutSize((Container)c).width, 10);
        h.check(l.minimumLayoutSize((Container)c).height, 10);
    }

    void testWithTwoChildren(TestHarness h) {
        h.checkPoint("withTwoChildren");
        JPanel c = new JPanel();
        JPanel c1 = new JPanel();
        c1.setMinimumSize(new Dimension(10, 10));
        c1.setPreferredSize(new Dimension(20, 20));
        c1.setMaximumSize(new Dimension(30, 30));
        c.add(c1);
        JPanel c2 = new JPanel();
        c2.setMinimumSize(new Dimension(40, 40));
        c2.setPreferredSize(new Dimension(50, 50));
        c2.setMaximumSize(new Dimension(60, 60));
        c.add(c2);
        OverlayLayout l = new OverlayLayout(c);
        h.check(l.minimumLayoutSize((Container)c).width, 40);
        h.check(l.minimumLayoutSize((Container)c).height, 40);
    }

    void testWithAlignment(TestHarness h) {
        h.checkPoint("withAlignment");
        JPanel c = new JPanel();
        JPanel c1 = new JPanel();
        c1.setMinimumSize(new Dimension(10, 10));
        c1.setPreferredSize(new Dimension(20, 20));
        c1.setMaximumSize(new Dimension(30, 30));
        c1.setAlignmentX(0.0f);
        c.add(c1);
        JPanel c2 = new JPanel();
        c2.setMinimumSize(new Dimension(40, 40));
        c2.setPreferredSize(new Dimension(50, 50));
        c2.setMaximumSize(new Dimension(60, 60));
        c2.setAlignmentX(0.5f);
        c.add(c2);
        JPanel c3 = new JPanel();
        c3.setMinimumSize(new Dimension(40, 40));
        c3.setPreferredSize(new Dimension(50, 50));
        c3.setMaximumSize(new Dimension(60, 60));
        c3.setAlignmentX(1.0f);
        c.add(c3);
        OverlayLayout l = new OverlayLayout(c);
        h.check(l.minimumLayoutSize((Container)c).width, 60);
        h.check(l.minimumLayoutSize((Container)c).height, 40);
    }

    void testWrongContainer(TestHarness h) {
        h.checkPoint("wrongContainer");
        JPanel c1 = new JPanel();
        JPanel c2 = new JPanel();
        OverlayLayout l = new OverlayLayout(c1);
        try {
            h.check(l.minimumLayoutSize((Container)c2).width, 30);
            h.fail("minimumLayoutSize must throw AWTError when called with wrong container.");
        }
        catch (AWTError ex) {
            h.check(true);
        }
    }
}

