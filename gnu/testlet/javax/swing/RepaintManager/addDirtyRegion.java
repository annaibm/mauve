/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.RepaintManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.RepaintManager.DisabledEventQueue;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.RepaintManager;

public class addDirtyRegion
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
    }

    private void test1(TestHarness harness) {
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(new DisabledEventQueue());
        JFrame f = new JFrame();
        JLabel l = new JLabel("Hello");
        f.getContentPane().add(l);
        l.setSize(100, 100);
        f.setSize(200, 200);
        f.setVisible(true);
        RepaintManager rm = RepaintManager.currentManager(l);
        rm.addDirtyRegion(l, 0, 0, l.getWidth(), l.getHeight());
        harness.check(rm.isCompletelyDirty(l), false);
        Rectangle dirty = rm.getDirtyRegion(l);
        harness.check(dirty.x, 0);
        harness.check(dirty.y, 0);
        harness.check(dirty.width, l.getWidth());
        harness.check(dirty.height, l.getHeight());
    }
}

