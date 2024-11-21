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

public class getBoolean
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
        harness.check(UIManager.getBoolean("ScrollBar.allowsAbsolutePositioning"), true);
        UIManager.put("ScrollBar.allowsAbsolutePositioning", Boolean.FALSE);
        harness.check(UIManager.getBoolean("ScrollBar.allowsAbsolutePositioning"), false);
        UIManager.put("ScrollBar.allowsAbsolutePositioning", null);
        harness.check(UIManager.getBoolean("ScrollBar.allowsAbsolutePositioning"), true);
        harness.check(UIManager.getBoolean("ScrollBar.darkShadow"), false);
        harness.check(UIManager.getBoolean("XXXXXXXXXXXXXXXXX"), false);
        boolean pass = false;
        try {
            UIManager.getBoolean(null);
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
            UIManager.getBoolean(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

