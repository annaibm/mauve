/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class MyListDataListener
implements ListDataListener {
    private ListDataEvent event = null;

    @Override
    public void intervalAdded(ListDataEvent e) {
        this.event = e;
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        this.event = e;
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        this.event = e;
    }

    public ListDataEvent getEvent() {
        return this.event;
    }

    public void setListDataEvent(ListDataEvent e) {
        this.event = e;
    }
}

