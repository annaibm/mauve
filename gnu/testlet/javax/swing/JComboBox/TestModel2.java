/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import java.util.LinkedList;
import javax.swing.AbstractListModel;
import javax.swing.MutableComboBoxModel;

public class TestModel2
extends AbstractListModel
implements MutableComboBoxModel {
    private LinkedList stuff = new LinkedList();
    private String selected;

    public TestModel2() {
        for (int i = 0; i < 10; ++i) {
            this.stuff.add(String.valueOf(i));
        }
        this.selected = (String)this.stuff.get(0);
    }

    @Override
    public void setSelectedItem(Object o) {
        if (o == null) {
            this.selected = null;
            return;
        }
        if (!(o instanceof String)) {
            return;
        }
        String str = (String)o;
        int index = this.stuff.indexOf(o);
        if (index != -1) {
            this.selected = (String)this.stuff.get(index);
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.selected;
    }

    @Override
    public Object getElementAt(int index) {
        return this.stuff.get(index);
    }

    @Override
    public int getSize() {
        return this.stuff.size();
    }

    public void addElement(Object obj) {
        this.stuff.add(obj);
        int index = this.stuff.size() - 1;
        this.fireIntervalAdded(obj, index, index);
    }

    @Override
    public void removeElement(Object obj) {
        int index = this.stuff.indexOf(obj);
        if (index != -1) {
            this.stuff.remove(obj);
            this.fireIntervalRemoved(obj, index, index);
        }
    }

    public void insertElementAt(Object obj, int index) {
        this.stuff.add(index, obj);
        this.fireIntervalAdded(obj, index, index);
    }

    @Override
    public void removeElementAt(int index) {
        this.fireIntervalRemoved(this.stuff.remove(index), index, index);
    }
}

