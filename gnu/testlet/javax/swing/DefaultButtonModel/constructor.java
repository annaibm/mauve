/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultButtonModel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultButtonModel m = new DefaultButtonModel();
        harness.check(m.getActionCommand(), null);
        harness.check(m.getGroup(), null);
        harness.check(m.isArmed(), false);
        harness.check(m.isEnabled(), true);
        harness.check(m.isPressed(), false);
        harness.check(m.isRollover(), false);
        harness.check(m.isSelected(), false);
    }
}

