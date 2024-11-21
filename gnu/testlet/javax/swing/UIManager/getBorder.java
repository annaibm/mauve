/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getBorder
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
        harness.check(UIManager.getBorder("Button.border") instanceof Border);
        UIManager.put("Button.border", new EmptyBorder(1, 1, 1, 1));
        harness.check(UIManager.getBorder("Button.border") instanceof EmptyBorder);
        UIManager.put("Button.border", null);
        harness.check(UIManager.getBorder("Button.border") instanceof Border);
        harness.check(UIManager.getBorder("ScrollBar.darkShadow"), null);
        harness.check(UIManager.getBorder("XXXXXXXXXXXXXXXXX"), null);
        boolean pass = false;
        try {
            UIManager.getBorder(null);
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
            UIManager.getBorder(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

