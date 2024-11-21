/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ViewportLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.ViewportLayout;

public class layoutContainer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.testMinimumViewSize(harness);
    }

    private void test1(TestHarness h) {
        JViewport vp = new JViewport();
        ViewportLayout layout2 = (ViewportLayout)vp.getLayout();
        JPanel view = new JPanel(){};
        vp.setView(view);
        view.setMinimumSize(new Dimension(100, 100));
        view.setPreferredSize(new Dimension(200, 200));
        view.setMaximumSize(new Dimension(300, 300));
        vp.setSize(400, 400);
        layout2.layoutContainer(vp);
        h.check(view.getSize(), new Dimension(400, 400));
    }

    private void test2(TestHarness h) {
        JViewport vp = new JViewport();
        ViewportLayout layout2 = (ViewportLayout)vp.getLayout();
        JPanel view = new JPanel(){};
        vp.setView(view);
        view.setMinimumSize(new Dimension(100, 100));
        view.setPreferredSize(new Dimension(200, 200));
        view.setMaximumSize(new Dimension(300, 300));
        vp.setSize(150, 150);
        layout2.layoutContainer(vp);
        h.check(view.getSize(), new Dimension(200, 200));
    }

    private void test3(TestHarness h) {
        JViewport vp = new JViewport();
        ViewportLayout layout2 = (ViewportLayout)vp.getLayout();
        JPanel view = new JPanel(){};
        vp.setView(view);
        view.setMinimumSize(new Dimension(100, 100));
        view.setPreferredSize(new Dimension(10, 10));
        view.setMaximumSize(new Dimension(300, 300));
        vp.setSize(50, 50);
        layout2.layoutContainer(vp);
        h.check(view.getSize(), new Dimension(50, 50));
    }

    private void testMinimumViewSize(TestHarness h) {
        JViewport vp = new JViewport();
        ViewportLayout l = (ViewportLayout)vp.getLayout();
        JPanel view = new JPanel();
        view.setMinimumSize(new Dimension(100, 100));
        view.setPreferredSize(new Dimension(200, 200));
        view.setMaximumSize(new Dimension(300, 300));
        vp.setSize(150, 150);
        vp.setView(view);
        view.setBounds(50, 50, 100, 100);
        l.layoutContainer(vp);
        h.check(view.getLocation(), new Point(50, 50));
    }
}

