/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("TableColumn()");
        TableColumn c1 = new TableColumn();
        harness.check(c1.getModelIndex(), 0);
        harness.check(c1.getMinWidth(), 15);
        harness.check(c1.getWidth(), 75);
        harness.check(c1.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c1.getCellRenderer(), null);
        harness.check(c1.getCellEditor(), null);
        harness.check(c1.getHeaderValue(), null);
        harness.check(c1.getResizable(), true);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("TableColumn(int)");
        TableColumn c1 = new TableColumn(1);
        harness.check(c1.getModelIndex(), 1);
        harness.check(c1.getMinWidth(), 15);
        harness.check(c1.getWidth(), 75);
        harness.check(c1.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c1.getCellRenderer(), null);
        harness.check(c1.getCellEditor(), null);
        harness.check(c1.getHeaderValue(), null);
        harness.check(c1.getResizable(), true);
        TableColumn c2 = new TableColumn(-1);
        harness.check(c2.getModelIndex(), -1);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("TableColumn(int, int)");
        TableColumn c1 = new TableColumn(1, 33);
        harness.check(c1.getModelIndex(), 1);
        harness.check(c1.getMinWidth(), 15);
        harness.check(c1.getWidth(), 33);
        harness.check(c1.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c1.getCellRenderer(), null);
        harness.check(c1.getCellEditor(), null);
        harness.check(c1.getHeaderValue(), null);
        harness.check(c1.getResizable(), true);
        TableColumn c2 = new TableColumn(1, -1);
        harness.check(c2.getWidth(), -1);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("TableColumn(int, int, TableCellRenderer, TableCellEditor)");
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        DefaultCellEditor editor = new DefaultCellEditor(new JCheckBox());
        TableColumn c1 = new TableColumn(1, 33, renderer, editor);
        harness.check(c1.getModelIndex(), 1);
        harness.check(c1.getMinWidth(), 15);
        harness.check(c1.getWidth(), 33);
        harness.check(c1.getMaxWidth(), Integer.MAX_VALUE);
        harness.check(c1.getCellRenderer(), renderer);
        harness.check(c1.getCellEditor(), editor);
        harness.check(c1.getHeaderValue(), null);
        harness.check(c1.getResizable(), true);
    }
}

