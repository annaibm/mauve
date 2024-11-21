/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SizeSequence;

public class getSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SizeSequence s = new SizeSequence(new int[]{1, 2, 3});
        harness.check(s.getSize(0), 1);
        harness.check(s.getSize(1), 2);
        harness.check(s.getSize(2), 3);
        harness.check(s.getSize(-1), 0);
        harness.check(s.getSize(3), 0);
    }
}

