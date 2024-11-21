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
import java.util.Locale;

public class getIterator
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.test3(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("getIterator()");
        AttributedString as = new AttributedString("ABC");
        AttributedCharacterIterator aci = as.getIterator();
        harness.check(aci.current() == 'A');
        harness.check(aci.next() == 'B');
        harness.check(aci.next() == 'C');
        harness.check(aci.next() == '\uffff');
        AttributedString as2 = new AttributedString("");
        AttributedCharacterIterator aci2 = as2.getIterator();
        harness.check(aci2.current() == '\uffff');
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("getIterator(AttributedCharacterIterator.Attribute[])");
        AttributedString as = new AttributedString("ABCDEF");
        as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, Locale.FRENCH);
        as.addAttribute(TextAttribute.BACKGROUND, Color.red, 0, 3);
        as.addAttribute(TextAttribute.FOREGROUND, Color.blue, 2, 4);
        AttributedCharacterIterator.Attribute[] attributes = new AttributedCharacterIterator.Attribute[]{TextAttribute.BACKGROUND, TextAttribute.FOREGROUND};
        AttributedCharacterIterator aci = as.getIterator(attributes);
        harness.check(aci.getAttribute(TextAttribute.BACKGROUND), Color.red);
        harness.check(aci.getAttribute(TextAttribute.FOREGROUND), null);
        harness.check(aci.next() == 'B');
        harness.check(aci.getAttribute(TextAttribute.BACKGROUND), Color.red);
        harness.check(aci.getAttribute(TextAttribute.FOREGROUND), null);
        harness.check(aci.next() == 'C');
        harness.check(aci.getAttribute(TextAttribute.BACKGROUND), Color.red);
        harness.check(aci.getAttribute(TextAttribute.FOREGROUND), Color.blue);
        harness.check(aci.next() == 'D');
        harness.check(aci.getAttribute(TextAttribute.BACKGROUND), null);
        harness.check(aci.getAttribute(TextAttribute.FOREGROUND), Color.blue);
        harness.check(aci.next() == 'E');
        harness.check(aci.getAttribute(TextAttribute.BACKGROUND), null);
        harness.check(aci.getAttribute(TextAttribute.FOREGROUND), null);
        harness.check(aci.next() == 'F');
        harness.check(aci.getAttribute(TextAttribute.BACKGROUND), null);
        harness.check(aci.getAttribute(TextAttribute.FOREGROUND), null);
        AttributedString as2 = new AttributedString("ABC");
        AttributedCharacterIterator aci2 = as2.getIterator(null);
        harness.check(aci2.current() == 'A');
        harness.check(aci2.next() == 'B');
        harness.check(aci2.next() == 'C');
        harness.check(aci2.next() == '\uffff');
        AttributedString as3 = new AttributedString("");
        AttributedCharacterIterator aci3 = as3.getIterator(null);
        harness.check(aci3.current() == '\uffff');
    }

    public void test3(TestHarness harness) {
        AttributedString as;
        harness.checkPoint("getIterator(AttributedCharacterIterator.Attribute[], int, int)");
        boolean pass = false;
        try {
            as = new AttributedString("ABC");
            as.getIterator(null, -1, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            as = new AttributedString("XYZ");
            as.getIterator(null, 2, 4);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(true);
        pass = false;
        try {
            as = new AttributedString("123");
            as.getIterator(null, 2, 1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

