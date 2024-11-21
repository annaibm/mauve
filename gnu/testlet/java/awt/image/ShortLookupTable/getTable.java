/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ShortLookupTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ShortLookupTable;

public class getTable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("test1()");
        short[] shorts = new short[]{170, 187};
        ShortLookupTable t = new ShortLookupTable(7, shorts);
        short[][] table2 = t.getTable();
        harness.check(table2.length, 1);
        harness.check(table2[0] == shorts);
        harness.check(t.getTable() == t.getTable());
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("test2()");
        short[] shortsA = new short[]{170, 187, 204};
        short[] shortsB = new short[]{221, 238, 255};
        short[][] shorts = new short[][]{shortsA, shortsB};
        ShortLookupTable t = new ShortLookupTable(3, shorts);
        short[][] table2 = t.getTable();
        harness.check(table2.length, 2);
        harness.check(table2[0] == shortsA);
        harness.check(table2[1] == shortsB);
        harness.check(table2 != shorts);
        harness.check(t.getTable() == t.getTable());
    }
}

