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

public class setDataElements
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
        m1.setDataElements(0, 0, new byte[]{119}, db);
        m1.setDataElements(1, 0, new byte[]{-120}, db);
        m1.setDataElements(0, 1, new byte[]{-103}, db);
        m1.setDataElements(1, 1, new byte[]{-86}, db);
        m1.setDataElements(0, 2, new byte[]{-69}, db);
        m1.setDataElements(1, 2, new byte[]{-52}, db);
        harness.check(((DataBuffer)db).getElem(0), 119);
        harness.check(((DataBuffer)db).getElem(1), 136);
        harness.check(((DataBuffer)db).getElem(2), 153);
        harness.check(((DataBuffer)db).getElem(3), 170);
        harness.check(((DataBuffer)db).getElem(4), 187);
        harness.check(((DataBuffer)db).getElem(5), 204);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(0, 2, 2, 3, new int[]{240, 15});
        m2.setDataElements(0, 0, new byte[]{17}, db);
        m2.setDataElements(1, 0, new byte[]{34}, db);
        m2.setDataElements(0, 1, new byte[]{51}, db);
        m2.setDataElements(1, 1, new byte[]{68}, db);
        harness.check(((DataBuffer)db).getElem(0), 17);
        harness.check(((DataBuffer)db).getElem(1), 34);
        harness.check(((DataBuffer)db).getElem(3), 51);
        harness.check(((DataBuffer)db).getElem(4), 68);
        try {
            m1.setDataElements(-1, 0, new byte[]{-103}, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, -1, new byte[]{-103}, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new int[]{153}, db);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new byte[0], db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new byte[]{-103}, null);
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
        m1.setDataElements(0, 0, new short[]{30583}, db);
        m1.setDataElements(1, 0, new short[]{-30584}, db);
        m1.setDataElements(0, 1, new short[]{-26215}, db);
        m1.setDataElements(1, 1, new short[]{-21846}, db);
        m1.setDataElements(0, 2, new short[]{-17477}, db);
        m1.setDataElements(1, 2, new short[]{-13108}, db);
        harness.check(((DataBuffer)db).getElem(0), 30583);
        harness.check(((DataBuffer)db).getElem(1), 34952);
        harness.check(((DataBuffer)db).getElem(2), 39321);
        harness.check(((DataBuffer)db).getElem(3), 43690);
        harness.check(((DataBuffer)db).getElem(4), 48059);
        harness.check(((DataBuffer)db).getElem(5), 52428);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(1, 2, 2, 3, new int[]{65280, 255});
        m2.setDataElements(0, 0, new short[]{4369}, db);
        m2.setDataElements(1, 0, new short[]{8738}, db);
        m2.setDataElements(0, 1, new short[]{13107}, db);
        m2.setDataElements(1, 1, new short[]{17476}, db);
        harness.check(((DataBuffer)db).getElem(0), 4369);
        harness.check(((DataBuffer)db).getElem(1), 8738);
        harness.check(((DataBuffer)db).getElem(3), 13107);
        harness.check(((DataBuffer)db).getElem(4), 17476);
        try {
            m1.setDataElements(-1, 0, new short[]{-26215}, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, -1, new short[]{-26215}, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new int[]{39321}, db);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new short[0], db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new short[]{-26215}, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("(int, int, Object, DataBuffer(Int))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(3, 2, 3, new int[]{0xFFFF00, 65535});
        int[] i = new int[]{0x11111111, 0x22222222, 0x33333333, 0x44444444, 0x55555555, 0x66666666};
        DataBufferInt db = new DataBufferInt(i, 6);
        m1.setDataElements(0, 0, new int[]{0x77777777}, db);
        m1.setDataElements(1, 0, new int[]{-2004318072}, db);
        m1.setDataElements(0, 1, new int[]{-1717986919}, db);
        m1.setDataElements(1, 1, new int[]{-1431655766}, db);
        m1.setDataElements(0, 2, new int[]{-1145324613}, db);
        m1.setDataElements(1, 2, new int[]{-858993460}, db);
        harness.check(((DataBuffer)db).getElem(0), 0x77777777);
        harness.check(((DataBuffer)db).getElem(1), -2004318072);
        harness.check(((DataBuffer)db).getElem(2), -1717986919);
        harness.check(((DataBuffer)db).getElem(3), -1431655766);
        harness.check(((DataBuffer)db).getElem(4), -1145324613);
        harness.check(((DataBuffer)db).getElem(5), -858993460);
        SinglePixelPackedSampleModel m2 = new SinglePixelPackedSampleModel(3, 2, 2, 3, new int[]{0xFFFF00, 65535});
        m2.setDataElements(0, 0, new int[]{0x11111111}, db);
        m2.setDataElements(1, 0, new int[]{0x22222222}, db);
        m2.setDataElements(0, 1, new int[]{0x33333333}, db);
        m2.setDataElements(1, 1, new int[]{0x44444444}, db);
        harness.check(((DataBuffer)db).getElem(0), 0x11111111);
        harness.check(((DataBuffer)db).getElem(1), 0x22222222);
        harness.check(((DataBuffer)db).getElem(3), 0x33333333);
        harness.check(((DataBuffer)db).getElem(4), 0x44444444);
        try {
            m1.setDataElements(-1, 0, new int[]{39321}, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, -1, new int[]{39321}, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new short[]{-26215}, db);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new int[0], db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.setDataElements(0, 0, new int[]{39321}, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

