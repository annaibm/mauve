/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.TitledBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class getBorderInsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(Component)");
        JPanel p = new JPanel();
        TitledBorder b = new TitledBorder(new EmptyBorder(1, 2, 3, 4));
        p.setBorder(b);
        p.setFont(b.getTitleFont());
        Insets insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5, 6, 7, 8));
        FontMetrics fm = p.getFontMetrics(p.getFont());
        int fontHeight = fm.getAscent() + fm.getDescent();
        b.setTitle("XYZ");
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5 + fontHeight, 6, 7, 8));
        b.setTitleFont(new Font("Dialog", 0, 24));
        p.setFont(b.getTitleFont());
        fm = p.getFontMetrics(p.getFont());
        fontHeight = fm.getAscent() + fm.getDescent();
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5 + fontHeight, 6, 7, 8));
        b.setTitlePosition(1);
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5 + fontHeight + 2, 6, 7, 8));
        b.setTitlePosition(2);
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5 + fontHeight, 6, 7, 8));
        b.setTitlePosition(3);
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5 + fontHeight + 2, 6, 7, 8));
        b.setTitlePosition(4);
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5, 6, 7 + fontHeight + 2, 8));
        b.setTitlePosition(5);
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5, 6, 7 + fontHeight, 8));
        b.setTitlePosition(6);
        insets = b.getBorderInsets(p);
        harness.check(insets, new Insets(5, 6, 7 + fm.getHeight(), 8));
    }
}

