/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.util.Locale;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getDimension
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
        harness.check(UIManager.getDimension("ScrollBar.minimumThumbSize"), new Dimension(8, 8));
        UIManager.put("ScrollBar.minimumThumbSize", new Dimension(1, 2));
        harness.check(UIManager.getDimension("ScrollBar.minimumThumbSize"), new Dimension(1, 2));
        UIManager.put("ScrollBar.minimumThumbSize", null);
        harness.check(UIManager.getDimension("ScrollBar.minimumThumbSize"), new Dimension(8, 8));
        harness.check(UIManager.getDimension("Button.border"), null);
        harness.check(UIManager.getDimension("XXXXXXXXXXXXXXXXX"), null);
        boolean pass = false;
        try {
            UIManager.getDimension(null);
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
            UIManager.getDimension(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

