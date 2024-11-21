/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.AttributedCharacterIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Set;

public class getRunStart
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("getRunStart();");
        AttributedString as = new AttributedString("ABCDEFG");
        as.addAttribute(TextAttribute.LANGUAGE, "English");
        as.addAttribute(TextAttribute.FOREGROUND, Color.red, 2, 4);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunStart(), 0);
        aci.setIndex(3);
        harness.check(aci.getRunStart(), 2);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("getRunStart(AttributedCharacterIterator.Attribute);");
        AttributedString as = new AttributedString("ABCDEFG");
        as.addAttribute(TextAttribute.LANGUAGE, "English");
        as.addAttribute(TextAttribute.FOREGROUND, Color.red, 2, 4);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunStart(TextAttribute.LANGUAGE), 0);
        aci.setIndex(3);
        harness.check(aci.getRunStart(TextAttribute.FOREGROUND), 2);
    }

    private void test3(TestHarness harness) {
        harness.checkPoint("getRunStart(Set);");
        AttributedString as = new AttributedString("ABCDEFG");
        as.addAttribute(TextAttribute.LANGUAGE, "English");
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunStart((Set<? extends AttributedCharacterIterator.Attribute>)null), 0);
        AttributedCharacterIterator aci2 = as.getIterator(null, 4, 7);
        harness.check(aci2.getRunStart((Set<? extends AttributedCharacterIterator.Attribute>)null), 4);
    }
}

