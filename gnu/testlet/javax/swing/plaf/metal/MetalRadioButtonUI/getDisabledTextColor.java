/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalRadioButtonUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalRadioButtonUI.MyMetalRadioButtonUI;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getDisabledTextColor
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
        MyMetalRadioButtonUI ui = new MyMetalRadioButtonUI();
        harness.check(ui.getDisabledTextColor(), null);
        JRadioButton b = new JRadioButton("Test");
        ui.installDefaults(b);
        harness.check(ui.getDisabledTextColor(), new ColorUIResource(153, 153, 153));
    }
}

