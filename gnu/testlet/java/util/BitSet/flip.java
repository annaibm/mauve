/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.util.BitSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.BitSet;

public class flip
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("(int)");
        BitSet bs = new BitSet(17);
        bs.flip(11);
        harness.check(bs.nextSetBit(0), 11);
        boolean pass = false;
        try {
            bs.flip(-1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(int, int)");
        BitSet bs = new BitSet(21);
        bs.flip(3, 5);
        harness.check(!bs.get(2));
        harness.check(bs.get(3));
        harness.check(bs.get(4));
        harness.check(!bs.get(5));
        bs.flip(4, 4);
        harness.check(bs.get(4));
        boolean pass = false;
        try {
            bs.flip(-1, 1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            bs.flip(2, 1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

