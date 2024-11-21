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

public class setPixel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testByte(harness);
        this.testUShort(harness);
        this.testInt(harness);
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("(int, int, Object, DataBuffer(Byte))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 2, 3, new int[]{240, 15});
        byte[] b = new byte[]{17, 34, 51, 68, 85, 102};
        DataBufferByte db = new DataBufferByte(b, 6);
        m1.setPixel(0, 0, new int[]{12, 7}, (DataBuffer)db);
        m1.setPixel(1, 0, new int[]{11, 8}, (DataBuffer)db);
        m1.setPixel(0, 1, new int[]{10, 9}, (DataBuffer)db);
        m1.setPixel(1, 1, new int[]{9, 10}, (DataBuffer)db);
        m1.setPixel(0, 2, new int[]{8, 11}, (DataBuffer)db);
        m1.setPixel(1, 2, new int[]{7, 12}, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 199);
        harness.check(((DataBuffer)db).getElem(1), 184);
        harness.check(((DataBuffer)db).getElem(2), 169);
        harness.check(((DataBuffer)db).getElem(3), 154);
        harness.check(((DataBuffer)db).getElem(4), 139);
        harness.check(((DataBuffer)db).getElem(5), 124);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(0, 2, 2, 3, new int[]{240, 15});
        m2.setPixel(0, 0, new int[]{4, 1}, (DataBuffer)db);
        m2.setPixel(1, 0, new int[]{3, 2}, (DataBuffer)db);
        m2.setPixel(0, 1, new int[]{2, 3}, (DataBuffer)db);
        m2.setPixel(1, 1, new int[]{1, 4}, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 65);
        harness.check(((DataBuffer)db).getElem(1), 50);
        harness.check(((DataBuffer)db).getElem(3), 35);
        harness.check(((DataBuffer)db).getElem(4), 20);
        try {
            m1.setPixel(-1, 0, new int[]{16, 1}, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, -1, new int[]{16, 1}, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, 0, new int[0], (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, 0, new int[]{16, 1}, (DataBuffer)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testUShort(TestHarness harness) {
        harness.checkPoint("(int, int, Object, DataBuffer(UShort))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(1, 2, 3, new int[]{65280, 255});
        short[] s = new short[]{4369, 8738, 13107, 17476, 21845, 26214};
        DataBufferUShort db = new DataBufferUShort(s, 6);
        m1.setPixel(0, 0, new int[]{204, 119}, (DataBuffer)db);
        m1.setPixel(1, 0, new int[]{187, 136}, (DataBuffer)db);
        m1.setPixel(0, 1, new int[]{170, 153}, (DataBuffer)db);
        m1.setPixel(1, 1, new int[]{153, 170}, (DataBuffer)db);
        m1.setPixel(0, 2, new int[]{136, 187}, (DataBuffer)db);
        m1.setPixel(1, 2, new int[]{119, 204}, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 52343);
        harness.check(((DataBuffer)db).getElem(1), 48008);
        harness.check(((DataBuffer)db).getElem(2), 43673);
        harness.check(((DataBuffer)db).getElem(3), 39338);
        harness.check(((DataBuffer)db).getElem(4), 35003);
        harness.check(((DataBuffer)db).getElem(5), 30668);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(1, 2, 2, 3, new int[]{65280, 255});
        m2.setPixel(0, 0, new int[]{68, 17}, (DataBuffer)db);
        m2.setPixel(1, 0, new int[]{51, 34}, (DataBuffer)db);
        m2.setPixel(0, 1, new int[]{34, 51}, (DataBuffer)db);
        m2.setPixel(1, 1, new int[]{17, 68}, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 17425);
        harness.check(((DataBuffer)db).getElem(1), 13090);
        harness.check(((DataBuffer)db).getElem(3), 8755);
        harness.check(((DataBuffer)db).getElem(4), 4420);
        try {
            m1.setPixel(-1, 0, new int[]{16, 1}, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, -1, new int[]{16, 1}, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, 0, new int[0], (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, 0, new int[]{16, 1}, (DataBuffer)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("(int, int, Object, DataBuffer(Int))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(3, 2, 3, new int[]{-65536, 65535});
        int[] i = new int[]{4369, 8738, 13107, 17476, 21845, 26214};
        DataBufferInt db = new DataBufferInt(i, 6);
        m1.setPixel(0, 0, new int[]{204, 119}, (DataBuffer)db);
        m1.setPixel(1, 0, new int[]{187, 136}, (DataBuffer)db);
        m1.setPixel(0, 1, new int[]{170, 153}, (DataBuffer)db);
        m1.setPixel(1, 1, new int[]{153, 170}, (DataBuffer)db);
        m1.setPixel(0, 2, new int[]{136, 187}, (DataBuffer)db);
        m1.setPixel(1, 2, new int[]{119, 204}, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 0xCC0077);
        harness.check(((DataBuffer)db).getElem(1), 0xBB0088);
        harness.check(((DataBuffer)db).getElem(2), 0xAA0099);
        harness.check(((DataBuffer)db).getElem(3), 0x9900AA);
        harness.check(((DataBuffer)db).getElem(4), 0x8800BB);
        harness.check(((DataBuffer)db).getElem(5), 0x7700CC);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(3, 2, 2, 3, new int[]{-65536, 65535});
        m2.setPixel(0, 0, new int[]{68, 17}, (DataBuffer)db);
        m2.setPixel(1, 0, new int[]{51, 34}, (DataBuffer)db);
        m2.setPixel(0, 1, new int[]{34, 51}, (DataBuffer)db);
        m2.setPixel(1, 1, new int[]{17, 68}, (DataBuffer)db);
        harness.check(((DataBuffer)db).getElem(0), 0x440011);
        harness.check(((DataBuffer)db).getElem(1), 0x330022);
        harness.check(((DataBuffer)db).getElem(3), 0x220033);
        harness.check(((DataBuffer)db).getElem(4), 0x110044);
        try {
            m1.setPixel(-1, 0, new int[]{16, 1}, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, -1, new int[]{16, 1}, (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, 0, new int[0], (DataBuffer)db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setPixel(0, 0, new int[]{16, 1}, (DataBuffer)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

