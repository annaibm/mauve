/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getApproveButtonToolTipText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(0);
        BasicFileChooserUI ui = new BasicFileChooserUI(fc);
        ui.installUI(fc);
        harness.check(ui.getApproveButtonToolTipText(fc), (Object)"Open selected file");
        fc.setDialogType(1);
        harness.check(ui.getApproveButtonToolTipText(fc), (Object)"Save selected file");
        fc.setApproveButtonToolTipText("Hello World!");
        harness.check(ui.getApproveButtonToolTipText(fc), (Object)"Hello World!");
    }
}

