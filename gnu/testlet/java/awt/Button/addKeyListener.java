/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class addKeyListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Button button = new Button("xyzzy");
        button.setBackground(Color.blue);
        KeyListener[] keyListeners = button.getKeyListeners();
        harness.check(keyListeners.length, 0);
        button.addKeyListener(new KeyListener(){

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
        keyListeners = button.getKeyListeners();
        harness.check(keyListeners.length, 1);
        harness.check(keyListeners[0].toString(), (Object)"myKeyListener");
    }
}

