/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferDouble;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferDouble;

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
        harness.checkPoint("DataBufferDouble(int)");
        DataBufferDouble b1 = new DataBufferDouble(1);
        harness.check(b1.getDataType() == 5);
        harness.check(b1.getSize() == 1);
        harness.check(b1.getNumBanks() == 1);
        harness.check(b1.getOffset() == 0);
        DataBufferDouble b2 = new DataBufferDouble(0);
        harness.check(b2.getSize() == 0);
        harness.check(b2.getNumBanks() == 1);
        harness.check(b2.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferDouble dataBufferDouble = new DataBufferDouble(-1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("DataBufferDouble(double[][], int)");
        double[][] source = new double[][]{{1.0, 2.0}};
        DataBufferDouble b = new DataBufferDouble(source, 1);
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        double[][] banks = b.getBankData();
        harness.check(banks[0][0] == 1.0);
        source[0][0] = 3.0;
        harness.check(banks[0][0] == 3.0);
        boolean pass = false;
        try {
            DataBufferDouble dataBufferDouble = new DataBufferDouble((double[][])null, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        DataBufferDouble b1 = new DataBufferDouble(source, -1);
        harness.check(b1.getSize() == -1);
    }

    private void testConstructor3(TestHarness harness) {
        DataBufferDouble e2;
        harness.checkPoint("DataBufferDouble(double[][], int, int[])");
        double[][] source = new double[][]{{1.0, 2.0}};
        DataBufferDouble b = new DataBufferDouble(source, 1, new int[]{0});
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        source = new double[][]{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0, 7.0}};
        b = new DataBufferDouble(source, 2, new int[]{0, 1});
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 2);
        harness.check(b.getOffsets()[1] == 1);
        harness.check(b.getElem(1, 0) == 5);
        boolean pass = false;
        try {
            DataBufferDouble dataBufferDouble = new DataBufferDouble((double[][])null, 1, new int[]{0});
        }
        catch (NullPointerException e2) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferDouble(new double[][]{{1.0, 2.0}}, 1, null);
        }
        catch (NullPointerException e3) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferDouble(new double[][]{{1.0, 2.0}}, 1, new int[]{0, 0});
        }
        catch (ArrayIndexOutOfBoundsException e4) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("DataBufferDouble(double[], int)");
        DataBufferDouble b = new DataBufferDouble(new double[]{1.0, 2.0}, 2);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferDouble b1 = new DataBufferDouble((double[])null, 1);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("DataBufferDouble(double[], int, int)");
        DataBufferDouble b = new DataBufferDouble(new double[]{1.0, 2.0}, 2, 0);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferDouble b1 = new DataBufferDouble((double[])null, 1, 0);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            DataBufferDouble e = new DataBufferDouble(new double[]{1.0, 2.0}, -1, 0);
        }
        catch (NegativeArraySizeException e) {
            pass = false;
        }
        harness.check(pass);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("DataBufferDouble(int, int)");
        DataBufferDouble b = new DataBufferDouble(2, 3);
        harness.check(b.getNumBanks() == 3);
        harness.check(b.getSize() == 2);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferDouble dataBufferDouble = new DataBufferDouble(-1, 1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            DataBufferDouble e = new DataBufferDouble(1, -1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

