/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextAttribute;

public class constants
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("JUSTIFICATION");
        harness.check(TextAttribute.JUSTIFICATION_FULL, new Float(1.0));
        harness.check(TextAttribute.JUSTIFICATION_NONE, new Float(0.0));
        harness.checkPoint("POSTURE");
        harness.check(TextAttribute.POSTURE_OBLIQUE, new Float(0.2));
        harness.check(TextAttribute.POSTURE_REGULAR, new Float(0.0));
        harness.checkPoint("RUN_DIRECTION");
        harness.check(TextAttribute.RUN_DIRECTION_LTR, Boolean.FALSE);
        harness.check(TextAttribute.RUN_DIRECTION_RTL, Boolean.TRUE);
        harness.checkPoint("STRIKETHROUGH");
        harness.check(TextAttribute.STRIKETHROUGH_ON, Boolean.TRUE);
        harness.checkPoint("SUPERSCRIPT");
        harness.check(TextAttribute.SUPERSCRIPT_SUB, new Integer(-1));
        harness.check(TextAttribute.SUPERSCRIPT_SUPER, new Integer(1));
        harness.checkPoint("SWAP_COLORS");
        harness.check(TextAttribute.SWAP_COLORS_ON, Boolean.TRUE);
        harness.checkPoint("WEIGHT");
        harness.check(TextAttribute.WEIGHT_BOLD, new Float(2.0));
        harness.check(TextAttribute.WEIGHT_DEMIBOLD, new Float(1.75));
        harness.check(TextAttribute.WEIGHT_DEMILIGHT, new Float(0.875));
        harness.check(TextAttribute.WEIGHT_EXTRA_LIGHT, new Float(0.5));
        harness.check(TextAttribute.WEIGHT_EXTRABOLD, new Float(2.5));
        harness.check(TextAttribute.WEIGHT_HEAVY, new Float(2.25));
        harness.check(TextAttribute.WEIGHT_LIGHT, new Float(0.75));
        harness.check(TextAttribute.WEIGHT_MEDIUM, new Float(1.5));
        harness.check(TextAttribute.WEIGHT_REGULAR, new Float(1.0));
        harness.check(TextAttribute.WEIGHT_SEMIBOLD, new Float(1.25));
        harness.check(TextAttribute.WEIGHT_ULTRABOLD, new Float(2.75));
        harness.checkPoint("WIDTH");
        harness.check(TextAttribute.WIDTH_CONDENSED, new Float(0.75));
        harness.check(TextAttribute.WIDTH_EXTENDED, new Float(1.5));
        harness.check(TextAttribute.WIDTH_REGULAR, new Float(1.0));
        harness.check(TextAttribute.WIDTH_SEMI_CONDENSED, new Float(0.875));
        harness.check(TextAttribute.WIDTH_SEMI_EXTENDED, new Float(1.25));
    }
}

