/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.DataBufferFloat;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferFloat;

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
        harness.checkPoint("DataBufferFloat(int)");
        DataBufferFloat b1 = new DataBufferFloat(1);
        harness.check(b1.getDataType() == 4);
        harness.check(b1.getSize() == 1);
        harness.check(b1.getNumBanks() == 1);
        harness.check(b1.getOffset() == 0);
        DataBufferFloat b2 = new DataBufferFloat(0);
        harness.check(b2.getSize() == 0);
        harness.check(b2.getNumBanks() == 1);
        harness.check(b2.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferFloat dataBufferFloat = new DataBufferFloat(-1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor2(TestHarness harness) {
        harness.checkPoint("DataBufferFloat(float[][], int)");
        float[][] source = new float[][]{{1.0f, 2.0f}};
        DataBufferFloat b = new DataBufferFloat(source, 1);
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        float[][] banks = b.getBankData();
        harness.check(banks[0][0] == 1.0f);
        source[0][0] = 3.0f;
        harness.check(banks[0][0] == 3.0f);
        boolean pass = false;
        try {
            DataBufferFloat dataBufferFloat = new DataBufferFloat((float[][])null, 1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        DataBufferFloat b1 = new DataBufferFloat(source, -1);
        harness.check(b1.getSize() == -1);
    }

    private void testConstructor3(TestHarness harness) {
        DataBufferFloat e2;
        harness.checkPoint("DataBufferFloat(float[][], int, int[])");
        float[][] source = new float[][]{{1.0f, 2.0f}};
        DataBufferFloat b = new DataBufferFloat(source, 1, new int[]{0});
        harness.check(b.getSize() == 1);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        source = new float[][]{{1.0f, 2.0f, 3.0f}, {4.0f, 5.0f, 6.0f, 7.0f}};
        b = new DataBufferFloat(source, 2, new int[]{0, 1});
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 2);
        harness.check(b.getOffsets()[1] == 1);
        harness.check(b.getElem(1, 0) == 5);
        boolean pass = false;
        try {
            DataBufferFloat dataBufferFloat = new DataBufferFloat((float[][])null, 1, new int[]{0});
        }
        catch (NullPointerException e2) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferFloat(new float[][]{{1.0f, 2.0f}}, 1, null);
        }
        catch (NullPointerException e3) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            e2 = new DataBufferFloat(new float[][]{{1.0f, 2.0f}}, 1, new int[]{0, 0});
        }
        catch (ArrayIndexOutOfBoundsException e4) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor4(TestHarness harness) {
        harness.checkPoint("DataBufferFloat(float[], int)");
        DataBufferFloat b = new DataBufferFloat(new float[]{1.0f, 2.0f}, 2);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferFloat b1 = new DataBufferFloat((float[])null, 1);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    private void testConstructor5(TestHarness harness) {
        harness.checkPoint("DataBufferFloat(float[], int, int)");
        DataBufferFloat b = new DataBufferFloat(new float[]{1.0f, 2.0f}, 2, 0);
        harness.check(b.getSize() == 2);
        harness.check(b.getNumBanks() == 1);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferFloat b1 = new DataBufferFloat((float[])null, 1, 0);
            int n = b1.getElem(0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = true;
        try {
            DataBufferFloat e = new DataBufferFloat(new float[]{1.0f, 2.0f}, -1, 0);
        }
        catch (NegativeArraySizeException e) {
            pass = false;
        }
        harness.check(pass);
    }

    private void testConstructor6(TestHarness harness) {
        harness.checkPoint("DataBufferFloat(int, int)");
        DataBufferFloat b = new DataBufferFloat(2, 3);
        harness.check(b.getNumBanks() == 3);
        harness.check(b.getSize() == 2);
        harness.check(b.getOffset() == 0);
        boolean pass = false;
        try {
            DataBufferFloat dataBufferFloat = new DataBufferFloat(-1, 1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            DataBufferFloat e = new DataBufferFloat(1, -1);
        }
        catch (NegativeArraySizeException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

