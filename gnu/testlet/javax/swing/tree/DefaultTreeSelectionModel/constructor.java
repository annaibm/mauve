/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.tree.DefaultTreeSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.tree.DefaultTreeSelectionModel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness h) {
        DefaultTreeSelectionModel m = new DefaultTreeSelectionModel();
        h.check(m.getLeadSelectionPath(), null, "getLeadSelectionPath()");
        h.check(m.getLeadSelectionRow(), -1, "getLeadSelectionRow()");
        h.check(m.getMaxSelectionRow(), -1, "getMaxSelectionRow()");
        h.check(m.getMinSelectionRow(), -1, "getMinSelectionRow()");
        h.check(m.getRowMapper(), null, "getRowMapper()");
        h.check(m.getSelectionCount(), 0, "getSelectionCount()");
        h.check(m.getSelectionMode(), 4, "getSelectionMode()");
        h.check(m.getSelectionPath(), null, "getSelectionPath()");
        h.check(m.getSelectionPaths(), null, "getSelectionPaths()");
        h.check(m.getSelectionRows(), null, "getSelectionRows()");
        h.check(m.isSelectionEmpty(), true, "isSelectionEmpty()");
    }
}

