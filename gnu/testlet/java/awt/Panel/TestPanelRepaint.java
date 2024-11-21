/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Panel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.List;
import java.awt.Panel;
import java.awt.Robot;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class TestPanelRepaint
implements Testlet {
    TestHarness harness;
    Robot r;
    boolean updateCalled;

    @Override
    public void test(TestHarness harness) {
        this.harness = harness;
        this.r = harness.createRobot();
        myPanel p = new myPanel();
        p.add(new List(10));
        Frame f = new Frame();
        f.add(p);
        f.pack();
        f.show();
        this.r.waitForIdle();
        this.r.delay(1000);
        f.move(100, 100);
        this.r.delay(3000);
        f.setSize(400, 400);
        this.r.delay(3000);
        harness.check(this.updateCalled);
        f.dispose();
    }

    public class myPanel
    extends Panel
    implements ComponentListener {
        public myPanel() {
            this.addComponentListener(this);
        }

        @Override
        public void update(Graphics g) {
            TestPanelRepaint.this.updateCalled = true;
            super.update(g);
        }

        @Override
        public void componentResized(ComponentEvent e) {
            this.repaint();
        }

        @Override
        public void componentMoved(ComponentEvent e) {
            this.repaint();
        }

        @Override
        public void componentShown(ComponentEvent e) {
            this.repaint();
        }

        @Override
        public void componentHidden(ComponentEvent e) {
            this.repaint();
        }
    }
}

