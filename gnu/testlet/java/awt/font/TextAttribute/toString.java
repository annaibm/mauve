/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.font.TextAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextAttribute;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(TextAttribute.BACKGROUND.toString(), (Object)"java.awt.font.TextAttribute(background)");
        harness.check(TextAttribute.BIDI_EMBEDDING.toString(), (Object)"java.awt.font.TextAttribute(bidi_embedding)");
        harness.check(TextAttribute.CHAR_REPLACEMENT.toString(), (Object)"java.awt.font.TextAttribute(char_replacement)");
        harness.check(TextAttribute.FAMILY.toString(), (Object)"java.awt.font.TextAttribute(family)");
        harness.check(TextAttribute.FONT.toString(), (Object)"java.awt.font.TextAttribute(font)");
        harness.check(TextAttribute.FOREGROUND.toString(), (Object)"java.awt.font.TextAttribute(foreground)");
        harness.check(TextAttribute.INPUT_METHOD_HIGHLIGHT.toString(), (Object)"java.awt.font.TextAttribute(input method highlight)");
        harness.check(TextAttribute.JUSTIFICATION.toString(), (Object)"java.awt.font.TextAttribute(justification)");
        harness.check(TextAttribute.NUMERIC_SHAPING.toString(), (Object)"java.awt.font.TextAttribute(numeric_shaping)");
        harness.check(TextAttribute.POSTURE.toString(), (Object)"java.awt.font.TextAttribute(posture)");
        harness.check(TextAttribute.RUN_DIRECTION.toString(), (Object)"java.awt.font.TextAttribute(run_direction)");
        harness.check(TextAttribute.SIZE.toString(), (Object)"java.awt.font.TextAttribute(size)");
        harness.check(TextAttribute.STRIKETHROUGH.toString(), (Object)"java.awt.font.TextAttribute(strikethrough)");
        harness.check(TextAttribute.WEIGHT.toString(), (Object)"java.awt.font.TextAttribute(weight)");
        harness.check(TextAttribute.WIDTH.toString(), (Object)"java.awt.font.TextAttribute(width)");
    }
}

