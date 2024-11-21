/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.swing.SizeSequence;

public class getSizes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int[] sizes = new int[]{1, 2, 3};
        SizeSequence s = new SizeSequence(sizes);
        int[] sizes2 = s.getSizes();
        harness.check(Arrays.equals(sizes, sizes2));
        harness.check(sizes != sizes2);
        s = new SizeSequence();
        harness.check(Arrays.equals(s.getSizes(), new int[0]));
    }
}

