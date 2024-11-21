/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.Segment;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.Segment;

public class setPartialReturn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        char[] ch = new char[]{'A', 'B', 'C'};
        Segment s1 = new Segment(ch, 0, 3);
        harness.check(s1.isPartialReturn(), false);
        s1.setPartialReturn(true);
        harness.check(s1.isPartialReturn(), true);
    }
}

