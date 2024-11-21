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

public class getInt
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
        harness.check(UIManager.getInt("Button.textIconGap"), 4);
        UIManager.put("Button.textIconGap", new Integer(999));
        harness.check(UIManager.getInt("Button.textIconGap"), 999);
        UIManager.put("Button.textIconGap", null);
        harness.check(UIManager.getInt("Button.textIconGap"), 4);
        harness.check(UIManager.getInt("ScrollBar.darkShadow"), 0);
        harness.check(UIManager.getInt("XXXXXXXXXXXXXXXXX"), 0);
        boolean pass = false;
        try {
            UIManager.getInt(null);
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
            UIManager.getInt(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

