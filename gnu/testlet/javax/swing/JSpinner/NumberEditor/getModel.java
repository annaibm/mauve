/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.NumberEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class getModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        SpinnerNumberModel m = new SpinnerNumberModel(50.0, 0.0, 100.0, 5.0);
        JSpinner s = new JSpinner(m);
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor)s.getEditor();
        harness.check(editor.getModel(), m);
    }
}

