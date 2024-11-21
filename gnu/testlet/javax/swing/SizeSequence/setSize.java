/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SizeSequence;

public class setSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SizeSequence s = new SizeSequence(new int[]{1, 2, 3});
        s.setSize(0, 3);
        harness.check(s.getSize(0), 3);
        s.setSize(-1, 3);
        s.setSize(3, 3);
    }
}

