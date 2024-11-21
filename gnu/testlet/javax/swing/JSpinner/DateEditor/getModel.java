/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DateEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class getModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        SpinnerDateModel m = new SpinnerDateModel(new Date(50L), new Date(0L), new Date(100L), 14);
        JSpinner s = new JSpinner(m);
        JSpinner.DateEditor editor = (JSpinner.DateEditor)s.getEditor();
        harness.check(editor.getModel(), m);
    }
}

