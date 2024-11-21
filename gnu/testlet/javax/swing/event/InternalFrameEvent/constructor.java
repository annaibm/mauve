/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.InternalFrameEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        InternalFrameEvent e = new InternalFrameEvent(f, 25554);
        harness.check(e.getID(), 25554);
        harness.check(e.getInternalFrame(), f);
        boolean pass = false;
        try {
            e = new InternalFrameEvent(null, 25551);
        }
        catch (IllegalArgumentException event) {
            pass = true;
        }
        harness.check(pass);
        e = new InternalFrameEvent(f, -999);
        harness.check(e.getID(), -999);
    }
}

