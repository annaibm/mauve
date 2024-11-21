/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalFileChooserUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalFileChooserUI;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getMinimumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFileChooser fc = new JFileChooser();
        MetalFileChooserUI ui = new MetalFileChooserUI(fc);
        Dimension d1 = ui.getPreferredSize(fc);
        Dimension d2 = ui.getPreferredSize(fc);
        harness.check(d1 != d2);
        boolean pass = false;
        try {
            ui.getPreferredSize(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

