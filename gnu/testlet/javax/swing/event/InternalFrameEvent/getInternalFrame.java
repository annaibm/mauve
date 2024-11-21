/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.InternalFrameEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;

public class getInternalFrame
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        InternalFrameEvent e = new InternalFrameEvent(f, 25554);
        harness.check(e.getInternalFrame(), f);
        JInternalFrame f2 = new JInternalFrame("Title2");
        e.setSource(f2);
        harness.check(e.getInternalFrame(), f2);
        e.setSource(null);
        harness.check(e.getInternalFrame(), null);
    }
}

