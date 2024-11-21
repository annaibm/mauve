/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLayeredPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class moveToFront
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testSimple(harness);
    }

    private void testSimple(TestHarness harness) {
        harness.checkPoint("testSimple");
        JLayeredPane l = new JLayeredPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.moveToFront(p2);
        harness.check(l.getComponent(0), p2);
        harness.check(l.getComponent(1), p1);
        harness.check(l.getComponent(2), p3);
    }
}

