/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferByte;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferByte;

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
        harness.checkPoint("DataBufferByte(int)");
        DataBufferByte b1 = new DataBufferByte(1);
        harness.check(b1.getDataType() == 0);
        harness.check(b1.getSize() == 1);
        harness.check(b1.getNumBanks() == 1);
        harness.check(b1.getOffset() == 0);
        DataBufferByte b2 = new DataBufferByte(0);
        harness.check(b2.getSize() == 0);
        harness.check(b2.getNumBanks() == 1);
        harness.check(b2.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferByte dataBufferByte = new DataBufferByte(-1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("DataBufferByte(byte[][], int)");
        byte[][] source = new byte[][]{{1, 2}};
        DataBufferByte b = new DataBufferByte(source, 1);
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        byte[][] banks = b.getBankData();
        harness.check(banks[0][0] == 1);
        source[0][0] = 3;
        harness.check(banks[0][0] == 3);
        boolean pass = false;
        try {
            DataBufferByte dataBufferByte = new DataBufferByte((byte[][])null, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        DataBufferByte b1 = new DataBufferByte(source, -1);
        harness.check(b1.getSize() == -1);
    }

    private void testConstructor3(TestHarness harness) {
        DataBufferByte e2;
        harness.checkPoint("DataBufferByte(byte[][], int, int[])");
        byte[][] source = new byte[][]{{1, 2}};
        DataBufferByte b = new DataBufferByte(source, 1, new int[]{0});
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        source = new byte[][]{{1, 2, 3}, {4, 5, 6, 7}};
        b = new DataBufferByte(source, 2, new int[]{0, 1});
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 2);
        harness.check(b.getOffsets()[1] == 1);
        harness.check(b.getElem(1, 0) == 5);
        boolean pass = false;
        try {
            DataBufferByte dataBufferByte = new DataBufferByte((byte[][])null, 1, new int[]{0});
        }
        catch (NullPointerException e2) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferByte(new byte[][]{{1, 2}}, 1, null);
        }
        catch (NullPointerException e3) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferByte(new byte[][]{{1, 2}}, 1, new int[]{0, 0});
        }
        catch (ArrayIndexOutOfBoundsException e4) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("DataBufferByte(byte[], int)");
        DataBufferByte b = new DataBufferByte(new byte[]{1, 2}, 2);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferByte b1 = new DataBufferByte((byte[])null, 1);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("DataBufferByte(byte[], int, int)");
        DataBufferByte b = new DataBufferByte(new byte[]{1, 2}, 2, 0);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferByte b1 = new DataBufferByte((byte[])null, 1, 0);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            DataBufferByte e = new DataBufferByte(new byte[]{1, 2}, -1, 0);
        }
        catch (NegativeArraySizeException e) {
            pass = false;
        }
        harness.check(pass);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("DataBufferByte(int, int)");
        DataBufferByte b = new DataBufferByte(2, 3);
        harness.check(b.getNumBanks() == 3);
        harness.check(b.getSize() == 2);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferByte dataBufferByte = new DataBufferByte(-1, 1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            DataBufferByte e = new DataBufferByte(1, -1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

