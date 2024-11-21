/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getApproveButtonText
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(0);
        BasicFileChooserUI ui = new BasicFileChooserUI(fc);
        ui.installUI(fc);
        harness.check(ui.getApproveButtonText(fc), (Object)"Open");
        fc.setDialogType(1);
        harness.check(ui.getApproveButtonText(fc), (Object)"Save");
        fc.setApproveButtonText("Hello World!");
        harness.check(ui.getApproveButtonText(fc), (Object)"Hello World!");
        boolean pass = false;
        try {
            ui.getApproveButtonText(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

