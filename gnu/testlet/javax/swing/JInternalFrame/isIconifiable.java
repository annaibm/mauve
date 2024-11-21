/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JInternalFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JInternalFrame;

public class isIconifiable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JInternalFrame f = new JInternalFrame("F1");
        harness.check(!f.isIconifiable());
        f.setIconifiable(true);
        harness.check(f.isIconifiable());
    }
}

