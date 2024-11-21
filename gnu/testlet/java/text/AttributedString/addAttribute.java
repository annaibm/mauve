/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.AttributedString;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Locale;
import java.util.Map;

public class addAttribute
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    private void test1(TestHarness harness) {
        harness.checkPoint("addAttribute(AttributedCharacterIterator.Attribute, Object);");
        AttributedString as = new AttributedString("ABCDEFG");
        as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, Locale.ENGLISH);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunStart(AttributedCharacterIterator.Attribute.LANGUAGE) == 0);
        harness.check(aci.getRunLimit(AttributedCharacterIterator.Attribute.LANGUAGE) == 7);
        boolean pass = false;
        as = new AttributedString("");
        try {
            as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, "Unknown");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        as = new AttributedString("123");
        try {
            as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, null);
        }
        catch (Exception e) {
            pass = false;
        }
        harness.check(pass);
        aci = as.getIterator();
        Map<AttributedCharacterIterator.Attribute, Object> attributes = aci.getAttributes();
        harness.check(attributes.get(AttributedCharacterIterator.Attribute.LANGUAGE), null);
    }

    private void test2(TestHarness harness) {
        harness.checkPoint("addAttribute(AttributedCharacterIterator.Attribute, Object, int, int);");
        AttributedString as = new AttributedString("ABCDEFG");
        as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, "Unknown", 2, 4);
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.getRunStart(AttributedCharacterIterator.Attribute.LANGUAGE), 0);
        harness.check(aci.getRunLimit(AttributedCharacterIterator.Attribute.LANGUAGE), 2);
        aci.next();
        aci.next();
        aci.next();
        harness.check(aci.getRunStart(AttributedCharacterIterator.Attribute.LANGUAGE), 2);
        harness.check(aci.getRunLimit(AttributedCharacterIterator.Attribute.LANGUAGE), 4);
        boolean pass = false;
        try {
            as = new AttributedString("ABC");
            as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, Locale.FRANCE, -1, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            as = new AttributedString("XYZ");
            as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, Locale.FRANCE, 1, 3);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(true);
        pass = false;
        try {
            as = new AttributedString("123");
            as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, Locale.FRANCE, 1, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

