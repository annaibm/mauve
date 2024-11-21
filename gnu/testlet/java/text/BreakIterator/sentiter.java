/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.text.BreakIterator;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.text.BreakIterator;
import java.util.Locale;

public class sentiter
implements Testlet {
    public void check(String name2, String in, String[] out, BreakIterator bi, TestHarness harness) {
        int to2;
        harness.checkPoint(name2);
        bi.setText(in);
        int index = 0;
        int from = bi.current();
        harness.check(from, 0);
        while ((to2 = bi.next()) != -1) {
            harness.check(in.substring(from, to2), (Object)out[index]);
            ++index;
            from = to2;
        }
        harness.check(index, out.length);
        harness.checkPoint("backwards " + name2);
        bi.last();
        index = out.length - 1;
        from = bi.current();
        harness.check(from, in.length());
        while ((to2 = bi.previous()) != -1) {
            harness.check(in.substring(to2, from), (Object)out[index]);
            --index;
            from = to2;
        }
        harness.check(index, -1);
    }

    @Override
    public void test(TestHarness harness) {
        Locale loc = Locale.US;
        Locale.setDefault(loc);
        BreakIterator bi = BreakIterator.getSentenceInstance(loc);
        String[] r1 = new String[]{"How much time is left?  ", "We don't know."};
        this.check("How much", "How much time is left?  We don't know.", r1, bi, harness);
        String[] r2 = new String[]{"Having a sentence end with a dot.return.\n", "Should also work."};
        this.check("dot.return", "Having a sentence end with a dot.return.\nShould also work.", r2, bi, harness);
    }
}

