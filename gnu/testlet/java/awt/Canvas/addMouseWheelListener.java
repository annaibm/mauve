/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class addMouseWheelListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        MouseWheelListener[] mouseWheelListeners = canvas.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 0);
        canvas.addMouseWheelListener(new MouseWheelListener(){

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            }

            public String toString() {
                return "myMouseWheelListener";
            }
        });
        mouseWheelListeners = canvas.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 1);
        harness.check(mouseWheelListeners[0].toString(), (Object)"myMouseWheelListener");
    }
}

