/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class last
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Segment s = new Segment(ch, 0, 7);
        harness.check(s.last(), 71);
        harness.check(s.getIndex(), 6);
        s = new Segment(ch, 3, 3);
        harness.check(s.last(), 70);
        harness.check(s.getIndex(), 5);
    }
}

