/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Point;

public class getLocationOnScreen
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testOverrideSafety(harness);
    }

    private void testOverrideSafety(TestHarness h) {
        Frame f = new Frame();
        FakeContainer cont = new FakeContainer();
        Component comp = new Component(){};
        f.add(cont);
        cont.add(comp);
        f.setSize(100, 100);
        f.setVisible(true);
        cont.setBounds(10, 10, 80, 80);
        comp.setBounds(10, 10, 60, 60);
        Point frameLoc = f.getLocationOnScreen();
        Point compLoc = comp.getLocationOnScreen();
        h.check(compLoc.x, frameLoc.x + 20);
        h.check(compLoc.y, frameLoc.y + 20);
        f.dispose();
    }

    private class FakeContainer
    extends Container {
        private FakeContainer() {
        }

        @Override
        public Point getLocationOnScreen() {
            return new Point(-1200, 12345);
        }
    }
}

