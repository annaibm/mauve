/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.SinglePixelPackedSampleModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.SinglePixelPackedSampleModel;

public class getDataElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testByte(harness);
        this.testUShort(harness);
        this.testInt(harness);
    }

    private void testByte(TestHarness harness) {
        harness.checkPoint("(int, int, Object, DataBuffer(Byte))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(0, 2, 2, new int[]{224, 28, 3});
        byte[] b = new byte[]{11, 22, 33, 44};
        DataBufferByte db = new DataBufferByte(b, 4);
        byte[] de = (byte[])m1.getDataElements(1, 1, null, db);
        harness.check(de.length, 1);
        harness.check(de[0], 44);
        try {
            m1.getDataElements(2, 2, null, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(1, 1, new byte[0], db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(1, 1, new int[1], db);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(0, 0, null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testUShort(TestHarness harness) {
        harness.checkPoint("(int, int, Object, DataBuffer(UShort))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(1, 2, 2, new int[]{224, 28, 3});
        short[] s = new short[]{11, 22, 33, 44};
        DataBufferUShort db = new DataBufferUShort(s, 4);
        short[] de = (short[])m1.getDataElements(1, 1, null, db);
        harness.check(de.length, 1);
        harness.check(de[0], 44);
        try {
            m1.getDataElements(2, 2, null, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(1, 1, new short[0], db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(1, 1, new int[1], db);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(0, 0, null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }

    private void testInt(TestHarness harness) {
        harness.checkPoint("(int, int, Object, DataBuffer(Int))");
        SinglePixelPackedSampleModel m1 = new SinglePixelPackedSampleModel(3, 2, 2, new int[]{224, 28, 3});
        int[] i = new int[]{11, 22, 33, 44};
        DataBufferInt db = new DataBufferInt(i, 4);
        int[] de = (int[])m1.getDataElements(1, 1, null, db);
        harness.check(de.length, 1);
        harness.check(de[0], 44);
        try {
            m1.getDataElements(2, 2, null, db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(1, 1, new int[0], db);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(1, 1, new byte[1], db);
            harness.check(false);
        }
        catch (ClassCastException e) {
            harness.check(true);
        }
        try {
            m1.getDataElements(0, 0, null, null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
    }
}

