/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.AttributedCharacterIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

public class getAttribute
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getAttribute(AttributedCharacterIterator.Attribute);");
        AttributedString as = new AttributedString("ABCDEFG");
        as.addAttribute(TextAttribute.LANGUAGE, "English");
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getAttribute(TextAttribute.LANGUAGE), (Object)"English");
        harness.check(aci.getAttribute(TextAttribute.FONT), null);
        harness.check(aci.getAttribute(null), null);
    }
}

