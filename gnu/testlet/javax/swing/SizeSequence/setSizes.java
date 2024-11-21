/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.swing.SizeSequence;

public class setSizes
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SizeSequence s = new SizeSequence();
        int[] sizes = new int[]{1, 2, 3};
        s.setSizes(sizes);
        harness.check(Arrays.equals(s.getSizes(), sizes));
        sizes[0] = 99;
        harness.check(Arrays.equals(s.getSizes(), new int[]{1, 2, 3}));
        boolean pass = false;
        try {
            s.setSizes(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

