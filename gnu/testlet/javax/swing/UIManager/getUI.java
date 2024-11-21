/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.UIManager.MyLookAndFeel;
import gnu.testlet.javax.swing.UIManager.TestLabelUI;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getUI
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MyLookAndFeel());
        }
        catch (Exception ex) {
            harness.fail(ex.getMessage());
        }
        TestLabel l = new TestLabel();
        UIManager.getUI(l);
        harness.check(TestLabelUI.installUICalled, false);
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    class TestLabel
    extends JLabel {
        TestLabel() {
        }

        @Override
        public void setUI(LabelUI ui) {
        }
    }
}

