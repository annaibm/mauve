/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(Object)");
        harness.check(UIManager.getString("OptionPane.errorSound"), (Object)"sounds/OptionPaneError.wav");
        UIManager.put("OptionPane.errorSound", "ABC");
        harness.check(UIManager.getString("OptionPane.errorSound"), (Object)"ABC");
        UIManager.put("OptionPane.errorSound", null);
        harness.check(UIManager.getString("OptionPane.errorSound"), (Object)"sounds/OptionPaneError.wav");
        harness.check(UIManager.getString("ScrollBar.darkShadow"), null);
        harness.check(UIManager.getString("XXXXXXXXXXXXXXXXX"), null);
        boolean pass = false;
        try {
            UIManager.getString(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(Object, Locale)");
        boolean pass = false;
        try {
            UIManager.getString(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

