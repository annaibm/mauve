/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JSpinner;

public class getEditor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("()");
        JSpinner s = new JSpinner();
        JSpinner.NumberEditor e = new JSpinner.NumberEditor(s);
        s.setEditor(e);
        harness.check(s.getEditor(), e);
    }
}

