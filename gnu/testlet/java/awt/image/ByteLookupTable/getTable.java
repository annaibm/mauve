/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ByteLookupTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ByteLookupTable;

public class getTable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("test1()");
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(7, bytes);
        byte[][] table2 = t.getTable();
        harness.check(table2.length, 1);
        harness.check(table2[0] == bytes);
        harness.check(t.getTable() == t.getTable());
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("test2()");
        byte[] bytesA = new byte[]{-86, -69, -52};
        byte[] bytesB = new byte[]{-35, -18, -1};
        byte[][] bytes = new byte[][]{bytesA, bytesB};
        ByteLookupTable t = new ByteLookupTable(3, bytes);
        byte[][] table2 = t.getTable();
        harness.check(table2.length, 2);
        harness.check(table2[0] == bytesA);
        harness.check(table2[1] == bytesB);
        harness.check(table2 != bytes);
        harness.check(t.getTable() == t.getTable());
    }
}

