/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI.MyMetalFileChooserUI;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class getButtonPanel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPanel p2;
        JFileChooser fc = new JFileChooser();
        MyMetalFileChooserUI ui = new MyMetalFileChooserUI(fc);
        JPanel p1 = ui.getButtonPanel();
        harness.check(p1 == (p2 = ui.getButtonPanel()));
    }
}

