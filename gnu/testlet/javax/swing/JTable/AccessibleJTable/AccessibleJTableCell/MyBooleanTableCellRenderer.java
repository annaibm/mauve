/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable.AccessibleJTable.AccessibleJTableCell;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyBooleanTableCellRenderer
extends JCheckBox
implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table2, Object value2, boolean isSelected2, boolean hasFocus, int row, int column) {
        this.setSelected(isSelected2);
        return this;
    }
}

