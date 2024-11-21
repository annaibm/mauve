/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getInsets
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
        harness.check(UIManager.getInsets("Button.margin") instanceof InsetsUIResource);
        UIManager.put("Button.margin", new Insets(1, 2, 3, 4));
        harness.check(UIManager.getInsets("Button.margin"), new Insets(1, 2, 3, 4));
        UIManager.put("Button.margin", null);
        harness.check(UIManager.getInsets("Button.margin") instanceof InsetsUIResource);
        harness.check(UIManager.getInsets("Button.border"), null);
        harness.check(UIManager.getInsets("XXXXXXXXXXXXXXXXX"), null);
        boolean pass = false;
        try {
            UIManager.getInsets(null);
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
            UIManager.getInsets(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

