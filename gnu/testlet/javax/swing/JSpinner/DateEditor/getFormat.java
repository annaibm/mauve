/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DateEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.DateFormat;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DefaultFormatterFactory;

public class getFormat
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        SpinnerDateModel m = new SpinnerDateModel();
        JSpinner s = new JSpinner(m);
        JSpinner.DateEditor e = new JSpinner.DateEditor(s);
        harness.check(e.getTextField().getFormatterFactory() instanceof DefaultFormatterFactory);
        harness.check(e.getFormat(), DateFormat.getInstance());
    }
}

