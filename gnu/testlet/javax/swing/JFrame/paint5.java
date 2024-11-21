/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class paint5
implements Testlet {
    static final int FRAME_SIZE = 200;
    static final int CHILD_SIZE = 50;
    component north = new component("north");
    component center = new component("center");
    component south = new component("south");
    component east = new component("east");
    component west = new component("west");
    Dimension pane;
    int totalPainted = 0;
    Thread thread;

    public JFrame showFrame() {
        JFrame frame = new JFrame();
        frame.getContentPane().add((Component)this.north, "North");
        frame.getContentPane().add((Component)this.south, "South");
        frame.getContentPane().add((Component)this.east, "East");
        frame.getContentPane().add((Component)this.west, "West");
        frame.getContentPane().add((Component)this.center, "Center");
        frame.setSize(new Dimension(200, 200));
        frame.setVisible(true);
        this.pane = frame.getContentPane().getSize();
        return frame;
    }

    @Override
    public void test(TestHarness harness) {
        this.thread = Thread.currentThread();
        JFrame frame = this.showFrame();
        try {
            Thread.sleep(10000L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.north.basicCheck(harness);
        harness.check(this.north.bounds.width, this.pane.width, " north, width");
        harness.check(this.north.bounds.height, 50, "north, height");
        harness.check(this.north.bounds.x, 0, "north, x");
        harness.check(this.north.bounds.y, 0, "north, y");
        this.south.basicCheck(harness);
        harness.check(this.south.bounds.width, this.pane.width, "south, width");
        harness.check(this.south.bounds.height, 50, "south, height");
        harness.check(this.south.bounds.x, 0, "south, x");
        harness.check(this.south.bounds.y, this.pane.height - 50, "south, y");
        this.east.basicCheck(harness);
        harness.check(this.east.bounds.width, 50, "east, width");
        harness.check(this.east.bounds.height, this.pane.height - 100, "east, height");
        harness.check(this.east.bounds.x, this.pane.width - 50, "east, x");
        harness.check(this.east.bounds.y, 50, "east, y");
        this.west.basicCheck(harness);
        harness.check(this.west.bounds.width, 50, "west, width");
        harness.check(this.west.bounds.height, this.pane.height - 100, "west, height");
        harness.check(this.west.bounds.x, 0, "west, x");
        harness.check(this.west.bounds.y, 50, "west, y");
        this.center.basicCheck(harness);
        harness.check(this.center.bounds.width, this.pane.width - 100, "center, width");
        harness.check(this.center.bounds.height, this.pane.height - 100, "center, height");
        harness.check(this.center.bounds.x, 50, "center, x");
        harness.check(this.center.bounds.y, 50, "center, y");
        try {
            Thread.sleep(200L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        frame.setVisible(false);
        frame.dispose();
        frame = null;
        this.thread = null;
        this.pane = null;
        this.east = null;
        this.south = null;
        this.center = null;
        this.north = null;
    }

    class component
    extends JComponent {
        String name;
        int painted;
        Rectangle bounds;
        Color color;

        component(String _name) {
            this.name = _name;
            this.setPreferredSize(new Dimension(50, 50));
        }

        @Override
        public void paint(Graphics g) {
            ++this.painted;
            this.color = g.getColor();
            this.bounds = this.getBounds();
            g.setColor(Color.white);
            g.fillOval(0, 0, this.bounds.width, this.bounds.height);
            g.setColor(Color.red);
            g.drawString(this.name, 25, 25);
            ++paint5.this.totalPainted;
            if (paint5.this.totalPainted >= 5) {
                paint5.this.thread.interrupt();
            }
        }

        void basicCheck(TestHarness h) {
            h.check(this.bounds != null, this.name + " seems never painted");
            h.check(this.color.getRed() == 0 && this.color.getGreen() == 0 && this.color.getBlue() == 0, this.name + ": default color must be black");
            h.check(this.painted, 1, this.name + " must be painted exactly once");
            h.checkPoint(this.name + " placement");
        }
    }
}

