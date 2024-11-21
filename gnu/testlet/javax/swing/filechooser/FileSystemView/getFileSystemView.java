/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.filechooser.FileSystemView;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.filechooser.FileSystemView;

public class getFileSystemView
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FileSystemView fsv2;
        FileSystemView fsv1 = FileSystemView.getFileSystemView();
        harness.check(fsv1 == (fsv2 = FileSystemView.getFileSystemView()));
    }
}

