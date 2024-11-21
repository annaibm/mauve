/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.SinglePixelPackedSampleModel;

public class createDataBuffer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testInt(harness);
        this.testUShort(harness);
        this.testByte(harness);
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("TYPE_INT");
        int[] bitMasks = new int[]{65280, 255};
        SinglePixelPackedSampleModel sm = new SinglePixelPackedSampleModel(3, 51, 83, bitMasks);
        DataBuffer dbuf = sm.createDataBuffer();
        harness.check(dbuf instanceof DataBufferInt);
        harness.check(dbuf.getDataType(), 3);
        harness.check(dbuf.getNumBanks(), 1);
        harness.check(dbuf.getOffset(), 0);
        harness.check(dbuf.getSize(), 4233);
        sm = new SinglePixelPackedSampleModel(3, 51, 83, 91, bitMasks);
        dbuf = sm.createDataBuffer();
        harness.check(dbuf.getSize(), 7513);
    }

    private void testUShort(TestHarness harness) {
        harness.checkPoint("TYPE_USHORT");
        int[] bitMasks = new int[]{3840, 61440};
        SinglePixelPackedSampleModel sm = new SinglePixelPackedSampleModel(1, 42, 10, bitMasks);
        DataBuffer dbuf = sm.createDataBuffer();
        harness.check(dbuf instanceof DataBufferUShort);
        harness.check(dbuf.getDataType(), 1);
        harness.check(dbuf.getNumBanks(), 1);
        harness.check(dbuf.getOffset(), 0);
        harness.check(dbuf.getSize(), 420);
        sm = new SinglePixelPackedSampleModel(1, 42, 10, 31, bitMasks);
        dbuf = sm.createDataBuffer();
        harness.check(dbuf.getSize(), 321);
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("TYPE_BYTE");
        int[] bitMasks = new int[]{240, 8, 6, 1};
        SinglePixelPackedSampleModel sm = new SinglePixelPackedSampleModel(0, 5, 3, bitMasks);
        DataBuffer dbuf = sm.createDataBuffer();
        harness.check(dbuf instanceof DataBufferByte);
        harness.check(dbuf.getDataType(), 0);
        harness.check(dbuf.getNumBanks(), 1);
        harness.check(dbuf.getOffset(), 0);
        harness.check(dbuf.getSize(), 15);
        sm = new SinglePixelPackedSampleModel(1, 5, 3, 7, bitMasks);
        dbuf = sm.createDataBuffer();
        harness.check(dbuf.getSize(), 19);
    }
}

