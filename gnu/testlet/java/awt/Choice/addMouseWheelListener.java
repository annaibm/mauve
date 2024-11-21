/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Choice;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Choice;
import java.awt.Color;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class addMouseWheelListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Choice choice = new Choice();
        choice.setBackground(Color.blue);
        MouseWheelListener[] mouseWheelListeners = choice.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 0);
        choice.addMouseWheelListener(new MouseWheelListener(){

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
            }

            public String toString() {
                return "myMouseWheelListener";
            }
        });
        mouseWheelListeners = choice.getMouseWheelListeners();
        harness.check(mouseWheelListeners.length, 1);
        harness.check(mouseWheelListeners[0].toString(), (Object)"myMouseWheelListener");
    }
}

