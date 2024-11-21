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
import java.util.HashSet;

public class getRunLimit
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("()");
        AttributedString as = new AttributedString("ABCDEFGHIJ");
        as.addAttribute(TextAttribute.LANGUAGE, "English");
        as.addAttribute(TextAttribute.FOREGROUND, Color.red, 2, 4);
        as.addAttribute(TextAttribute.BACKGROUND, Color.blue, 7, 8);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunLimit(), 2);
        aci.setIndex(2);
        harness.check(aci.getRunLimit(), 4);
        aci.setIndex(5);
        harness.check(aci.getRunLimit(), 7);
        aci.setIndex(7);
        harness.check(aci.getRunLimit(), 8);
        aci.setIndex(8);
        harness.check(aci.getRunLimit(), 10);
        as = new AttributedString("");
        aci = as.getIterator();
        harness.check(aci.getRunLimit(), 0);
        as = new AttributedString("ABC");
        aci = as.getIterator();
        harness.check(aci.getRunLimit(), 3);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(AttributedCharacterIterator.Attribute)");
        AttributedString as = new AttributedString("ABCDEFGHIJ");
        as.addAttribute(TextAttribute.LANGUAGE, "English");
        as.addAttribute(TextAttribute.FOREGROUND, Color.red, 2, 4);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunLimit(TextAttribute.LANGUAGE), 10);
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 2);
        harness.check(aci.getRunLimit(TextAttribute.BACKGROUND), 10);
        aci.setIndex(2);
        harness.check(aci.getRunLimit(TextAttribute.LANGUAGE), 10);
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 4);
        harness.check(aci.getRunLimit(TextAttribute.BACKGROUND), 10);
        aci.setIndex(4);
        harness.check(aci.getRunLimit(TextAttribute.LANGUAGE), 10);
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 10);
        harness.check(aci.getRunLimit(TextAttribute.BACKGROUND), 10);
        as = new AttributedString("");
        aci = as.getIterator();
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 0);
        as = new AttributedString("ABC");
        aci = as.getIterator();
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 3);
    }

    public void test3(TestHarness harness) {
        harness.checkPoint("(Set)");
        AttributedString as = new AttributedString("ABCDEFGHIJ");
        as.addAttribute(TextAttribute.LANGUAGE, "English");
        as.addAttribute(TextAttribute.FOREGROUND, Color.red, 2, 4);
        as.addAttribute(TextAttribute.BACKGROUND, Color.yellow, 3, 5);
        AttributedCharacterIterator aci = as.getIterator();
        HashSet set0 = new HashSet();
        HashSet<AttributedCharacterIterator.Attribute> set1 = new HashSet<AttributedCharacterIterator.Attribute>();
        set1.add(TextAttribute.LANGUAGE);
        HashSet<TextAttribute> set2 = new HashSet<TextAttribute>();
        set2.add(TextAttribute.FOREGROUND);
        set2.add(TextAttribute.BACKGROUND);
        HashSet<AttributedCharacterIterator.Attribute> set3 = new HashSet<AttributedCharacterIterator.Attribute>();
        set3.add(TextAttribute.LANGUAGE);
        set3.add(TextAttribute.FOREGROUND);
        set3.add(TextAttribute.BACKGROUND);
        harness.check(aci.getRunLimit(set0), 10);
        harness.check(aci.getRunLimit(set1), 10);
        harness.check(aci.getRunLimit(set2), 2);
        harness.check(aci.getRunLimit(set3), 2);
        aci.setIndex(2);
        harness.check(aci.getRunLimit(set0), 10);
        harness.check(aci.getRunLimit(set1), 10);
        harness.check(aci.getRunLimit(set2), 3);
        harness.check(aci.getRunLimit(set3), 3);
        aci.setIndex(3);
        harness.check(aci.getRunLimit(set0), 10);
        harness.check(aci.getRunLimit(set1), 10);
        harness.check(aci.getRunLimit(set2), 4);
        harness.check(aci.getRunLimit(set3), 4);
        aci.setIndex(4);
        harness.check(aci.getRunLimit(set0), 10);
        harness.check(aci.getRunLimit(set1), 10);
        harness.check(aci.getRunLimit(set2), 5);
        harness.check(aci.getRunLimit(set3), 5);
        aci.setIndex(5);
        harness.check(aci.getRunLimit(set0), 10);
        harness.check(aci.getRunLimit(set1), 10);
        harness.check(aci.getRunLimit(set2), 10);
        harness.check(aci.getRunLimit(set3), 10);
        as = new AttributedString("");
        aci = as.getIterator();
        harness.check(aci.getRunLimit(set0), 0);
        harness.check(aci.getRunLimit(set1), 0);
        harness.check(aci.getRunLimit(set2), 0);
        harness.check(aci.getRunLimit(set3), 0);
        as = new AttributedString("ABC");
        aci = as.getIterator();
        harness.check(aci.getRunLimit(set0), 3);
        harness.check(aci.getRunLimit(set1), 3);
        harness.check(aci.getRunLimit(set2), 3);
        harness.check(aci.getRunLimit(set3), 3);
    }
}

