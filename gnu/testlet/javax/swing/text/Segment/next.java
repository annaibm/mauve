/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class next
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Segment s = new Segment(ch, 0, 7);
        s.first();
        harness.check(s.next(), 66);
        harness.check(s.next(), 67);
        harness.check(s.next(), 68);
        harness.check(s.next(), 69);
        harness.check(s.next(), 70);
        harness.check(s.next(), 71);
        harness.check(s.next(), 65535);
        harness.check(s.next(), 65535);
        s = new Segment(ch, 3, 3);
        s.first();
        harness.check(s.next(), 69);
        harness.check(s.next(), 70);
        harness.check(s.next(), 65535);
        harness.check(s.next(), 65535);
    }
}

