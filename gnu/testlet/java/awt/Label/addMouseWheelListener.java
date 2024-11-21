/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class addMouseWheelListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        MouseWheelListener[] mouseWheelListeners = label.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 0);
        label.addMouseWheelListener(new MouseWheelListener(){

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            }

            public String toString() {
                return "myMouseWheelListener";
            }
        });
        mouseWheelListeners = label.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 1);
        harness.check(mouseWheelListeners[0].toString(), (Object)"myMouseWheelListener");
    }
}

