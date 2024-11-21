/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.StringCharacterIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.StringCharacterIterator;

public class iter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("spot checks");
        String recherche = "recherche";
        StringCharacterIterator sci = new StringCharacterIterator(recherche);
        harness.check(sci.getIndex(), 0);
        harness.check(sci.current(), 114);
        harness.check(sci.getIndex(), 0);
        harness.check(sci.previous(), 65535);
        harness.check(sci.getIndex(), 0);
        int idx = recherche.length() - 1;
        harness.check(sci.setIndex(idx), 101);
        harness.check(sci.getIndex(), idx);
        harness.check(sci.next(), 65535);
        harness.check(sci.current(), 65535);
        harness.check(sci.getIndex(), recherche.length());
        harness.check(sci.first(), 114);
        harness.check(sci.getIndex(), 0);
        harness.checkPoint("full iteration");
        for (int i = 0; i < recherche.length() - 1; ++i) {
            harness.check(sci.next(), recherche.charAt(i + 1));
        }
        harness.check(sci.next(), 65535);
        harness.check(sci.setIndex(sci.getEndIndex()), 65535);
        sci = new StringCharacterIterator("");
        harness.check(sci.current(), 65535);
        harness.check(sci.previous(), 65535);
        harness.check(sci.next(), 65535);
    }
}

