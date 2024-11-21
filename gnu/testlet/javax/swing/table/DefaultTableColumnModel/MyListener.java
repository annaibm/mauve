/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

public class MyListener
implements TableColumnModelListener,
PropertyChangeListener {
    private TableColumnModelEvent event;
    private ChangeEvent changeEvent;
    private ListSelectionEvent selectionEvent;

    public MyListener() {
        this.clearEvents();
    }

    public void clearEvents() {
        this.event = null;
        this.changeEvent = null;
        this.selectionEvent = null;
    }

    public TableColumnModelEvent getEvent() {
        return this.event;
    }

    public ChangeEvent getChangeEvent() {
        return this.changeEvent;
    }

    public ListSelectionEvent getSelectionEvent() {
        return this.selectionEvent;
    }

    @Override
    public void columnAdded(TableColumnModelEvent event) {
        this.event = event;
    }

    @Override
    public void columnMarginChanged(ChangeEvent event) {
        this.changeEvent = event;
    }

    @Override
    public void columnMoved(TableColumnModelEvent event) {
        this.event = event;
    }

    @Override
    public void columnRemoved(TableColumnModelEvent event) {
        this.event = event;
    }

    @Override
    public void columnSelectionChanged(ListSelectionEvent event) {
        this.selectionEvent = event;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.toString());
    }
}

