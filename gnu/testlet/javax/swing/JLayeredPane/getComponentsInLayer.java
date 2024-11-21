/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLayeredPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class getComponentsInLayer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testUnknownLayer(harness);
    }

    private void testUnknownLayer(TestHarness harness) {
        harness.checkPoint("unknownLayer");
        JLayeredPane l = new JLayeredPane();
        JLabel l1 = new JLabel("Hello");
        l.setLayer(l1, 1);
        l.add(l1);
        JLabel l2 = new JLabel("World");
        l.setLayer(l2, 3);
        l.add(l2);
        harness.check(l.getComponentsInLayer(-1).length, 0);
        harness.check(l.getComponentsInLayer(0).length, 0);
        harness.check(l.getComponentsInLayer(-2).length, 0);
        harness.check(l.getComponentsInLayer(-4).length, 0);
    }
}

