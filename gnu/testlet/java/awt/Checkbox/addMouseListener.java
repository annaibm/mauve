/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class addMouseListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        MouseListener[] mouseListeners = checkbox.getMouseListeners();
        harness.check(mouseListeners.length, 0);
        checkbox.addMouseListener(new MouseListener(){

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
        mouseListeners = checkbox.getMouseListeners();
        harness.check(mouseListeners.length, 1);
        harness.check(mouseListeners[0].toString(), (Object)"myMouseListener");
    }
}

