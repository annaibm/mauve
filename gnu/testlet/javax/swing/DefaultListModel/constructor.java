/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("DefaultListModel()");
        DefaultListModel m1 = new DefaultListModel();
        harness.check(m1.isEmpty());
    }
}

