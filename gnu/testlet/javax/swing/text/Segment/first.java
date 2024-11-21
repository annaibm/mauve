/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class first
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Segment s = new Segment(ch, 0, 7);
        harness.check(s.first(), 65);
        harness.check(s.getIndex(), 0);
        s.last();
        harness.check(s.getIndex(), 6);
        harness.check(s.first(), 65);
        harness.check(s.getIndex(), 0);
        s = new Segment(ch, 3, 3);
        harness.check(s.first(), 68);
        harness.check(s.getIndex(), 3);
        s.last();
        harness.check(s.getIndex(), 5);
        harness.check(s.first(), 68);
        harness.check(s.getIndex(), 3);
    }
}

