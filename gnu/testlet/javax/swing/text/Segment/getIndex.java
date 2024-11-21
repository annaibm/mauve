/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class getIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Segment s = new Segment(ch, 0, 7);
        harness.check(s.getIndex(), 0);
        s.next();
        harness.check(s.getIndex(), 1);
        s.last();
        harness.check(s.getIndex(), 6);
        s.next();
        harness.check(s.getIndex(), 7);
        s = new Segment(ch, 3, 3);
        harness.check(s.getIndex(), 0);
        s.first();
        harness.check(s.getIndex(), 3);
        s.next();
        harness.check(s.getIndex(), 4);
        s.last();
        harness.check(s.getIndex(), 5);
        s.next();
        harness.check(s.getIndex(), 6);
        s.first();
        harness.check(s.getIndex(), 3);
        s.previous();
        harness.check(s.getIndex(), 3);
    }
}

