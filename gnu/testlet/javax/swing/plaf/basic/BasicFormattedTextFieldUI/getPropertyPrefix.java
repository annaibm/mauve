/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFormattedTextFieldUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicFormattedTextFieldUI.MyBasicFormattedTextFieldUI;

public class getPropertyPrefix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyBasicFormattedTextFieldUI ui = new MyBasicFormattedTextFieldUI();
        harness.check(ui.getPropertyPrefix(), (Object)"FormattedTextField");
    }
}

