/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class addMouseWheelListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Button button = new Button("xyzzy");
        button.setBackground(Color.blue);
        MouseWheelListener[] mouseWheelListeners = button.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 0);
        button.addMouseWheelListener(new MouseWheelListener(){

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            }

            public String toString() {
                return "myMouseWheelListener";
            }
        });
        mouseWheelListeners = button.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 1);
        harness.check(mouseWheelListeners[0].toString(), (Object)"myMouseWheelListener");
    }
}

