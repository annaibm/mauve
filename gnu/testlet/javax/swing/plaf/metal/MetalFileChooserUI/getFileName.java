/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class getFileName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        MetalFileChooserUI ui = new MetalFileChooserUI(fc);
        harness.check(ui.getFileName(), null);
        ui.installUI(fc);
        harness.check(ui.getFileName(), (Object)"");
        ui.setFileName("XYZ");
        harness.check(ui.getFileName(), (Object)"XYZ");
        fc.setCurrentDirectory(new File("ABC"));
        harness.check(ui.getFileName(), (Object)"XYZ");
    }
}

