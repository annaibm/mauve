/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

public class TestModel1
extends AbstractListModel
implements ComboBoxModel {
    private String[] principle = new String[]{"Free", "As", "In", "Freedom"};
    private String selected = this.principle[2];

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
        for (int i = 0; i < this.principle.length; ++i) {
            if (!this.principle[i].equals(str)) continue;
            this.selected = this.principle[i];
            return;
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.selected;
    }

    @Override
    public Object getElementAt(int index) {
        return this.principle[index];
    }

    @Override
    public int getSize() {
        return this.principle.length;
    }
}

