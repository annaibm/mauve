/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.CharacterIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.CharacterIterator;

public class implement
implements CharacterIterator,
Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(true, "Correctly implemented CharacterIterator");
    }

    @Override
    public Object clone() {
        return null;
    }

    @Override
    public char current() {
        return '0';
    }

    @Override
    public char first() {
        return '0';
    }

    @Override
    public int getBeginIndex() {
        return 0;
    }

    @Override
    public int getEndIndex() {
        return 0;
    }

    @Override
    public int getIndex() {
        return 0;
    }

    @Override
    public char last() {
        return '0';
    }

    @Override
    public char next() {
        return '0';
    }

    @Override
    public char previous() {
        return '0';
    }

    @Override
    public char setIndex(int pos) {
        return '0';
    }
}

