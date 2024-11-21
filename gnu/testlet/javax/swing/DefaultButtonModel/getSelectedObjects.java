/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultButtonModel;

public class getSelectedObjects
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultButtonModel m = new DefaultButtonModel();
        harness.check(m.getSelectedObjects(), null);
    }
}

