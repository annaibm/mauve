/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class addMouseListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        MouseListener[] mouseListeners = label.getMouseListeners();
        harness.check(mouseListeners.length, 0);
        label.addMouseListener(new MouseListener(){

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
        mouseListeners = label.getMouseListeners();
        harness.check(mouseListeners.length, 1);
        harness.check(mouseListeners[0].toString(), (Object)"myMouseListener");
    }
}

