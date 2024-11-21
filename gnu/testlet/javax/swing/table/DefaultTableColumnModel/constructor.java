/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.DefaultTableColumnModel.MyDefaultTableColumnModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;

public class constructor
implements Testlet,
TableColumnModelListener {
    @Override
    public void columnAdded(TableColumnModelEvent e) {
    }

    @Override
    public void columnMarginChanged(ChangeEvent e) {
    }

    @Override
    public void columnMoved(TableColumnModelEvent e) {
    }

    @Override
    public void columnRemoved(TableColumnModelEvent e) {
    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent e) {
    }

    @Override
    public void test(TestHarness harness) {
        this.testGeneral(harness);
        this.testChangeEventInitialization(harness);
    }

    public void testGeneral(TestHarness harness) {
        harness.checkPoint("DefaultTableColumnModel()");
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        harness.check(m1.getColumnCount(), 0);
        harness.check(m1.getColumnMargin(), 1);
        harness.check(m1.getColumnSelectionAllowed(), false);
        harness.check(m1.getSelectedColumnCount(), 0);
    }

    private void testChangeEventInitialization(TestHarness harness) {
        harness.checkPoint("testChangeEventInitialization()");
        MyDefaultTableColumnModel m = new MyDefaultTableColumnModel();
        harness.check(m.getChangeEventField(), null);
        m.setColumnMargin(99);
        harness.check(m.getChangeEventField(), null);
        m.addColumnModelListener(this);
        m.setColumnMargin(100);
        harness.check(m.getChangeEventField() != null);
    }
}

