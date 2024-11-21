/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class previous
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Segment s = new Segment(ch, 0, 7);
        s.last();
        harness.check(s.previous(), 70);
        harness.check(s.previous(), 69);
        harness.check(s.previous(), 68);
        harness.check(s.previous(), 67);
        harness.check(s.previous(), 66);
        harness.check(s.previous(), 65);
        harness.check(s.previous(), 65535);
        harness.check(s.previous(), 65535);
        s = new Segment(ch, 3, 3);
        s.last();
        harness.check(s.previous(), 69);
        harness.check(s.previous(), 68);
        harness.check(s.previous(), 65535);
        harness.check(s.previous(), 65535);
    }
}

