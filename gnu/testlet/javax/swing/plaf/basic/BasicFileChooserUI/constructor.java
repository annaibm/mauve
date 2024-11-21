/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI.MyBasicFileChooserUI;
import javax.swing.JFileChooser;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        MyBasicFileChooserUI ui = new MyBasicFileChooserUI(fc);
        harness.check(ui.getFileChooser(), null);
        harness.check(ui.getCancelButtonText(), null);
        harness.check(ui.getCancelButtonToolTipText(), null);
        harness.check(ui.getApproveButton(fc), null);
    }
}

