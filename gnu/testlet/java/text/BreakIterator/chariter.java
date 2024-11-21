/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.BreakIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.BreakIterator;
import java.util.Locale;

public class chariter
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        String t1 = "How much time is left?  We don't know.";
        BreakIterator bi = BreakIterator.getCharacterInstance(loc);
        bi.setText(t1);
        int x = bi.current();
        harness.check(x, 0);
        int i = 0;
        while (x != -1 && i <= t1.length() + 1) {
            x = bi.next();
            harness.check(x, ++i <= t1.length() ? i : -1);
        }
    }
}

