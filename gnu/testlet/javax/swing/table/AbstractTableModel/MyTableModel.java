/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import javax.swing.table.AbstractTableModel;

public class MyTableModel
extends AbstractTableModel {
    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return new Integer(column);
    }
}

