/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import java.awt.Dimension;
import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

public class MyBasicComboBoxUI
extends BasicComboBoxUI {
    @Override
    public JButton createArrowButton() {
        return super.createArrowButton();
    }

    @Override
    public ComboBoxEditor createEditor() {
        return super.createEditor();
    }

    public ListCellRenderer createRenderer() {
        return super.createRenderer();
    }

    @Override
    public Dimension getDefaultSize() {
        return super.getDefaultSize();
    }

    @Override
    public Dimension getDisplaySize() {
        return super.getDisplaySize();
    }

    public JList getListBoxField() {
        return this.listBox;
    }

    public ComboPopup getComboPopupField() {
        return this.popup;
    }

    public JButton getArrowButton() {
        return this.arrowButton;
    }
}

