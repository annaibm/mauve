/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JTable.MyJTable;
import javax.swing.DefaultListSelectionModel;
import javax.swing.ListSelectionModel;

public class createDefaultSelectionModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("createDefaultSelectionModel()");
        MyJTable t = new MyJTable();
        ListSelectionModel m = t.createDefaultSelectionModel();
        harness.check(m instanceof DefaultListSelectionModel);
        harness.check(m.isSelectionEmpty());
        harness.check(m.getSelectionMode(), 2);
    }
}

