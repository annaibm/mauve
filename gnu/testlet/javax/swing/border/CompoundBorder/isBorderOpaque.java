/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.border.CompoundBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class isBorderOpaque
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        CompoundBorder border = new CompoundBorder();
        harness.check(border.isBorderOpaque(), true);
        border = new CompoundBorder(null, null);
        harness.check(border.isBorderOpaque(), true);
        border = new CompoundBorder(new TitledBorder(""), new TitledBorder(""));
        harness.check(border.isBorderOpaque(), false);
        border = new CompoundBorder(null, new TitledBorder(""));
        harness.check(border.isBorderOpaque(), false);
        border = new CompoundBorder(new TitledBorder(""), null);
        harness.check(border.isBorderOpaque(), false);
        border = new CompoundBorder(new LineBorder(Color.red, 33, false), null);
        harness.check(border.isBorderOpaque(), true);
        harness.check(border.getInsideBorder() == null);
        harness.check(border.getOutsideBorder().isBorderOpaque(), true);
        border = new CompoundBorder(null, new LineBorder(Color.red, 33, false));
        harness.check(border.isBorderOpaque(), true);
        harness.check(border.getInsideBorder().isBorderOpaque(), true);
        harness.check(border.getOutsideBorder() == null);
        border = new CompoundBorder(new LineBorder(Color.red, 33, false), new LineBorder(Color.red, 33, false));
        harness.check(border.isBorderOpaque(), true);
        harness.check(border.getInsideBorder().isBorderOpaque(), true);
        harness.check(border.getOutsideBorder().isBorderOpaque(), true);
        border = new CompoundBorder(new LineBorder(Color.red, 33, true), null);
        harness.check(border.isBorderOpaque(), false);
        harness.check(border.getInsideBorder() == null);
        harness.check(border.getOutsideBorder().isBorderOpaque(), false);
        border = new CompoundBorder(null, new LineBorder(Color.red, 33, true));
        harness.check(border.isBorderOpaque(), false);
        harness.check(border.getInsideBorder().isBorderOpaque(), false);
        harness.check(border.getOutsideBorder() == null);
        border = new CompoundBorder(new LineBorder(Color.red, 33, true), new LineBorder(Color.red, 33, true));
        harness.check(border.isBorderOpaque(), false);
        harness.check(border.getInsideBorder().isBorderOpaque(), false);
        harness.check(border.getOutsideBorder().isBorderOpaque(), false);
    }
}

