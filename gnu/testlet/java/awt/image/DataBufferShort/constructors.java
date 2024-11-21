/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferShort;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferShort;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
        this.testConstructor6(harness);
    }

    private void testConstructor1(TestHarness harness) {
        harness.checkPoint("DataBufferShort(int)");
        DataBufferShort b1 = new DataBufferShort(1);
        harness.check(b1.getDataType() == 2);
        harness.check(b1.getSize() == 1);
        harness.check(b1.getNumBanks() == 1);
        harness.check(b1.getOffset() == 0);
        DataBufferShort b2 = new DataBufferShort(0);
        harness.check(b2.getSize() == 0);
        harness.check(b2.getNumBanks() == 1);
        harness.check(b2.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferShort dataBufferShort = new DataBufferShort(-1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("DataBufferShort(short[][], int)");
        short[][] source = new short[][]{{1, 2}};
        DataBufferShort b = new DataBufferShort(source, 1);
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        short[][] banks = b.getBankData();
        harness.check(banks[0][0] == 1);
        source[0][0] = 3;
        harness.check(banks[0][0] == 3);
        boolean pass = false;
        try {
            DataBufferShort dataBufferShort = new DataBufferShort((short[][])null, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        DataBufferShort b1 = new DataBufferShort(source, -1);
        harness.check(b1.getSize() == -1);
    }

    private void testConstructor3(TestHarness harness) {
        DataBufferShort e2;
        harness.checkPoint("DataBufferShort(short[][], int, int[])");
        short[][] source = new short[][]{{1, 2}};
        DataBufferShort b = new DataBufferShort(source, 1, new int[]{0});
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        source = new short[][]{{1, 2, 3}, {4, 5, 6, 7}};
        b = new DataBufferShort(source, 2, new int[]{0, 1});
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 2);
        harness.check(b.getOffsets()[1] == 1);
        harness.check(b.getElem(1, 0) == 5);
        boolean pass = false;
        try {
            DataBufferShort dataBufferShort = new DataBufferShort((short[][])null, 1, new int[]{0});
        }
        catch (NullPointerException e2) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferShort(new short[][]{{1, 2}}, 1, null);
        }
        catch (NullPointerException e3) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferShort(new short[][]{{1, 2}}, 1, new int[]{0, 0});
        }
        catch (ArrayIndexOutOfBoundsException e4) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("DataBufferShort(short[], int)");
        DataBufferShort b = new DataBufferShort(new short[]{1, 2}, 2);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferShort b1 = new DataBufferShort((short[])null, 1);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("DataBufferShort(short[], int, int)");
        DataBufferShort b = new DataBufferShort(new short[]{1, 2}, 2, 0);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferShort b1 = new DataBufferShort((short[])null, 1, 0);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            DataBufferShort e = new DataBufferShort(new short[]{1, 2}, -1, 0);
        }
        catch (NegativeArraySizeException e) {
            pass = false;
        }
        harness.check(pass);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("DataBufferShort(int, int)");
        DataBufferShort b = new DataBufferShort(2, 3);
        harness.check(b.getNumBanks() == 3);
        harness.check(b.getSize() == 2);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferShort dataBufferShort = new DataBufferShort(-1, 1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            DataBufferShort e = new DataBufferShort(1, -1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

