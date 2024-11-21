/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class addMouseWheelListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        MouseWheelListener[] mouseWheelListeners = checkbox.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 0);
        checkbox.addMouseWheelListener(new MouseWheelListener(){

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            }

            public String toString() {
                return "myMouseWheelListener";
            }
        });
        mouseWheelListeners = checkbox.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 1);
        harness.check(mouseWheelListeners[0].toString(), (Object)"myMouseWheelListener");
    }
}

