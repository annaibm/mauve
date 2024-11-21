/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JFileChooser.MyFileSystemView;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class getFileSystemView
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser jfc = new JFileChooser();
        harness.check(jfc.getFileSystemView(), FileSystemView.getFileSystemView());
        MyFileSystemView fsv1 = new MyFileSystemView();
        jfc.setFileSystemView(fsv1);
        harness.check(jfc.getFileSystemView(), fsv1);
        jfc.setFileSystemView(null);
        harness.check(jfc.getFileSystemView(), null);
    }
}

