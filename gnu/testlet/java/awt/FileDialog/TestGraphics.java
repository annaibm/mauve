/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FileDialog;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Robot;

public class TestGraphics
implements Testlet {
    FileDialog d = null;
    Robot r = null;
    boolean paintCalled = false;
    boolean updateCalled = false;

    @Override
    public void test(TestHarness harness) {
        Frame f = new Frame();
        this.d = new FileDialog(f);
        this.r = harness.createRobot();
        f.setSize(200, 200);
        f.show();
        harness.check(this.d.getGraphics() == null);
        new Thread(){

            @Override
            public void run() {
                TestGraphics.this.r.delay(2000);
                TestGraphics.this.d.hide();
            }
        }.start();
        this.d.show();
        harness.check(this.d.getGraphics() != null);
        this.d.dispose();
        harness.check(this.d.getGraphics() == null);
        this.d = new FileDialog(f){

            @Override
            public void paint(Graphics g) {
                TestGraphics.this.paintCalled = true;
            }

            @Override
            public void update(Graphics g) {
                TestGraphics.this.updateCalled = true;
            }
        };
        new Thread(){

            @Override
            public void run() {
                TestGraphics.this.r.delay(2000);
                TestGraphics.this.d.hide();
            }
        }.start();
        this.d.show();
        harness.check(this.paintCalled);
        harness.check(!this.updateCalled);
        this.d.repaint();
        this.r.waitForIdle();
        this.r.delay(1000);
        harness.check(!this.updateCalled);
    }
}

