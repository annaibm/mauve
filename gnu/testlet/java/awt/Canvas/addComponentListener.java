/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class addComponentListener
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        ComponentListener[] componentListeners = canvas.getComponentListeners();
        harness.check(componentListeners.length, 0);
        canvas.addComponentListener(new ComponentListener(){

            @Override
            public void componentHidden(ComponentEvent e) {
            }

            @Override
            public void componentMoved(ComponentEvent e) {
            }

            @Override
            public void componentResized(ComponentEvent e) {
            }

            @Override
            public void componentShown(ComponentEvent e) {
            }

            public String toString() {
                return "myComponentListener";
            }
        });
        componentListeners = canvas.getComponentListeners();
        harness.check(componentListeners.length, 1);
        harness.check(componentListeners[0].toString(), (Object)"myComponentListener");
    }
}

