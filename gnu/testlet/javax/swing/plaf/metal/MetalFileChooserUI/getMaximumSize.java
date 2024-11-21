/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.JFileChooser;
import javax.swing.plaf.metal.MetalFileChooserUI;

public class getMaximumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JFileChooser fc = new JFileChooser();
        MetalFileChooserUI ui = new MetalFileChooserUI(fc);
        Dimension expected = new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Dimension d1 = ui.getMaximumSize(fc);
        harness.check(d1, expected);
        Dimension d2 = ui.getMaximumSize(fc);
        harness.check(d1 != d2);
        Dimension d3 = ui.getMaximumSize(null);
        harness.check(d3, expected);
    }
}

