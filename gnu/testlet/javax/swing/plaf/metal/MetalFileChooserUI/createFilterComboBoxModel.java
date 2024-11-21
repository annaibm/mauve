/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JFileChooser.MyFileChooser;
import gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI.MyMetalFileChooserUI;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class createFilterComboBoxModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyFileChooser fc = new MyFileChooser();
        MyMetalFileChooserUI ui = new MyMetalFileChooserUI(fc);
        fc.setUI(ui);
        MetalFileChooserUI.FilterComboBoxModel m = ui.createFilterComboBoxModel();
        harness.check(m.getSize(), 1);
        harness.check(m.getElementAt(0), fc.getFileFilter());
        MetalFileChooserUI.FilterComboBoxModel m2 = ui.createFilterComboBoxModel();
        harness.check(m != m2);
    }
}

