/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SizeSequence;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Arrays;
import javax.swing.SizeSequence;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        SizeSequence s = new SizeSequence();
        harness.check(Arrays.equals(s.getSizes(), new int[0]));
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int)");
        SizeSequence s = new SizeSequence(3);
        harness.check(Arrays.equals(s.getSizes(), new int[3]));
        boolean pass = false;
        try {
            s = new SizeSequence(-1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor3(TestHarness harness) {
        harness.checkPoint("(int, int)");
        SizeSequence s = new SizeSequence(3, 5);
        harness.check(Arrays.equals(s.getSizes(), new int[]{5, 5, 5}));
        boolean pass = false;
        try {
            s = new SizeSequence(-1, 5);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("(int[])");
        int[] sizes = new int[]{1, 2, 3};
        SizeSequence s = new SizeSequence(sizes);
        harness.check(Arrays.equals(s.getSizes(), new int[]{1, 2, 3}));
        sizes[0] = 99;
        harness.check(Arrays.equals(s.getSizes(), new int[]{1, 2, 3}));
        boolean pass = false;
        try {
            s = new SizeSequence(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

