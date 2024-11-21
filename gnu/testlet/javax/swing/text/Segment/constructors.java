/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        Segment s = new Segment();
        harness.check(s.offset, 0);
        harness.check(s.count, 0);
        harness.check(s.array, null);
        harness.check(s.toString(), (Object)"");
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(char[], int, int)");
        char[] ch = new char[]{'A', 'B', 'C'};
        Segment s = new Segment(ch, 1, 2);
        harness.check(s.offset, 1);
        harness.check(s.count, 2);
        harness.check(s.array, ch);
        harness.check(s.toString(), (Object)"BC");
        harness.check(s.getIndex(), 0);
        harness.check(s.getBeginIndex(), 1);
        harness.check(s.getEndIndex(), 3);
        s = new Segment(ch, 4, 1);
        harness.check(s.offset, 4);
        harness.check(s.count, 1);
        harness.check(s.array, ch);
        s = new Segment(null, 0, 1);
        harness.check(s.offset, 0);
        harness.check(s.count, 1);
        harness.check(s.array, null);
        s = new Segment(ch, -4, 1);
        harness.check(s.offset, -4);
        harness.check(s.count, 1);
        harness.check(s.array, ch);
    }
}

