/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SizeSequence;

public class getIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SizeSequence s = new SizeSequence(new int[]{1, 2, 3});
        harness.check(s.getIndex(0), 0);
        harness.check(s.getIndex(1), 1);
        harness.check(s.getIndex(2), 1);
        harness.check(s.getIndex(3), 2);
        harness.check(s.getIndex(4), 2);
        harness.check(s.getIndex(5), 2);
        harness.check(s.getIndex(6), 3);
        harness.check(s.getIndex(7), 3);
        harness.check(s.getIndex(99), 3);
        harness.check(s.getIndex(-1), 0);
        s = new SizeSequence();
        harness.check(s.getIndex(-1), 0);
        harness.check(s.getIndex(0), 0);
        harness.check(s.getIndex(1), 0);
    }
}

