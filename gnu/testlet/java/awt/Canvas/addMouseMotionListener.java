/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class addMouseMotionListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        MouseMotionListener[] mouseMotionListeners = canvas.getMouseMotionListeners();
        harness.check(mouseMotionListeners.length, 0);
        canvas.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

            public String toString() {
                return "myMouseMotionListener";
            }
        });
        mouseMotionListeners = canvas.getMouseMotionListeners();
        harness.check(mouseMotionListeners.length, 1);
        harness.check(mouseMotionListeners[0].toString(), (Object)"myMouseMotionListener");
    }
}

