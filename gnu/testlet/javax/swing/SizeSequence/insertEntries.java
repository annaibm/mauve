/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.swing.SizeSequence;

public class insertEntries
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SizeSequence s = new SizeSequence();
        s.insertEntries(0, 1, 1);
        harness.check(Arrays.equals(s.getSizes(), new int[]{1}));
        s.insertEntries(1, 2, 2);
        harness.check(Arrays.equals(s.getSizes(), new int[]{1, 2, 2}));
        s.insertEntries(0, 2, 3);
        harness.check(Arrays.equals(s.getSizes(), new int[]{3, 3, 1, 2, 2}));
        s.insertEntries(0, 0, 99);
        harness.check(Arrays.equals(s.getSizes(), new int[]{3, 3, 1, 2, 2}));
        s.insertEntries(4, 0, 99);
        harness.check(Arrays.equals(s.getSizes(), new int[]{3, 3, 1, 2, 2}));
    }
}

