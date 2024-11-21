/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;

public class getAutoCreateColumnsFromModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getAutoCreateColumnsFromModel()");
        JTable t = new JTable();
        harness.check(t.getAutoCreateColumnsFromModel(), true);
        t.setAutoCreateColumnsFromModel(false);
        harness.check(t.getAutoCreateColumnsFromModel(), false);
    }
}

