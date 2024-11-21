/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BasicComboBoxEditor e = new BasicComboBoxEditor();
        JTextField f = (JTextField)e.getEditorComponent();
        harness.check(f.getColumns(), 9);
        harness.check(f.getBorder(), null);
    }
}

