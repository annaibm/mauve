/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.filechooser.FileView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.filechooser.FileView.MyFileView;
import java.io.File;

public class isTraversable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyFileView fv = new MyFileView();
        File f = new File("File1.txt");
        harness.check(fv.isTraversable(f), (Object)null);
        harness.check(fv.isTraversable(null), (Object)null);
    }
}

