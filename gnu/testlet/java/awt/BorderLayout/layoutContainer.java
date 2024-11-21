/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class layoutContainer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test0(harness);
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
        this.test5(harness);
        this.test6(harness);
        this.test7(harness);
        this.test8(harness);
        this.test9(harness);
        this.test10(harness);
        this.test11(harness);
    }

    private void test0(TestHarness harness) {
        harness.checkPoint("test0");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(200, 200);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "Center");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(10, 54));
        p.add((Component)p2, "North");
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(100, 74));
        p.add((Component)p3, "West");
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(92, 33));
        p.add((Component)p4, "East");
        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(18, 64));
        p.add((Component)p5, "South");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(100, 54, 8, 82));
        harness.check(p2.getBounds(), new Rectangle(0, 0, 200, 54));
        harness.check(p3.getBounds(), new Rectangle(0, 54, 100, 82));
        harness.check(p4.getBounds(), new Rectangle(108, 54, 92, 82));
        harness.check(p5.getBounds(), new Rectangle(0, 136, 200, 64));
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("test1");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "Center");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 120));
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("test2");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 34));
    }

    private void test3(TestHarness harness) {
        harness.checkPoint("test3");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "South");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 86, 100, 34));
    }

    private void test4(TestHarness harness) {
        harness.checkPoint("test4");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "East");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(88, 0, 12, 120));
    }

    private void test5(TestHarness harness) {
        harness.checkPoint("test5");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "West");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 12, 120));
    }

    private void test6(TestHarness harness) {
        harness.checkPoint("test6");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "South");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 34));
        harness.check(p2.getBounds(), new Rectangle(0, 111, 100, 9));
        p1.setPreferredSize(new Dimension(12, 66));
        p2.setPreferredSize(new Dimension(8, 77));
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 66));
        harness.check(p2.getBounds(), new Rectangle(0, 43, 100, 77));
    }

    private void test7(TestHarness harness) {
        harness.checkPoint("test7");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "East");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 34));
        harness.check(p2.getBounds(), new Rectangle(92, 34, 8, 86));
    }

    private void test8(TestHarness harness) {
        harness.checkPoint("test8");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "West");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 100, 34));
        harness.check(p2.getBounds(), new Rectangle(0, 34, 8, 86));
    }

    private void test9(TestHarness harness) {
        harness.checkPoint("test9");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "West");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "East");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 12, 120));
        harness.check(p2.getBounds(), new Rectangle(92, 0, 8, 120));
        p1.setPreferredSize(new Dimension(66, 10));
        p2.setPreferredSize(new Dimension(77, 12));
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 66, 120));
        harness.check(p2.getBounds(), new Rectangle(23, 0, 77, 120));
    }

    private void test10(TestHarness harness) {
        harness.checkPoint("test10");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "East");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "South");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(88, 0, 12, 111));
        harness.check(p2.getBounds(), new Rectangle(0, 111, 100, 9));
    }

    private void test11(TestHarness harness) {
        harness.checkPoint("test11");
        JPanel p = new JPanel(new BorderLayout());
        p.setSize(100, 120);
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "West");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "South");
        p.doLayout();
        harness.check(p1.getBounds(), new Rectangle(0, 0, 12, 111));
        harness.check(p2.getBounds(), new Rectangle(0, 111, 100, 9));
    }
}

