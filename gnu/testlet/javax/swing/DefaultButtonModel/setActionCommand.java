/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultButtonModel;

public class setActionCommand
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultButtonModel m = new DefaultButtonModel();
        m.setActionCommand("XYZ");
        harness.check(m.getActionCommand(), (Object)"XYZ");
        m.setActionCommand(null);
        harness.check(m.getActionCommand(), null);
    }
}

