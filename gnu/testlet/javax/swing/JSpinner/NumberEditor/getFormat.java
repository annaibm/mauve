/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.NumberEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.NumberFormat;
import javax.swing.JSpinner;
import javax.swing.text.DefaultFormatterFactory;

public class getFormat
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        JSpinner s = new JSpinner();
        JSpinner.NumberEditor e = new JSpinner.NumberEditor(s);
        harness.check(e.getTextField().getFormatterFactory() instanceof DefaultFormatterFactory);
        harness.check(e.getFormat(), NumberFormat.getInstance());
    }
}

