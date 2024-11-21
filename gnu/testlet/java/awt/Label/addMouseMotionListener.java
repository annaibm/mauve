/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class addMouseMotionListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        MouseMotionListener[] mouseMotionListeners = label.getMouseMotionListeners();
        harness.check(mouseMotionListeners.length, 0);
        label.addMouseMotionListener(new MouseMotionListener(){

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
        mouseMotionListeners = label.getMouseMotionListeners();
        harness.check(mouseMotionListeners.length, 1);
        harness.check(mouseMotionListeners[0].toString(), (Object)"myMouseMotionListener");
    }
}

