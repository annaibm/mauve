/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class addKeyListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        KeyListener[] keyListeners = canvas.getKeyListeners();
        harness.check(keyListeners.length, 0);
        canvas.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }

            public String toString() {
                return "myKeyListener";
            }
        });
        keyListeners = canvas.getKeyListeners();
        harness.check(keyListeners.length, 1);
        harness.check(keyListeners[0].toString(), (Object)"myKeyListener");
    }
}

