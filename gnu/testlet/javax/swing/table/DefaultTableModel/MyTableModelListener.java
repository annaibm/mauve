/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class MyTableModelListener
implements TableModelListener {
    private TableModelEvent event = null;

    public TableModelEvent getEvent() {
        return this.event;
    }

    public void setEvent(TableModelEvent event) {
        this.event = event;
    }

    @Override
    public void tableChanged(TableModelEvent event) {
        this.event = event;
    }
}

