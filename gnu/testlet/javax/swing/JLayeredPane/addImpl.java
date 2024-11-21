/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JLayeredPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class addImpl
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testAddSameLayer(harness);
        this.testAddDifferentLayers(harness);
        this.testAddZeroPosition(harness);
    }

    private void testAddSameLayer(TestHarness h) {
        JLayeredPane l = new JLayeredPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        l.add((Component)p1, JLayeredPane.FRAME_CONTENT_LAYER);
        l.add((Component)p2, JLayeredPane.FRAME_CONTENT_LAYER);
        l.add((Component)p3, JLayeredPane.FRAME_CONTENT_LAYER);
        h.check(l.getComponent(0), p1);
        h.check(l.getComponent(1), p2);
        h.check(l.getComponent(2), p3);
    }

    private void testAddDifferentLayers(TestHarness h) {
        JLayeredPane l = new JLayeredPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        l.add((Component)p1, new Integer(0));
        l.add((Component)p2, new Integer(1));
        l.add((Component)p3, new Integer(2));
        h.check(l.getComponent(0), p3);
        h.check(l.getComponent(1), p2);
        h.check(l.getComponent(2), p1);
    }

    private void testAddZeroPosition(TestHarness h) {
        JLayeredPane l = new JLayeredPane();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        l.add(p1, JLayeredPane.FRAME_CONTENT_LAYER, 0);
        l.add(p2, JLayeredPane.FRAME_CONTENT_LAYER, 0);
        l.add(p3, JLayeredPane.FRAME_CONTENT_LAYER, 0);
        h.check(l.getComponent(0), p3);
        h.check(l.getComponent(1), p2);
        h.check(l.getComponent(2), p1);
    }
}

