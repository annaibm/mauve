/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.BreakIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.BreakIterator;

public class patho
implements Testlet {
    public void check(String name2, TestHarness harness, BreakIterator bi) {
        harness.checkPoint(name2 + " pathological cases");
        harness.check(bi.getText() != null);
    }

    @Override
    public void test(TestHarness harness) {
        this.check("word", harness, BreakIterator.getWordInstance());
        this.check("character", harness, BreakIterator.getCharacterInstance());
        this.check("line", harness, BreakIterator.getLineInstance());
        this.check("word", harness, BreakIterator.getSentenceInstance());
    }
}

