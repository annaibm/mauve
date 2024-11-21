/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.AttributedCharacterIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.text.AttributedCharacterIterator.CharItImpl;
import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Set;

public class implement
extends CharItImpl
implements AttributedCharacterIterator,
Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(true, "Correctly implemented AttributedCharacterIterator");
    }

    @Override
    public int getRunStart() {
        return 0;
    }

    @Override
    public int getRunStart(AttributedCharacterIterator.Attribute attr) {
        return 0;
    }

    public int getRunStart(Set attrs) {
        return 0;
    }

    @Override
    public int getRunLimit() {
        return 0;
    }

    @Override
    public int getRunLimit(AttributedCharacterIterator.Attribute attr) {
        return 0;
    }

    public int getRunLimit(Set attrs) {
        return 0;
    }

    public Map getAttributes() {
        return null;
    }

    public Set getAllAttributeKeys() {
        return null;
    }

    @Override
    public Object getAttribute(AttributedCharacterIterator.Attribute attr) {
        return null;
    }
}

