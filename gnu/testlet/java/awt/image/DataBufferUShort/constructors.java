/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferUShort;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferUShort;

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
        harness.checkPoint("DataBufferUShort(int)");
        DataBufferUShort b1 = new DataBufferUShort(1);
        harness.check(b1.getDataType() == 1);
        harness.check(b1.getSize() == 1);
        harness.check(b1.getNumBanks() == 1);
        harness.check(b1.getOffset() == 0);
        DataBufferUShort b2 = new DataBufferUShort(0);
        harness.check(b2.getSize() == 0);
        harness.check(b2.getNumBanks() == 1);
        harness.check(b2.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferUShort dataBufferUShort = new DataBufferUShort(-1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("DataBufferShort(short[][], int)");
        short[][] source = new short[][]{{1, 2}};
        DataBufferUShort b = new DataBufferUShort(source, 1);
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        short[][] banks = b.getBankData();
        harness.check(banks[0][0] == 1);
        source[0][0] = 3;
        harness.check(banks[0][0] == 3);
        boolean pass = false;
        try {
            DataBufferUShort dataBufferUShort = new DataBufferUShort((short[][])null, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        DataBufferUShort b1 = new DataBufferUShort(source, -1);
        harness.check(b1.getSize() == -1);
    }

    private void testConstructor3(TestHarness harness) {
        DataBufferUShort e2;
        harness.checkPoint("DataBufferUShort(short[][], int, int[])");
        short[][] source = new short[][]{{1, 2}};
        DataBufferUShort b = new DataBufferUShort(source, 1, new int[]{0});
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        source = new short[][]{{1, 2, 3}, {4, 5, 6, 7}};
        b = new DataBufferUShort(source, 2, new int[]{0, 1});
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 2);
        harness.check(b.getOffsets()[1] == 1);
        harness.check(b.getElem(1, 0) == 5);
        boolean pass = false;
        try {
            DataBufferUShort dataBufferUShort = new DataBufferUShort((short[][])null, 1, new int[]{0});
        }
        catch (NullPointerException e2) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferUShort(new short[][]{{1, 2}}, 1, null);
        }
        catch (NullPointerException e3) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferUShort(new short[][]{{1, 2}}, 1, new int[]{0, 0});
        }
        catch (ArrayIndexOutOfBoundsException e4) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("DataBufferUShort(short[], int)");
        DataBufferUShort b = new DataBufferUShort(new short[]{1, 2}, 2);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferUShort dataBufferUShort = new DataBufferUShort((short[])null, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("DataBufferUShort(short[], int, int)");
        DataBufferUShort b = new DataBufferUShort(new short[]{1, 2}, 2, 0);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferUShort dataBufferUShort = new DataBufferUShort((short[])null, 1, 0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            DataBufferUShort e = new DataBufferUShort(new short[]{1, 2}, -1, 0);
        }
        catch (NegativeArraySizeException e) {
            pass = false;
        }
        harness.check(pass);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("DataBufferUShort(int, int)");
        DataBufferUShort b = new DataBufferUShort(2, 3);
        harness.check(b.getNumBanks() == 3);
        harness.check(b.getSize() == 2);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferUShort dataBufferUShort = new DataBufferUShort(-1, 1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            DataBufferUShort e = new DataBufferUShort(1, -1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

