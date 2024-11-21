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

public class addAttributes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("addAttributes(Map, int, int)");
        AttributedString as = new AttributedString("ABCDEFG");
        HashMap<TextAttribute, Color> attributes = new HashMap<TextAttribute, Color>();
        attributes.put(TextAttribute.BACKGROUND, Color.red);
        attributes.put(TextAttribute.FOREGROUND, Color.yellow);
        as.addAttributes(attributes, 2, 4);
        AttributedCharacterIterator aci = as.getIterator();
        aci.first();
        harness.check(aci.getRunStart(TextAttribute.BACKGROUND), 0);
        harness.check(aci.getRunLimit(TextAttribute.BACKGROUND), 2);
        aci.next();
        aci.next();
        harness.check(aci.getRunStart(TextAttribute.BACKGROUND), 2);
        harness.check(aci.getRunLimit(TextAttribute.BACKGROUND), 4);
        aci.next();
        aci.next();
        harness.check(aci.getRunStart(TextAttribute.BACKGROUND), 4);
        harness.check(aci.getRunLimit(TextAttribute.BACKGROUND), 7);
        boolean pass = false;
        try {
            as.addAttributes(null, 2, 4);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            as.addAttributes(attributes, -1, 4);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            as.addAttributes(attributes, 2, 8);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            as.addAttributes(attributes, 2, 2);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

