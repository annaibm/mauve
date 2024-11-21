/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;
import java.awt.List;
import java.awt.Point;
import java.awt.Robot;
import java.awt.TextArea;

public class getComponentAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Frame f = new Frame();
        List l = new List(10);
        TextArea t = new TextArea(10, 10);
        f.setSize(300, 300);
        t.setBounds(10, 10, 100, 100);
        l.setBounds(0, 0, 100, 100);
        t.setVisible(true);
        l.setVisible(false);
        f.add(l);
        f.add(t);
        f.show();
        Robot r = harness.createRobot();
        r.waitForIdle();
        r.delay(1000);
        Point po = l.getLocation();
        harness.check(t.isVisible(), true);
        harness.check(f.isVisible(), true);
        harness.check(l.isVisible(), false);
        harness.check(f.getComponentAt(po.x, po.y) == l);
        f.dispose();
    }
}

