/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.ComponentColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.color.ColorSpace;
import java.awt.image.ComponentColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.PixelInterleavedSampleModel;
import java.awt.image.SampleModel;
import java.util.Arrays;

public class createCompatibleSampleModel
implements Testlet {
    @Override
    public void test(TestHarness h) {
        this.test_BYTE(h);
        this.test_USHORT(h);
        this.test_SHORT(h);
        this.test_INT(h);
        this.test_FLOAT(h);
        this.test_DOUBLE(h);
    }

    private void test_BYTE(TestHarness h) {
        h.checkPoint("BYTE");
        SampleModel sm = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{2, 2, 2}, false, false, 1, 0).createCompatibleSampleModel(2, 3);
        h.check(sm instanceof PixelInterleavedSampleModel);
        h.check(sm.getTransferType(), 0);
        h.check(sm.getWidth(), 2);
        h.check(sm.getHeight(), 3);
        h.check(sm.getNumBands(), 3);
        h.check(Arrays.equals(sm.getSampleSize(), new int[]{8, 8, 8}));
        h.check(((ComponentSampleModel)sm).getOffset(1, 1), 9);
        h.check(Arrays.equals(((ComponentSampleModel)sm).getBandOffsets(), new int[]{0, 1, 2}));
        h.check(sm.createDataBuffer().getSize(), 18);
    }

    private void test_USHORT(TestHarness h) {
        h.checkPoint("USHORT");
        SampleModel sm = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{8, 2, 3, 1}, true, false, 2, 1).createCompatibleSampleModel(4, 3);
        h.check(sm instanceof PixelInterleavedSampleModel);
        h.check(sm.getTransferType(), 1);
        h.check(sm.getWidth(), 4);
        h.check(sm.getHeight(), 3);
        h.check(sm.getNumBands(), 4);
        h.check(Arrays.equals(sm.getSampleSize(), new int[]{16, 16, 16, 16}));
        h.check(((ComponentSampleModel)sm).getOffset(1, 1), 20);
        h.check(Arrays.equals(((ComponentSampleModel)sm).getBandOffsets(), new int[]{0, 1, 2, 3}));
        h.check(sm.createDataBuffer().getSize(), 48);
    }

    private void test_SHORT(TestHarness h) {
        h.checkPoint("SHORT");
        SampleModel sm = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{5, 5, 6}, false, false, 1, 2).createCompatibleSampleModel(2, 3);
        h.check(sm.getClass(), ComponentSampleModel.class);
        h.check(sm.getTransferType(), 2);
        h.check(sm.getWidth(), 2);
        h.check(sm.getHeight(), 3);
        h.check(sm.getNumBands(), 3);
        h.check(Arrays.equals(sm.getSampleSize(), new int[]{16, 16, 16}));
        h.check(((ComponentSampleModel)sm).getOffset(1, 1), 9);
        h.check(Arrays.equals(((ComponentSampleModel)sm).getBandOffsets(), new int[]{0, 1, 2}));
        h.check(sm.createDataBuffer().getSize(), 18);
    }

    private void test_INT(TestHarness h) {
        h.checkPoint("INT");
        SampleModel sm = new ComponentColorModel(ColorSpace.getInstance(1003), new int[]{24}, false, false, 1, 3).createCompatibleSampleModel(2, 3);
        h.check(sm.getClass(), ComponentSampleModel.class);
        h.check(sm.getTransferType(), 3);
        h.check(sm.getWidth(), 2);
        h.check(sm.getHeight(), 3);
        h.check(sm.getNumBands(), 1);
        h.check(Arrays.equals(sm.getSampleSize(), new int[]{32}));
        h.check(((ComponentSampleModel)sm).getOffset(1, 1), 3);
        h.check(Arrays.equals(((ComponentSampleModel)sm).getBandOffsets(), new int[]{0}));
        h.check(sm.createDataBuffer().getSize(), 6);
    }

    private void test_FLOAT(TestHarness h) {
        h.checkPoint("FLOAT");
        SampleModel sm = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{32, 32, 32, 32}, true, false, 3, 4).createCompatibleSampleModel(4, 2);
        h.check(sm.getClass(), ComponentSampleModel.class);
        h.check(sm.getTransferType(), 4);
        h.check(sm.getWidth(), 4);
        h.check(sm.getHeight(), 2);
        h.check(sm.getNumBands(), 4);
        h.check(Arrays.equals(sm.getSampleSize(), new int[]{32, 32, 32, 32}));
        h.check(((ComponentSampleModel)sm).getOffset(3, 1), 28);
        h.check(Arrays.equals(((ComponentSampleModel)sm).getBandOffsets(), new int[]{0, 1, 2, 3}));
        h.check(sm.createDataBuffer().getSize(), 32);
    }

    private void test_DOUBLE(TestHarness h) {
        h.checkPoint("DOUBLE");
        SampleModel sm = new ComponentColorModel(ColorSpace.getInstance(1000), new int[]{64, 64, 64, 64}, true, true, 3, 5).createCompatibleSampleModel(2, 2);
        h.check(sm.getClass(), ComponentSampleModel.class);
        h.check(sm.getTransferType(), 5);
        h.check(sm.getWidth(), 2);
        h.check(sm.getHeight(), 2);
        h.check(sm.getNumBands(), 4);
        h.check(Arrays.equals(sm.getSampleSize(), new int[]{64, 64, 64, 64}));
        h.check(((ComponentSampleModel)sm).getOffset(1, 1), 12);
        h.check(Arrays.equals(((ComponentSampleModel)sm).getBandOffsets(), new int[]{0, 1, 2, 3}));
        h.check(sm.createDataBuffer().getSize(), 16);
    }
}

