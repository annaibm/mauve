/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.ACIAttribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.AttributedCharacterIterator;

public class Test
extends AttributedCharacterIterator.Attribute
implements Testlet {
    public Test() {
        super("FUCKYOU");
    }

    public Test(String name2) {
        super(name2);
    }

    @Override
    public void test(TestHarness harness) {
        Test acia = new Test("HACKER");
        harness.check(acia.getName(), "HACKER", "getName()");
        harness.check(acia.toString(), "gnu.testlet.java.text.ACIAttribute.Test(HACKER)", "toString()");
        harness.check(acia.equals(acia), "equals() true");
        harness.check(!acia.equals(new Test("HACKER")), "equals() false");
        harness.debug(AttributedCharacterIterator.Attribute.LANGUAGE.toString());
        harness.debug(AttributedCharacterIterator.Attribute.READING.toString());
        harness.debug(AttributedCharacterIterator.Attribute.INPUT_METHOD_SEGMENT.toString());
    }
}

