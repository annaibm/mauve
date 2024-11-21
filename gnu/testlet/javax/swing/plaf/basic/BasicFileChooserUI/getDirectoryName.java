/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicFileChooserUI;

public class getDirectoryName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        BasicFileChooserUI ui = new BasicFileChooserUI(fc);
        harness.check(ui.getDirectoryName(), null);
        ui.installUI(fc);
        harness.check(ui.getDirectoryName(), null);
        ui.setDirectoryName("XYZ");
        harness.check(ui.getDirectoryName(), null);
        fc.setCurrentDirectory(new File("ABC"));
        harness.check(ui.getDirectoryName(), null);
    }
}

