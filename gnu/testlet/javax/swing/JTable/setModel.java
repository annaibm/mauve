/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class setModel
implements Testlet {
    boolean propertyChangeFired;

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.testLeadAnchorSelectionUpdate(harness);
        this.testSelectionModel(harness);
        this.testPropertyFired(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("setModel(TableModel) - test1");
        DefaultTableModel m1 = new DefaultTableModel();
        JTable t = new JTable(m1);
        DefaultTableModel m2 = new DefaultTableModel();
        t.setModel(m2);
        TableModelListener[] listeners1 = m1.getTableModelListeners();
        TableModelListener[] listeners2 = m2.getTableModelListeners();
        harness.check(!Arrays.asList(listeners1).contains(t));
        harness.check(Arrays.asList(listeners2).contains(t));
        boolean pass = false;
        try {
            t.setModel(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("setModel(TableModel) - test2");
        DefaultTableModel m1 = new DefaultTableModel(2, 3);
        JTable t = new JTable(m1);
        TableColumnModel tcm = t.getColumnModel();
        tcm.getColumn(1).setModelIndex(0);
        tcm.getColumn(0).setModelIndex(1);
        harness.check(t.getColumnCount(), 3);
        harness.check(t.getColumnName(0), (Object)"B");
        harness.check(t.getColumnName(1), (Object)"A");
        harness.check(t.getColumnName(2), (Object)"C");
        DefaultTableModel m2 = new DefaultTableModel(new String[]{"AA", "BB"}, 1);
        t.setModel(m2);
        harness.check(t.getColumnCount(), 2);
        harness.check(t.getColumnName(0), (Object)"AA");
        harness.check(t.getColumnName(1), (Object)"BB");
        tcm = t.getColumnModel();
        tcm.getColumn(1).setModelIndex(0);
        tcm.getColumn(0).setModelIndex(1);
        t.setAutoCreateColumnsFromModel(false);
        DefaultTableModel m3 = new DefaultTableModel(new String[]{"CC", "DD", "EE"}, 1);
        t.setModel(m3);
        harness.check(t.getColumnCount(), 2);
        harness.check(t.getColumnName(0), (Object)"DD");
        harness.check(t.getColumnName(1), (Object)"CC");
    }

    private void testLeadAnchorSelectionUpdate(TestHarness harness) {
        harness.checkPoint("leadAnchorSelectionUpdate");
        JTable table2 = new JTable(0, 0);
        table2.setModel(new DefaultTableModel(0, 0));
        try {
            Thread.sleep(500L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(table2.getSelectionModel().getLeadSelectionIndex(), -1);
        harness.check(table2.getSelectionModel().getAnchorSelectionIndex(), -1);
        harness.check(table2.getColumnModel().getSelectionModel().getLeadSelectionIndex(), -1);
        harness.check(table2.getColumnModel().getSelectionModel().getAnchorSelectionIndex(), -1);
        table2.setModel(new DefaultTableModel(1, 0));
        try {
            Thread.sleep(500L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(table2.getSelectionModel().getLeadSelectionIndex(), 0);
        harness.check(table2.getSelectionModel().getAnchorSelectionIndex(), 0);
        harness.check(table2.getColumnModel().getSelectionModel().getLeadSelectionIndex(), -1);
        harness.check(table2.getColumnModel().getSelectionModel().getAnchorSelectionIndex(), -1);
        table2.setModel(new DefaultTableModel(0, 1));
        try {
            Thread.sleep(500L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(table2.getSelectionModel().getLeadSelectionIndex(), -1);
        harness.check(table2.getSelectionModel().getAnchorSelectionIndex(), -1);
        harness.check(table2.getColumnModel().getSelectionModel().getLeadSelectionIndex(), 0);
        harness.check(table2.getColumnModel().getSelectionModel().getAnchorSelectionIndex(), 0);
        table2.setModel(new DefaultTableModel(1, 1));
        try {
            Thread.sleep(500L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        harness.check(table2.getSelectionModel().getLeadSelectionIndex(), 0);
        harness.check(table2.getSelectionModel().getAnchorSelectionIndex(), 0);
        harness.check(table2.getColumnModel().getSelectionModel().getLeadSelectionIndex(), 0);
        harness.check(table2.getColumnModel().getSelectionModel().getAnchorSelectionIndex(), 0);
    }

    private void testSelectionModel(TestHarness harness) {
        harness.checkPoint("selectionModel");
        JTable table2 = new JTable();
        ListSelectionModel m1 = table2.getSelectionModel();
        m1.addSelectionInterval(1, 1);
        harness.check(m1.isSelectedIndex(1), true);
        table2.setModel(new DefaultTableModel());
        harness.check(table2.getSelectionModel() == m1);
        harness.check(m1.isSelectedIndex(1), false);
    }

    private void testPropertyFired(TestHarness harness) {
        harness.checkPoint("propertyFired");
        JTable table2 = new JTable();
        table2.addPropertyChangeListener(new PropertyChangeHandler());
        DefaultTableModel m1 = new DefaultTableModel();
        DefaultTableModel m2 = new DefaultTableModel();
        this.propertyChangeFired = false;
        table2.setModel(m1);
        harness.check(this.propertyChangeFired, true);
        this.propertyChangeFired = false;
        table2.setModel(m1);
        harness.check(this.propertyChangeFired, false);
        this.propertyChangeFired = false;
        table2.setModel(m2);
        harness.check(this.propertyChangeFired, true);
        try {
            table2.setModel(null);
            harness.fail("IllegalArgumenException must be fired");
        }
        catch (IllegalArgumentException ex) {
            harness.check(true);
        }
    }

    class PropertyChangeHandler
    implements PropertyChangeListener {
        PropertyChangeHandler() {
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            setModel.this.propertyChangeFired = true;
        }
    }
}

