/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.AttributedString;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Set;

public class Test
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AttributedString as = new AttributedString("I really think that java.text is the most bogus Java package ever designed.");
        as.addAttribute(AttributedCharacterIterator.Attribute.READING, "never");
        as.addAttribute(AttributedCharacterIterator.Attribute.LANGUAGE, "bogosity", 9, 23);
        AttributedCharacterIterator aci0 = as.getIterator(null, 28, 60);
        Set<AttributedCharacterIterator.Attribute> s0 = aci0.getAllAttributeKeys();
        harness.check(s0.size(), 1, "Attribute key count");
        AttributedCharacterIterator aci = as.getIterator(null, 20, 29);
        Set<AttributedCharacterIterator.Attribute> s = aci.getAllAttributeKeys();
        harness.check(s.size(), 2);
        Object[] o = s.toArray();
        if (o.length > 0) {
            for (int i = 0; i < o.length; ++i) {
                harness.debug("Attribute Key: " + o[i].toString());
            }
        }
        aci.first();
        int rl = aci.getRunLimit();
        harness.check(rl, 23, "getRunLimit");
        aci.setIndex(rl);
        rl = aci.getRunLimit(AttributedCharacterIterator.Attribute.LANGUAGE);
        harness.check(rl, 29, "getRunLimit");
        aci.first();
        StringBuffer result = new StringBuffer("");
        do {
            result.append(aci.current() + "");
        } while (aci.next() != '\uffff');
        harness.check(result.toString(), "java.text", "iterator text");
    }
}

