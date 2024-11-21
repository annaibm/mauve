/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getFileView
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        BasicFileChooserUI ui = new BasicFileChooserUI(fc);
        harness.check(ui.getFileView(fc) != null);
        ui.installUI(fc);
        FileView fv = ui.getFileView(fc);
        harness.check(fv != null);
        FileView myFV = new FileView(){};
        fc.setFileView(myFV);
        harness.check(ui.getFileView(fc) != myFV);
        harness.check(ui.getFileView(null) != null);
    }
}

