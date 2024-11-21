/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextAttribute;

public class constants13
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(TextAttribute.UNDERLINE_LOW_DASHED, new Integer(5));
        harness.check(TextAttribute.UNDERLINE_LOW_DOTTED, new Integer(3));
        harness.check(TextAttribute.UNDERLINE_LOW_GRAY, new Integer(4));
        harness.check(TextAttribute.UNDERLINE_LOW_ONE_PIXEL, new Integer(1));
        harness.check(TextAttribute.UNDERLINE_LOW_TWO_PIXEL, new Integer(2));
    }
}

