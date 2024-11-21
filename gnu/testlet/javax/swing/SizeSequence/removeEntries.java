/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.swing.SizeSequence;

public class removeEntries
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SizeSequence s = new SizeSequence(new int[]{1, 2, 3});
        s.removeEntries(0, 0);
        harness.check(Arrays.equals(s.getSizes(), new int[]{1, 2, 3}));
        s.removeEntries(2, 0);
        harness.check(Arrays.equals(s.getSizes(), new int[]{1, 2, 3}));
        s.removeEntries(0, 2);
        harness.check(Arrays.equals(s.getSizes(), new int[]{3}));
        s.removeEntries(0, 1);
        harness.check(Arrays.equals(s.getSizes(), new int[0]));
        s = new SizeSequence(new int[]{1, 2, 3, 4, 5});
        s.removeEntries(3, 2);
        harness.check(Arrays.equals(s.getSizes(), new int[]{1, 2, 3}));
    }
}

