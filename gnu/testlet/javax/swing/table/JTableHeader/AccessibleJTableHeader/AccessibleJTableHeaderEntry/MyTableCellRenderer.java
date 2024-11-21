/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.JTableHeader.AccessibleJTableHeader.AccessibleJTableHeaderEntry;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyTableCellRenderer
extends JButton
implements TableCellRenderer {
    private Color bgColor;

    public void setBGColor(Color c) {
        this.bgColor = c;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table2, Object value2, boolean isSelected2, boolean hasFocus, int row, int column) {
        if (this.bgColor != null) {
            this.setBackground(this.bgColor);
        }
        return this;
    }

    @Override
    public boolean isFocusTraversable() {
        return false;
    }
}

