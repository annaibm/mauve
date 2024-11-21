/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import javax.swing.JComboBox;

public class MyJComboBox
extends JComboBox {
    public MyJComboBox(Object[] items) {
        super(items);
    }

    public Object getSelectedItemReminder() {
        return this.selectedItemReminder;
    }
}

