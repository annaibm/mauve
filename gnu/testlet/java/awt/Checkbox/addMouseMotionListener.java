/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class addMouseMotionListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        MouseMotionListener[] mouseMotionListeners = checkbox.getMouseMotionListeners();
        harness.check(mouseMotionListeners.length, 0);
        checkbox.addMouseMotionListener(new MouseMotionListener(){

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
        mouseMotionListeners = checkbox.getMouseMotionListeners();
        harness.check(mouseMotionListeners.length, 1);
        harness.check(mouseMotionListeners[0].toString(), (Object)"myMouseMotionListener");
    }
}

