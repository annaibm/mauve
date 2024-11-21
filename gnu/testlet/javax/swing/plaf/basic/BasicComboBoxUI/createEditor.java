/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUI;
import java.awt.Component;
import javax.swing.ComboBoxEditor;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class createEditor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        ComboBoxEditor editor = ui.createEditor();
        harness.check(editor instanceof BasicComboBoxEditor.UIResource);
        Component comp = editor.getEditorComponent();
        harness.check(comp instanceof JTextField);
        JTextField tf = (JTextField)comp;
        harness.check(tf.getColumns(), 9);
    }
}

