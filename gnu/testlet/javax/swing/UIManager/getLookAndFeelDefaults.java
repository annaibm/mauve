/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getLookAndFeelDefaults
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
            UIDefaults d1 = UIManager.getLookAndFeelDefaults();
            UIDefaults d2 = UIManager.getLookAndFeelDefaults();
            harness.check(d1 == d2);
        }
        catch (UnsupportedLookAndFeelException e) {
            harness.fail(e.toString());
        }
    }
}

