/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.SinglePixelPackedSampleModel;

public class getPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 2, 2, new int[]{240, 15});
        DataBufferByte db = new DataBufferByte(new byte[]{18, 52, -85, -51}, 4);
        int[] samples = m1.getPixel(1, 1, (int[])null, (DataBuffer)db);
        harness.check(samples[0], 12);
        harness.check(samples[1], 13);
        try {
            samples = m1.getPixel(-2, 0, (int[])null, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            samples = m1.getPixel(0, -1, (int[])null, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        int[] samplesIn = new int[2];
        int[] samplesOut = m1.getPixel(1, 1, samplesIn, (DataBuffer)db);
        harness.check(samplesIn == samplesOut);
        harness.check(samplesOut[0], 12);
        harness.check(samplesOut[1], 13);
        int[] samplesIn2 = new int[1];
        try {
            m1.getPixel(1, 1, samplesIn2, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            samples = m1.getPixel(0, 0, (int[])null, (DataBuffer)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

