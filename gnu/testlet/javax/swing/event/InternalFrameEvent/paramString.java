/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.InternalFrameEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameEvent;

public class paramString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        InternalFrameEvent e = new InternalFrameEvent(f, 25554);
        harness.check(e.paramString(), (Object)"INTERNAL_FRAME_ACTIVATED");
        e = new InternalFrameEvent(f, 25551);
        harness.check(e.paramString(), (Object)"INTERNAL_FRAME_CLOSED");
        e = new InternalFrameEvent(f, 25550);
        harness.check(e.paramString(), (Object)"INTERNAL_FRAME_CLOSING");
        e = new InternalFrameEvent(f, 25555);
        harness.check(e.paramString(), (Object)"INTERNAL_FRAME_DEACTIVATED");
        e = new InternalFrameEvent(f, 25553);
        harness.check(e.paramString(), (Object)"INTERNAL_FRAME_DEICONIFIED");
        e = new InternalFrameEvent(f, 25552);
        harness.check(e.paramString(), (Object)"INTERNAL_FRAME_ICONIFIED");
        e = new InternalFrameEvent(f, 25549);
        harness.check(e.paramString(), (Object)"INTERNAL_FRAME_OPENED");
        e = new InternalFrameEvent(f, 1999);
        harness.check(e.paramString(), (Object)"unknown type");
    }
}

