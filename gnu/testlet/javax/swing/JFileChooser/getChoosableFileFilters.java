/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFileChooser;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class getChoosableFileFilters
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        FileFilter[] ff2;
        JFileChooser fc = new JFileChooser();
        FileFilter[] ff1 = fc.getChoosableFileFilters();
        harness.check(ff1 != (ff2 = fc.getChoosableFileFilters()));
        harness.check(ff1[0], ff2[0]);
    }
}

