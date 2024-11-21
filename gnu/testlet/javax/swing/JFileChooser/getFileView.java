/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileView;

public class getFileView
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getFileView(), null);
        FileView fv1 = new FileView(){};
        jfc.setFileView(fv1);
        harness.check(jfc.getFileView(), fv1);
        jfc.setFileView(null);
        harness.check(jfc.getFileView(), null);
    }
}

