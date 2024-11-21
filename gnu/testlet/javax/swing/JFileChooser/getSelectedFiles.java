/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import javax.swing.JFileChooser;

public class getSelectedFiles
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        File[] files = fc.getSelectedFiles();
        harness.check(files.length, 0);
        File f1 = new File("X");
        files = new File[]{f1};
        fc.setSelectedFiles(files);
        File[] ff = fc.getSelectedFiles();
        harness.check(ff[0], f1);
        fc.setSelectedFiles(null);
        ff = fc.getSelectedFiles();
        harness.check(ff.length, 0);
        fc.setSelectedFiles(new File[0]);
        ff = fc.getSelectedFiles();
        harness.check(ff.length, 0);
    }
}

