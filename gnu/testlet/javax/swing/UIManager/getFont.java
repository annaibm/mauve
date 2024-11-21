/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Font;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getFont
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
        harness.check(UIManager.getFont("Button.font") instanceof FontUIResource);
        UIManager.put("Button.font", new Font("Dialog", 1, 7));
        harness.check(UIManager.getFont("Button.font"), new Font("Dialog", 1, 7));
        UIManager.put("Button.font", null);
        harness.check(UIManager.getFont("Button.font") instanceof FontUIResource);
        harness.check(UIManager.getFont("Button.border"), null);
        harness.check(UIManager.getFont("XXXXXXXXXXXXXXXXX"), null);
        boolean pass = false;
        try {
            UIManager.getFont(null);
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
            UIManager.getFont(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

