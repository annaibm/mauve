/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.AttributedString;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.HashMap;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("AttributedString(AttributedCharacterIterator);");
        boolean pass = false;
        try {
            new AttributedString((AttributedCharacterIterator)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("AttributedString(AttributedCharacterIterator, int, int);");
        AttributedString source = new AttributedString("ABCDEFGHIJ");
        AttributedCharacterIterator sourceACI = source.getIterator();
        boolean pass = false;
        try {
            new AttributedString(sourceACI, -1, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new AttributedString(sourceACI, 2, 12);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new AttributedString(null, 1, 5);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("AttributedString(AttributedCharacterIterator, int, int,AttributedCharacterIterator.Attribute[]);");
        AttributedString as0 = new AttributedString("ABCDEFGHIJ");
        as0.addAttribute(TextAttribute.LANGUAGE, "English");
        as0.addAttribute(TextAttribute.FOREGROUND, Color.red, 2, 4);
        as0.addAttribute(TextAttribute.BACKGROUND, Color.yellow, 3, 5);
        AttributedString as = new AttributedString(as0.getIterator(), 1, 8, new AttributedCharacterIterator.Attribute[0]);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunLimit(TextAttribute.LANGUAGE), 7);
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 7);
        harness.check(aci.getRunLimit(TextAttribute.BACKGROUND), 7);
        as = new AttributedString(as0.getIterator(), 1, 8, new AttributedCharacterIterator.Attribute[]{TextAttribute.FOREGROUND});
        aci = as.getIterator();
        harness.check(aci.getRunLimit(TextAttribute.LANGUAGE), 7);
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 1);
        aci.setIndex(1);
        harness.check(aci.getRunLimit(TextAttribute.LANGUAGE), 7);
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 3);
        aci.setIndex(3);
        harness.check(aci.getRunLimit(TextAttribute.LANGUAGE), 7);
        harness.check(aci.getRunLimit(TextAttribute.FOREGROUND), 7);
        boolean pass = false;
        try {
            new AttributedString(null, 0, 3, new AttributedCharacterIterator.Attribute[]{TextAttribute.FONT});
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        AttributedString as1 = new AttributedString("ABC");
        pass = false;
        try {
            new AttributedString(as1.getIterator(), 3, 4, new AttributedCharacterIterator.Attribute[]{TextAttribute.FONT});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new AttributedString(as1.getIterator(), 1, 4, new AttributedCharacterIterator.Attribute[]{TextAttribute.FONT});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new AttributedString(as1.getIterator(), 1, 0, new AttributedCharacterIterator.Attribute[]{TextAttribute.FONT});
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("AttributedString(String);");
        boolean pass = false;
        try {
            new AttributedString((String)null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("AttributedString(String, map);");
        HashMap<AttributedCharacterIterator.Attribute, String> map2 = new HashMap<AttributedCharacterIterator.Attribute, String>();
        map2.put(AttributedCharacterIterator.Attribute.LANGUAGE, "English");
        AttributedString as = new AttributedString("ABC", map2);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.first() == 'A');
        harness.check(aci.getAttribute(AttributedCharacterIterator.Attribute.LANGUAGE).equals("English"));
        harness.check(aci.getRunLimit() == 3);
        harness.check(aci.getRunStart() == 0);
        boolean pass = false;
        try {
            new AttributedString(null, new HashMap());
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            new AttributedString("ABC", null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(true);
        pass = false;
        try {
            new AttributedString("", map2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
    }
}

