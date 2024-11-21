/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getDialogTitle
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        BasicFileChooserUI ui = new BasicFileChooserUI(fc);
        harness.check(ui.getDialogTitle(fc), null);
        ui.installUI(fc);
        harness.check(ui.getDialogTitle(fc), (Object)"Open");
        fc.setDialogType(1);
        harness.check(ui.getDialogTitle(fc), (Object)"Save");
        fc.setDialogTitle("XYZ");
        harness.check(ui.getDialogTitle(fc), (Object)"XYZ");
        fc.setDialogTitle(null);
        harness.check(ui.getDialogTitle(fc), (Object)"Save");
        boolean pass = false;
        try {
            ui.getDialogTitle(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

