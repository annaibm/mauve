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

public class setSample
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testByte(harness);
        this.testUShort(harness);
        this.testInt(harness);
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, DataBuffer(Byte))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 2, 3, new int[]{240, 15});
        byte[] b = new byte[]{17, 34, 51, 68, 85, 102};
        DataBufferByte db = new DataBufferByte(b, 6);
        m1.setSample(0, 0, 1, 7, (DataBuffer)db);
        m1.setSample(1, 0, 1, 8, (DataBuffer)db);
        m1.setSample(0, 1, 1, 9, (DataBuffer)db);
        m1.setSample(1, 1, 1, 10, (DataBuffer)db);
        m1.setSample(0, 2, 1, 11, (DataBuffer)db);
        m1.setSample(1, 2, 1, 12, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 23);
        harness.check(((DataBuffer)db).getElem(1), 40);
        harness.check(((DataBuffer)db).getElem(2), 57);
        harness.check(((DataBuffer)db).getElem(3), 74);
        harness.check(((DataBuffer)db).getElem(4), 91);
        harness.check(((DataBuffer)db).getElem(5), 108);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(0, 2, 2, 3, new int[]{240, 15});
        m2.setSample(0, 0, 0, 4, (DataBuffer)db);
        m2.setSample(1, 0, 0, 3, (DataBuffer)db);
        m2.setSample(0, 1, 0, 2, (DataBuffer)db);
        m2.setSample(1, 1, 0, 1, (DataBuffer)db);
        m2.setSample(0, 0, 1, 1, (DataBuffer)db);
        m2.setSample(1, 0, 1, 2, (DataBuffer)db);
        m2.setSample(0, 1, 1, 3, (DataBuffer)db);
        m2.setSample(1, 1, 1, 4, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 65);
        harness.check(((DataBuffer)db).getElem(1), 50);
        harness.check(((DataBuffer)db).getElem(3), 35);
        harness.check(((DataBuffer)db).getElem(4), 20);
        try {
            m1.setSample(-1, 0, 0, 16, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, -1, 0, 16, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, 0, -1, 16, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, 0, 0, 1, (DataBuffer)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testUShort(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, DataBuffer(UShort))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(1, 2, 3, new int[]{65280, 255});
        short[] s = new short[]{4369, 8738, 13107, 17476, 21845, 26214};
        DataBufferUShort db = new DataBufferUShort(s, 6);
        m1.setSample(0, 0, 0, 204, (DataBuffer)db);
        m1.setSample(1, 0, 0, 187, (DataBuffer)db);
        m1.setSample(0, 1, 0, 170, (DataBuffer)db);
        m1.setSample(1, 1, 0, 153, (DataBuffer)db);
        m1.setSample(0, 2, 0, 136, (DataBuffer)db);
        m1.setSample(1, 2, 0, 119, (DataBuffer)db);
        m1.setSample(0, 0, 1, 119, (DataBuffer)db);
        m1.setSample(1, 0, 1, 136, (DataBuffer)db);
        m1.setSample(0, 1, 1, 153, (DataBuffer)db);
        m1.setSample(1, 1, 1, 170, (DataBuffer)db);
        m1.setSample(0, 2, 1, 187, (DataBuffer)db);
        m1.setSample(1, 2, 1, 204, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 52343);
        harness.check(((DataBuffer)db).getElem(1), 48008);
        harness.check(((DataBuffer)db).getElem(2), 43673);
        harness.check(((DataBuffer)db).getElem(3), 39338);
        harness.check(((DataBuffer)db).getElem(4), 35003);
        harness.check(((DataBuffer)db).getElem(5), 30668);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(1, 2, 2, 3, new int[]{65280, 255});
        m2.setSample(0, 0, 0, 68, (DataBuffer)db);
        m2.setSample(1, 0, 0, 51, (DataBuffer)db);
        m2.setSample(0, 1, 0, 34, (DataBuffer)db);
        m2.setSample(1, 1, 0, 17, (DataBuffer)db);
        m2.setSample(0, 0, 1, 17, (DataBuffer)db);
        m2.setSample(1, 0, 1, 34, (DataBuffer)db);
        m2.setSample(0, 1, 1, 51, (DataBuffer)db);
        m2.setSample(1, 1, 1, 68, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 17425);
        harness.check(((DataBuffer)db).getElem(1), 13090);
        harness.check(((DataBuffer)db).getElem(3), 8755);
        harness.check(((DataBuffer)db).getElem(4), 4420);
        try {
            m1.setSample(-1, 0, 0, 68, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, -1, 0, 68, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, 0, -1, 68, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, 0, 0, 68, (DataBuffer)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("(int, int, int, int, DataBuffer(Int))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(3, 2, 3, new int[]{-65536, 65535});
        int[] i = new int[]{4369, 8738, 13107, 17476, 21845, 26214};
        DataBufferInt db = new DataBufferInt(i, 6);
        m1.setSample(0, 0, 0, 204, (DataBuffer)db);
        m1.setSample(1, 0, 0, 187, (DataBuffer)db);
        m1.setSample(0, 1, 0, 170, (DataBuffer)db);
        m1.setSample(1, 1, 0, 153, (DataBuffer)db);
        m1.setSample(0, 2, 0, 136, (DataBuffer)db);
        m1.setSample(1, 2, 0, 119, (DataBuffer)db);
        m1.setSample(0, 0, 1, 119, (DataBuffer)db);
        m1.setSample(1, 0, 1, 136, (DataBuffer)db);
        m1.setSample(0, 1, 1, 153, (DataBuffer)db);
        m1.setSample(1, 1, 1, 170, (DataBuffer)db);
        m1.setSample(0, 2, 1, 187, (DataBuffer)db);
        m1.setSample(1, 2, 1, 204, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 0xCC0077);
        harness.check(((DataBuffer)db).getElem(1), 0xBB0088);
        harness.check(((DataBuffer)db).getElem(2), 0xAA0099);
        harness.check(((DataBuffer)db).getElem(3), 0x9900AA);
        harness.check(((DataBuffer)db).getElem(4), 0x8800BB);
        harness.check(((DataBuffer)db).getElem(5), 0x7700CC);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(3, 2, 2, 3, new int[]{-65536, 65535});
        m2.setSample(0, 0, 0, 68, (DataBuffer)db);
        m2.setSample(1, 0, 0, 51, (DataBuffer)db);
        m2.setSample(0, 1, 0, 34, (DataBuffer)db);
        m2.setSample(1, 1, 0, 17, (DataBuffer)db);
        m2.setSample(0, 0, 1, 17, (DataBuffer)db);
        m2.setSample(1, 0, 1, 34, (DataBuffer)db);
        m2.setSample(0, 1, 1, 51, (DataBuffer)db);
        m2.setSample(1, 1, 1, 68, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 0x440011);
        harness.check(((DataBuffer)db).getElem(1), 0x330022);
        harness.check(((DataBuffer)db).getElem(3), 0x220033);
        harness.check(((DataBuffer)db).getElem(4), 0x110044);
        try {
            m1.setSample(-1, 0, 0, 16, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, -1, 0, 16, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, 0, -1, 16, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setSample(0, 0, 0, 16, (DataBuffer)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

