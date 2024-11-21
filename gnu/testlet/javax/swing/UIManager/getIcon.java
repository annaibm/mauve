/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIManager;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getIcon
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
        harness.check(UIManager.getIcon("FileChooser.detailsViewIcon") instanceof Icon);
        Icon icon = MetalIconFactory.getHorizontalSliderThumbIcon();
        UIManager.put("FileChooser.detailsViewIcon", icon);
        harness.check(UIManager.getIcon("FileChooser.detailsViewIcon"), icon);
        UIManager.put("FileChooser.detailsViewIcon", null);
        harness.check(UIManager.getIcon("FileChooser.detailsViewIcon") instanceof Icon);
        harness.check(UIManager.getIcon("FileChooser.detailsViewIcon") != icon);
        harness.check(UIManager.getIcon("Button.border"), null);
        harness.check(UIManager.getIcon("XXXXXXXXXXXXXXXXX"), null);
        boolean pass = false;
        try {
            UIManager.getIcon(null);
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
            UIManager.getIcon(null, Locale.getDefault());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

