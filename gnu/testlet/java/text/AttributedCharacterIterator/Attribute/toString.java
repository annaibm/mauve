/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.AttributedCharacterIterator.Attribute;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.AttributedCharacterIterator;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(AttributedCharacterIterator.Attribute.INPUT_METHOD_SEGMENT.toString(), (Object)"java.text.AttributedCharacterIterator$Attribute(input_method_segment)");
        harness.check(AttributedCharacterIterator.Attribute.LANGUAGE.toString(), (Object)"java.text.AttributedCharacterIterator$Attribute(language)");
        harness.check(AttributedCharacterIterator.Attribute.READING.toString(), (Object)"java.text.AttributedCharacterIterator$Attribute(reading)");
    }
}

