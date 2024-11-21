/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class addMouseListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        MouseListener[] mouseListeners = canvas.getMouseListeners();
        harness.check(mouseListeners.length, 0);
        canvas.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            public String toString() {
                return "myMouseListener";
            }
        });
        mouseListeners = canvas.getMouseListeners();
        harness.check(mouseListeners.length, 1);
        harness.check(mouseListeners[0].toString(), (Object)"myMouseListener");
    }
}

