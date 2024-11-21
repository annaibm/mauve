/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C'};
        Segment s1 = new Segment(ch, 0, 3);
        harness.check(s1.toString(), (Object)"ABC");
        Segment s2 = new Segment(ch, 1, 1);
        harness.check(s2.toString(), (Object)"B");
        Segment s3 = new Segment(ch, 2, 0);
        harness.check(s3.toString(), (Object)"");
        Segment s4 = new Segment(null, 0, 0);
        harness.check(s4.toString(), (Object)"");
    }
}

