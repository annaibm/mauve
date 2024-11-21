/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JPanel;

public class preferredLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
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
        this.test12(harness);
        this.test13(harness);
        this.test14(harness);
        this.test15(harness);
        this.test16(harness);
        this.test17(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("test1");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "Center");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 34));
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("test2");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 34));
    }

    private void test3(TestHarness harness) {
        harness.checkPoint("test3");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "South");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 34));
    }

    private void test4(TestHarness harness) {
        harness.checkPoint("test4");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "East");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 34));
    }

    private void test5(TestHarness harness) {
        harness.checkPoint("test5");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "West");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 34));
    }

    private void test6(TestHarness harness) {
        harness.checkPoint("test6");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "South");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 43));
    }

    private void test7(TestHarness harness) {
        harness.checkPoint("test7");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "East");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 43));
    }

    private void test8(TestHarness harness) {
        harness.checkPoint("test8");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "West");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 43));
    }

    private void test9(TestHarness harness) {
        harness.checkPoint("test9");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "West");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "East");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(20, 34));
    }

    private void test10(TestHarness harness) {
        harness.checkPoint("test10");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "East");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "South");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 43));
    }

    private void test11(TestHarness harness) {
        harness.checkPoint("test11");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(12, 34));
        p.add((Component)p1, "West");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(8, 9));
        p.add((Component)p2, "South");
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 43));
    }

    private void test12(TestHarness harness) {
        harness.checkPoint("test12");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(11, 1));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(10, 2));
        p.add((Component)p2, "South");
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(3, 3));
        p.add((Component)p3, "East");
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(3, 4));
        p.add((Component)p4, "West");
        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(3, 5));
        p.add(p5);
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(11, 8));
    }

    private void test13(TestHarness harness) {
        harness.checkPoint("test13");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(11, 1));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(10, 2));
        p.add((Component)p2, "South");
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(4, 3));
        p.add((Component)p3, "East");
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(4, 4));
        p.add((Component)p4, "West");
        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(4, 5));
        p.add(p5);
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 8));
    }

    private void test14(TestHarness harness) {
        harness.checkPoint("test14");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(10, 1));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(11, 2));
        p.add((Component)p2, "South");
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(3, 3));
        p.add((Component)p3, "East");
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(3, 4));
        p.add((Component)p4, "West");
        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(3, 5));
        p.add(p5);
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(11, 8));
    }

    private void test15(TestHarness harness) {
        harness.checkPoint("test15");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(1, 3));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(2, 3));
        p.add((Component)p2, "South");
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(3, 3));
        p.add((Component)p3, "East");
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(4, 4));
        p.add((Component)p4, "West");
        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(5, 3));
        p.add(p5);
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 10));
    }

    private void test16(TestHarness harness) {
        harness.checkPoint("test16");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(1, 3));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(2, 3));
        p.add((Component)p2, "South");
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(3, 3));
        p.add((Component)p3, "East");
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(4, 3));
        p.add((Component)p4, "West");
        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(5, 4));
        p.add(p5);
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 10));
    }

    private void test17(TestHarness harness) {
        harness.checkPoint("test17");
        JPanel p = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.setPreferredSize(new Dimension(1, 3));
        p.add((Component)p1, "North");
        JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(2, 3));
        p.add((Component)p2, "South");
        JPanel p3 = new JPanel();
        p3.setPreferredSize(new Dimension(3, 4));
        p.add((Component)p3, "East");
        JPanel p4 = new JPanel();
        p4.setPreferredSize(new Dimension(4, 3));
        p.add((Component)p4, "West");
        JPanel p5 = new JPanel();
        p5.setPreferredSize(new Dimension(5, 3));
        p.add(p5);
        p.doLayout();
        harness.check(p.getPreferredSize(), new Dimension(12, 10));
    }
}

