/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.ListEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

public class getModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        SpinnerListModel m = new SpinnerListModel(new String[]{"A", "B", "C"});
        JSpinner s = new JSpinner(m);
        JSpinner.ListEditor editor = (JSpinner.ListEditor)s.getEditor();
        harness.check(editor.getModel(), m);
    }
}

