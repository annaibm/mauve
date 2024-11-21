/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Graphics;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Robot;

public class TestPaintGraphics
implements Testlet {
    boolean onePaintDone = false;
    int firstGraphicsHashCode = 0;
    int secondGraphicsHashCode = 0;

    @Override
    public void test(TestHarness harness) {
        Frame f = new Frame();
        Panel p = new Panel(){

            @Override
            public void paint(Graphics g) {
                if (!TestPaintGraphics.this.onePaintDone) {
                    TestPaintGraphics.this.firstGraphicsHashCode = System.identityHashCode(g);
                    TestPaintGraphics.this.onePaintDone = true;
                    this.repaint();
                } else if (TestPaintGraphics.this.secondGraphicsHashCode == 0) {
                    TestPaintGraphics.this.secondGraphicsHashCode = System.identityHashCode(g);
                }
            }
        };
        f.add(p);
        f.setSize(200, 200);
        f.show();
        Robot r = harness.createRobot();
        r.delay(2000);
        harness.check(this.firstGraphicsHashCode != 0 && this.secondGraphicsHashCode != 0);
        harness.check(this.firstGraphicsHashCode != this.secondGraphicsHashCode);
    }
}

