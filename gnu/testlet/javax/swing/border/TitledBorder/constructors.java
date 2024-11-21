/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
        this.test4(harness);
        this.test5(harness);
        this.test6(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(Border)");
        EmptyBorder b = new EmptyBorder(1, 2, 3, 4);
        TitledBorder tb = new TitledBorder(b);
        harness.check(tb.getBorder(), b);
        harness.check(tb.getTitle(), (Object)"");
        Color c = UIManager.getLookAndFeelDefaults().getColor("TitledBorder.titleColor");
        harness.check(tb.getTitleColor(), c);
        Font f = UIManager.getLookAndFeelDefaults().getFont("TitledBorder.font");
        harness.check(tb.getTitleFont(), f);
        harness.check(tb.getTitlePosition(), 0);
        harness.check(tb.getTitleJustification(), 4);
        tb = new TitledBorder((Border)null);
        Border bb = UIManager.getLookAndFeelDefaults().getBorder("TitledBorder.border");
        harness.check(tb.getBorder(), bb);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(Border, String)");
        EmptyBorder b = new EmptyBorder(1, 2, 3, 4);
        TitledBorder tb = new TitledBorder(b, "XYZ");
        harness.check(tb.getBorder(), b);
        harness.check(tb.getTitle(), (Object)"XYZ");
        Color c = UIManager.getLookAndFeelDefaults().getColor("TitledBorder.titleColor");
        harness.check(tb.getTitleColor(), c);
        Font f = UIManager.getLookAndFeelDefaults().getFont("TitledBorder.font");
        harness.check(tb.getTitleFont(), f);
        harness.check(tb.getTitlePosition(), 0);
        harness.check(tb.getTitleJustification(), 4);
        tb = new TitledBorder(null, "XYZ");
        Border bb = UIManager.getLookAndFeelDefaults().getBorder("TitledBorder.border");
        harness.check(tb.getBorder(), bb);
        tb = new TitledBorder(new EmptyBorder(1, 2, 3, 4), null);
        harness.check(tb.getTitle(), null);
    }

    public void test3(TestHarness harness) {
        harness.checkPoint("(Border, String, int, int)");
        EmptyBorder b = new EmptyBorder(1, 2, 3, 4);
        TitledBorder tb = new TitledBorder(b, "XYZ", 1, 6);
        harness.check(tb.getBorder(), b);
        harness.check(tb.getTitle(), (Object)"XYZ");
        Color c = UIManager.getLookAndFeelDefaults().getColor("TitledBorder.titleColor");
        harness.check(tb.getTitleColor(), c);
        Font f = UIManager.getLookAndFeelDefaults().getFont("TitledBorder.font");
        harness.check(tb.getTitleFont(), f);
        harness.check(tb.getTitlePosition(), 6);
        harness.check(tb.getTitleJustification(), 1);
        tb = new TitledBorder(null, "XYZ", 1, 6);
        Border bb = UIManager.getLookAndFeelDefaults().getBorder("TitledBorder.border");
        harness.check(tb.getBorder(), bb);
        tb = new TitledBorder(new EmptyBorder(1, 2, 3, 4), null, 1, 6);
        harness.check(tb.getTitle(), null);
    }

    public void test4(TestHarness harness) {
        harness.checkPoint("(Border, String, int, int, Font)");
        EmptyBorder b = new EmptyBorder(1, 2, 3, 4);
        Font f = new Font("Dialog", 1, 16);
        TitledBorder tb = new TitledBorder(b, "XYZ", 1, 6, f);
        harness.check(tb.getBorder(), b);
        harness.check(tb.getTitle(), (Object)"XYZ");
        Color c = UIManager.getLookAndFeelDefaults().getColor("TitledBorder.titleColor");
        harness.check(tb.getTitleColor(), c);
        harness.check(tb.getTitleFont(), f);
        harness.check(tb.getTitlePosition(), 6);
        harness.check(tb.getTitleJustification(), 1);
        tb = new TitledBorder(null, "XYZ", 1, 6, f);
        Border bb = UIManager.getLookAndFeelDefaults().getBorder("TitledBorder.border");
        harness.check(tb.getBorder(), bb);
        tb = new TitledBorder(new EmptyBorder(1, 2, 3, 4), null, 1, 6, f);
        harness.check(tb.getTitle(), null);
    }

    public void test5(TestHarness harness) {
        harness.checkPoint("(Border, String, int, int, Font, Color)");
        EmptyBorder b = new EmptyBorder(1, 2, 3, 4);
        Font f = new Font("Dialog", 1, 16);
        TitledBorder tb = new TitledBorder(b, "XYZ", 1, 6, f, Color.red);
        harness.check(tb.getBorder(), b);
        harness.check(tb.getTitle(), (Object)"XYZ");
        harness.check(tb.getTitleColor(), Color.red);
        harness.check(tb.getTitleFont(), f);
        harness.check(tb.getTitlePosition(), 6);
        harness.check(tb.getTitleJustification(), 1);
        tb = new TitledBorder(null, "XYZ", 1, 6, f, Color.red);
        Border bb = UIManager.getLookAndFeelDefaults().getBorder("TitledBorder.border");
        harness.check(tb.getBorder(), bb);
        tb = new TitledBorder(new EmptyBorder(1, 2, 3, 4), null, 1, 6, f, Color.red);
        harness.check(tb.getTitle(), null);
    }

    public void test6(TestHarness harness) {
        harness.checkPoint("(String)");
        TitledBorder tb = new TitledBorder("XYZ");
        harness.check(tb.getTitle(), (Object)"XYZ");
        Border b = UIManager.getLookAndFeelDefaults().getBorder("TitledBorder.border");
        harness.check(tb.getBorder(), b);
        Color c = UIManager.getLookAndFeelDefaults().getColor("TitledBorder.titleColor");
        harness.check(tb.getTitleColor(), c);
        Font f = UIManager.getLookAndFeelDefaults().getFont("TitledBorder.font");
        harness.check(tb.getTitleFont(), f);
        harness.check(tb.getTitlePosition(), 0);
        harness.check(tb.getTitleJustification(), 4);
        tb = new TitledBorder((String)null);
        harness.check(tb.getTitle(), null);
    }
}

