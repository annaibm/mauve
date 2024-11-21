/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class current
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Segment s = new Segment(ch, 0, 7);
        harness.check(s.current(), 65);
        s.last();
        harness.check(s.current(), 71);
        s.next();
        harness.check(s.current(), 65535);
        s.first();
        harness.check(s.current(), 65);
        s.previous();
        harness.check(s.current(), 65);
        s = new Segment(ch, 3, 3);
        harness.check(s.current(), 65);
        s.last();
        harness.check(s.current(), 70);
        s.next();
        harness.check(s.current(), 65535);
        s.first();
        harness.check(s.current(), 68);
        s.previous();
        harness.check(s.current(), 68);
    }
}

