/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI;

import javax.swing.ActionMap;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class MyMetalFileChooserUI
extends MetalFileChooserUI {
    public MyMetalFileChooserUI(JFileChooser fc) {
        super(fc);
    }

    @Override
    public JPanel getButtonPanel() {
        return super.getButtonPanel();
    }

    @Override
    public JPanel getBottomPanel() {
        return super.getBottomPanel();
    }

    @Override
    public ActionMap createActionMap() {
        return super.createActionMap();
    }

    @Override
    public MetalFileChooserUI.FilterComboBoxModel createFilterComboBoxModel() {
        return super.createFilterComboBoxModel();
    }

    @Override
    public JButton getApproveButton(JFileChooser fc) {
        return super.getApproveButton(fc);
    }

    public class MyFilterComboBoxModel
    extends MetalFileChooserUI.FilterComboBoxModel {
        public MyFilterComboBoxModel() {
            super(MyMetalFileChooserUI.this);
        }
    }
}

