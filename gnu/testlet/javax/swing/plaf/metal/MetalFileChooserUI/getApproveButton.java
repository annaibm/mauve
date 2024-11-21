/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI.MyMetalFileChooserUI;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class getApproveButton
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        fc.setDialogType(0);
        MyMetalFileChooserUI ui = new MyMetalFileChooserUI(fc);
        ui.installUI(fc);
        JButton b1 = ui.getApproveButton(fc);
        JButton b2 = ui.getApproveButton(fc);
        harness.check(b1 == b2);
    }
}

