/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ShortLookupTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ShortLookupTable;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(int, byte[])");
        short[] shorts = new short[]{170, 187};
        ShortLookupTable t = new ShortLookupTable(7, shorts);
        harness.check(t.getOffset(), 7);
        harness.check(t.getNumComponents(), 1);
        short[][] table2 = t.getTable();
        harness.check(table2.length, 1);
        harness.check(table2[0] == shorts);
        boolean pass = false;
        try {
            t = new ShortLookupTable(-1, shorts);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            t = new ShortLookupTable(0, (short[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, byte[][])");
        short[] shortsA = new short[]{170, 187, 204};
        short[] shortsB = new short[]{221, 238, 255};
        short[][] shorts = new short[][]{shortsA, shortsB};
        ShortLookupTable t = new ShortLookupTable(3, shorts);
        harness.check(t.getOffset(), 3);
        harness.check(t.getNumComponents(), 2);
        short[][] table2 = t.getTable();
        harness.check(table2.length, 2);
        harness.check(table2[0] == shortsA);
        harness.check(table2[1] == shortsB);
        harness.check(table2 != shorts);
        boolean pass = false;
        try {
            t = new ShortLookupTable(-1, shorts);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            t = new ShortLookupTable(0, (short[][])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

