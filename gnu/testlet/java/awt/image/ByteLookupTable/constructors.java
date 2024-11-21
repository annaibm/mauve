/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ByteLookupTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.ByteLookupTable;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("(int, byte[])");
        byte[] bytes = new byte[]{-86, -69};
        ByteLookupTable t = new ByteLookupTable(7, bytes);
        harness.check(t.getOffset(), 7);
        harness.check(t.getNumComponents(), 1);
        byte[][] table2 = t.getTable();
        harness.check(table2.length, 1);
        harness.check(table2[0] == bytes);
        boolean pass = false;
        try {
            t = new ByteLookupTable(-1, bytes);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            t = new ByteLookupTable(0, (byte[])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(int, byte[][])");
        byte[] bytesA = new byte[]{-86, -69, -52};
        byte[] bytesB = new byte[]{-35, -18, -1};
        byte[][] bytes = new byte[][]{bytesA, bytesB};
        ByteLookupTable t = new ByteLookupTable(3, bytes);
        harness.check(t.getOffset(), 3);
        harness.check(t.getNumComponents(), 2);
        byte[][] table2 = t.getTable();
        harness.check(table2.length, 2);
        harness.check(table2[0] == bytesA);
        harness.check(table2[1] == bytesB);
        harness.check(table2 != bytes);
        boolean pass = false;
        try {
            t = new ByteLookupTable(-1, bytes);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            t = new ByteLookupTable(0, (byte[][])null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

