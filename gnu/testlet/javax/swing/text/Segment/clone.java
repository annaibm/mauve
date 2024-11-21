/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C'};
        Segment s1 = new Segment(ch, 0, 3);
        Segment s2 = (Segment)s1.clone();
        harness.check(!s1.equals(s2));
        harness.check(s2.offset, 0);
        harness.check(s2.count, 3);
        harness.check(s2.array, ch);
        s1.offset = 1;
        harness.check(s2.offset, 0);
        s2.offset = 1;
        harness.check(s2.offset, 1);
        s1.count = 2;
        harness.check(s2.count, 3);
        s2.count = 2;
        harness.check(s2.count, 2);
        s1.array[1] = 88;
        harness.check(s2.array[1], 88);
        char[] ch2 = new char[]{'X', 'Y', 'Z'};
        s1.array = ch2;
        harness.check(s2.array, ch);
    }
}

