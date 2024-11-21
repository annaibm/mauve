/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JInternalFrame;

public class getDesktopIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("Title");
        JInternalFrame.JDesktopIcon icon = new JInternalFrame.JDesktopIcon(f);
        f.setDesktopIcon(icon);
        harness.check(f.getDesktopIcon(), icon);
        f.setDesktopIcon(null);
        harness.check(f.getDesktopIcon(), null);
    }
}

