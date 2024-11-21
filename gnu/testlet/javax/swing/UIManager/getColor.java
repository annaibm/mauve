/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getColor
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
        harness.check(UIManager.getColor("Button.background") instanceof ColorUIResource);
        UIManager.put("Button.background", Color.red);
        harness.check(UIManager.getColor("Button.background"), Color.red);
        UIManager.put("Button.background", null);
        harness.check(UIManager.getColor("Button.background") instanceof ColorUIResource);
        harness.check(UIManager.getColor("Button.border"), null);
        harness.check(UIManager.getBorder("XXXXXXXXXXXXXXXXX"), null);
        boolean pass = false;
        try {
            UIManager.getColor(null);
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
            UIManager.getColor(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

